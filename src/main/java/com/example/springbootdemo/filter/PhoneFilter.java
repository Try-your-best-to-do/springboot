package com.example.springbootdemo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.apache.logging.log4j.*;

@WebFilter(filterName = "phoneFilter",urlPatterns = "/index")
public class PhoneFilter implements Filter {
    //需要添加的代码
    Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-------------------------------------------init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String requestURL = req.getRequestURI();
        servletRequest.getRequestDispatcher("/count").forward(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
