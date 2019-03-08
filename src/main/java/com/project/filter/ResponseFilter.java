package com.project.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ResponseFilter implements Filter {

    private static ThreadLocal<HttpServletResponse> localRequest = new ThreadLocal<HttpServletResponse>();


    public static HttpServletResponse getResponse() {
        return localRequest.get();
    }

    /*public static HttpServletResponse getSession() {
        HttpServletResponse response = localRequest.get();
        //return (response != null) ? response.get : null;
        return response;
    }*/


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            localRequest.set((HttpServletResponse) servletResponse);
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            localRequest.remove();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
