package com.rickhuang.miniprogramspringboot.config.xss;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class XssFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException
			, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		XssHttpServletRequestWrapper wrapper = new XssHttpServletRequestWrapper(request);
		chain.doFilter(wrapper, servletResponse);
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
}
