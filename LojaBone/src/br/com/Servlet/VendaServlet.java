package br.com.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.BoneBO;
import br.com.BO.ClienteBO;
import br.com.BO.VendaBo;
import br.com.entidade.Bone;
import br.com.entidade.Cliente;
import br.com.entidade.Venda;



public class VendaServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		Cliente cliente = new Cliente();
		ClienteBO clientebo = new ClienteBO();
		Bone bone = new Bone();
		BoneBO bonebo = new BoneBO();
		Venda venda = new Venda();
		VendaBo vendabo = new VendaBo();

		if (req.getParameter("acao").equals("realizaVenda")) {

			cliente.setIdcliente(Integer.parseInt(req.getParameter("idcliente")));

			bone.setIdbone(Integer.parseInt(req.getParameter("id")));

			venda.setBone(bone);
			venda.setCliente(cliente);
			venda.setDescricao(req.getParameter("descricao"));

			vendabo.realizaVenda(venda);

			resp.sendRedirect("/LojaBone/venda?acao=listar");
		}

		if (req.getParameter("acao").equals("listar")) {

			List<Venda> vendas = vendabo.listar();

			req.setAttribute("lista", vendas);

			req.getRequestDispatcher("JSP/Venda/Listar.jsp").forward(req, resp);
		}
		 if(req.getParameter("acao").equals("excluir")){
				
				venda.setIdvenda(Integer.parseInt(req.getParameter("id")));
				vendabo.excluir(venda);
				resp.sendRedirect("/LojaBone/venda?acao=listar");
			}

		if (req.getParameter("acao").equals("vender")) {

			List<Cliente> clientes = null;
			clientes = clientebo.ListarTodos();

			req.setAttribute("clientes", clientes);

			List<Bone> bones = null;
			bones = bonebo.ListarTodos();

			req.setAttribute("bones", bones);

			req.getRequestDispatcher("JSP/Venda/RealizarVenda.jsp").forward(req,resp);
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);

	}

}