package br.com.Filter;

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

public class FiltroLogin implements Filter{

	@Override
	public void destroy() {
		
		
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		String url = httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession();
		
		if(sessao.getAttribute("usuario")!=null || url.lastIndexOf("Login.jsp")> -1|| url.lastIndexOf("/Login") >-1){
			chain.doFilter(req, resp);
			
		}else{
			((HttpServletResponse) resp).sendRedirect("/LojaBone/JSP/Login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
