package br.com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.ClienteBO;
import br.com.entidade.Cliente;

public class ClienteServlet extends HttpServlet {
	private String acao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao=req.getParameter("acao");
		
		Cliente cliente= new Cliente();
		ClienteBO clientebo = new ClienteBO();
		
		if(acao.equals("cadastrar")){
			
			cliente.setNome(req.getParameter("nome"));
			cliente.setIdade(Integer.parseInt(req.getParameter("idade")));
			cliente.setCPF(req.getParameter("cpf"));
			clientebo.cadastrar(cliente);
		
			
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	

}
