package com.qingcha.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}
