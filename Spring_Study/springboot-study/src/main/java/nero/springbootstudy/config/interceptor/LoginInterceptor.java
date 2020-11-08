package nero.springbootstudy.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import nero.springbootstudy.model.ResponseResult;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 定义拦截器：
 * 只有配置的拦截路径匹配到请求路径的时候，才会执行拦截器中的方法
 */
public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;
    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     *
     *Controller中请求方法执行前就会调用preHandle，返回值决定是否再继续调用Controller中方法
     * return true; 继续执行Controller中的方法
     * return false;不执行了
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            return true;
        }
        //未登录：可以通过response对象返回json数据，或者重定向到某个页面
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseResult r = new ResponseResult();
        r.setCode("ERRORS 401");
        r.setSuccess(false);
        r.setMessage("无效用户名！");
        String json = objectMapper.writeValueAsString(r);
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();

        return false;
    }

    //Controller中的方法执行完以后才会执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
