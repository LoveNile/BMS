package com.bms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.Constants;

public class BMSBookFilter implements Filter {

    @Override
    public void destroy() {


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute(Constants.BMS_CONTEXT_USER) == null) {
            res.sendRedirect(req.getContextPath() + "/user/login");
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {


    }

}
