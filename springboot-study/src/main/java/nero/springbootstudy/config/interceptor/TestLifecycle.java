//package nero.springbootstudy.config.interceptor;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.*;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TestLifecycle implements BeanNameAware,
//        BeanFactoryAware,
//        ApplicationContextAware,
//        BeanPostProcessor,
//        DisposableBean {
//    /**
//     * BeanFactoryAware接口方法
//     * @param beanFactory
//     * @throws BeansException
//     */
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("setBeanFactory :");
//    }
//
//    /**
//     * BeanNameAware接口方法
//     * @param s
//     */
//    @Override
//    public void setBeanName(String s) {
//        System.out.println("setBeanName :");
//    }
//
//    /**
//     * DisposableBean接口方法
//     * @throws Exception
//     */
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("destroy :");
//    }
//
//    /**
//     * ApplicationContextAware接口方法
//     * @param applicationContext
//     * @throws BeansException
//     */
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("setApplicationContext :" );
//    }
//
//    /**
//     *BeanPostProcessor接口方法
//     * @param bean
//     * @param beanName
//     * @return
//     * @throws BeansException
//     */
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization :" +beanName);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization :" +beanName);
//        return bean;
//    }
//}
