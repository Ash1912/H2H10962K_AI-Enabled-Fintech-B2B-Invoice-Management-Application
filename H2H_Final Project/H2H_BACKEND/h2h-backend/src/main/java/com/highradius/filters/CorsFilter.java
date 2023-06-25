package com.highradius.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class CorsFilter implements Filter {

    public CorsFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.addHeader("Access-Control-Allow-Methods", "GET, POST");
        resp.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");

        chain.doFilter(req, resp);
    }

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
