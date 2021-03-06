package nero.springbootstudy.config;

import nero.springbootstudy.model.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//指定身份：拦截Controller中web请求的类
@ControllerAdvice
public class AppControllerAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 异常：
     * （1）自定义异常：可以携带自定义的错误信息->中文，可以给用户看的
     * （2）JDK和框架，程序代码运行时抛出：携带的错误信息，一般都是英文，用户看不了，
     * web项目中所起的作用：
     * @param
     * @return
     */

    //指定处理请求方法中抛出的异常
    @ExceptionHandler(Exception.class)//如果有多个异常，在Exception.class外加{}，如果只拦截一个异常，可以去掉{}
    @ResponseBody
    public Object handle(Exception e){
        e.printStackTrace();
        return null;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;//执行controller中的web请求方法结束，返回数据到前端时，是否需要重写响应体
    }

    @Override
    public ResponseResult beforeBodyWrite(Object responseResult, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果存在返回字符串的情况，需要返回字符串类型，否则会报错
        //解决方案：判断Body对象的类型，如果是字符串，就返回ObjectMapper序列化后的字符串，否则返回统一封装的类型
        ResponseResult r = new ResponseResult();
        r.setSuccess(true);
        r.setData(responseResult);
        System.out.println(r);
        return r;
    }
}
