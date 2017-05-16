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

import com.bms.BMSContext;
import com.bms.Constants;
import com.bms.po.Admin;
import com.bms.po.User;

public class BMSContextFilter implements Filter {

    public BMSContextFilter() {

    }

    @Override
    public void destroy() {


    }

    @SuppressWarnings("static-access")
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        BMSContext bmsContext = BMSContext.getBMSContext();
        bmsContext.setContextPath(req.getContextPath());
        bmsContext.addObject(Constants.BMS_CONTEXT_REQUEST, req);
        bmsContext.addObject(Constants.BMS_CONTEXT_RESPONSE, res);
        HttpSession session = req.getSession();
        if (bmsContext.getObject(Constants.BMS_CONTEXT_SESSION) == null) {
            bmsContext.addObject(Constants.BMS_CONTEXT_SESSION, session);
        }
        User user = (User) session.getAttribute(Constants.BMS_CONTEXT_USER);
        Admin admin = (Admin)session.getAttribute(Constants.BMS_ADMIN);
        bmsContext.addObject(Constants.BMS_CONTEXT_USER, user);
        bmsContext.addObject(Constants.BMS_ADMIN, admin);
        try {
            chain.doFilter(req, res);
        } finally {
            bmsContext.clear();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

}
