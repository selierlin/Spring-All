package com.example.springbootfilterinterceptor.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//可通过在TimeFilter上加上如下注解，也可以通过配置类，使用FilterRegistrationBean来注册过滤器
// @Component
// @WebFilter(urlPatterns = {"/*"})
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    //通过过滤器我们只可以获取到servletRequest对象，所以并不能获取到方法的名称，所属类，参数等额外的信息。
    //所以还需要使用拦截器来获取
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始执行过滤器");
        Long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("【过滤器】耗时 " + (new Date().getTime() - start));
        System.out.println("结束执行过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
