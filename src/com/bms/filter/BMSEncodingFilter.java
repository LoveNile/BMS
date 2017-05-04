package com.bms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class BMSEncodingFilter implements Filter {

    private String encoding = "UTF-8";
    protected FilterConfig fConfig;
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding(encoding);
        res.setCharacterEncoding(encoding);
        res.setContentType("text/html);charset= UTF-8");
        chain.doFilter(req, res);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("encoding")!=null) {
            encoding = filterConfig.getInitParameter("encoding");
        }
        this.fConfig = filterConfig;
    }

}
