package com.zzuli.home.filter;

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

import com.zzuli.home.AppConstants;
import com.zzuli.home.AppContext;
import com.zzuli.home.model.User;
import com.zzuli.home.util.PathUtil;

public class SessionFilter implements Filter {
    
    private String notNeedLoginPages = "";
    protected FilterConfig filterConfig;

    public SessionFilter() {
        // empty
    }

    @Override
    public void destroy() {
        // empty
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        AppContext appContext= AppContext.getContext();

        HttpSession session = request.getSession();

        User userCopy = (User)session.getAttribute(AppConstants.USER);
        appContext.addObject(AppConstants.APP_CONTEXT_USER, userCopy);
        appContext.addObject(AppConstants.APP_CONTEXT_SESSION, session);
        
        AppContext.setContextPath(request.getContextPath());
        String uri =  request.getRequestURI();
        String requestedUri = uri.substring(request.getContextPath().length() + 1);
        
        String [] pages = notNeedLoginPages.split(",");
        boolean isAllow = false;
        
        for(String page : pages) {
            if (page.equals(requestedUri)) {
                isAllow = true;
                break;
            }
        }
        
        if (isAllow) {
            filterChain.doFilter(request, response);
        } else {
            User user = (User)session.getAttribute(AppConstants.USER);
            if (user == null) {
                String url = PathUtil.getFullPath("user/login");
                response.sendRedirect(url);
            } else {
                filterChain.doFilter(request, response);
            }
        }
   }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        if(filterConfig.getInitParameter("notNeedLoginPages") != null) {
            notNeedLoginPages = filterConfig.getInitParameter("notNeedLoginPages");
        }

    }

}
