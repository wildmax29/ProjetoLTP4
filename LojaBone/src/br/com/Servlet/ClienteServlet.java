package br.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

import br.com.BO.ClienteBO;
import br.com.entidade.Cliente;

public class ClienteServlet extends HttpServlet {
	private String acao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao=req.getParameter("acao");
		HttpSession session = req.getSession();
		Cliente cliente= new Cliente();
		ClienteBO clientebo = new ClienteBO();
			
		
		if(acao.equals("cadastrar")){
			
			cliente.setNome(req.getParameter("nome"));
			cliente.setIdade(Integer.parseInt(req.getParameter("idade")));
			cliente.setCPF(req.getParameter("cpf"));
			clientebo.cadastrar(cliente);
			resp.sendRedirect("/LojaBone/cliente?acao=Listar");
			
		}else if(acao.equals("Listar")){
			List<Cliente> clientes;
			clientes = clientebo.ListarTodos();
			req.setAttribute("clientes", clientes);
			req.getRequestDispatcher("JSP/Cliente/Listar.jsp").forward(req, resp);
			
			
		}else if(acao.equals("consultar")){
			cliente=clientebo.ConsultarPorId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("cliente", cliente);
			req.getRequestDispatcher("/JSP/Cliente/AlterarCliente.jsp").forward(req, resp);
			
		}else if(acao.equals("alterar")){
			cliente.setNome(req.getParameter("nome"));
			cliente.setIdade(Integer.parseInt(req.getParameter("idade")));
			cliente.setCPF(req.getParameter("cpf"));
			cliente.setIdcliente(Integer.parseInt(req.getParameter("Id")));
			clientebo.alterar(cliente);
			resp.sendRedirect("/LojaBone/cliente?acao=Listar");			
			
			
		}else if(acao.equals("deletar")){
			cliente = clientebo.ConsultarPorId(Integer.parseInt(req.getParameter("id")));
			clientebo.excluir(cliente);
			resp.sendRedirect("/LojaBone/cliente?acao=Listar");
		}
		
		else{
			System.out.println("Não encontrada nenhuma ação");
		}
				}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	

}