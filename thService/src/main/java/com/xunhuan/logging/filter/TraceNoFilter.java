package com.xunhuan.logging.filter;

import com.xunhuan.logging.TraceNoUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by houzh on 16/11/10.
 */
public class TraceNoFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        TraceNoUtils.newTraceNo();
        try{
            filterChain.doFilter(servletRequest,servletResponse);
        }catch (Exception e){
            TraceNoUtils.clearTraceNo();
        }
    }

    public void destroy() {

    }
}
