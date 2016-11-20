package br.com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private String acao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 if(req.getSession(false) != null){
		 req.getSession().invalidate();
	 }
	 resp.sendRedirect("../LojaBone/JSP/Login.jsp");
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		acao=req.getParameter("acao");
		if(acao.equals("Logar")){
			String usuario=req.getParameter("usuario");
			String senha = req.getParameter("senha");
			if(usuario.equals("max")&&(senha.equals("1234"))){
				req.getSession().setAttribute("usuario",usuario);
				
				req.getRequestDispatcher("/JSP/Menu.jsp").forward(req, resp);
				
			}else{
				resp.sendRedirect("../LojaBone/JSP/Login.jsp");
			}
			
		}else{
			resp.sendRedirect("../LojaBone/JSP/Login.jsp");
		}
	}
	
	

}
