package br.com.Servlet;

import java.io.IOException;  
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.BO.ClienteBO;
import br.com.Exception.CampoClienteVazioException;
import br.com.Exception.ClienteJaExiteException;
import br.com.Exception.NomeClienteIncompletoException;
import br.com.Exception.ValorInvalidoException;
import br.com.entidade.Cliente;

public class ClienteServlet extends HttpServlet {
	private String acao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao=req.getParameter("acao");
		HttpSession session = req.getSession();
		Cliente cliente= new Cliente();
		ClienteBO clientebo = new ClienteBO();
		String msg = null;
			
		
		if(acao.equals("cadastrar")){
			try{
			cliente.setNome(req.getParameter("nome"));
			cliente.setIdade(Integer.parseInt(clientebo.consultaIdade(req.getParameter("idade"))));
			cliente.setCPF(req.getParameter("cpf"));
			clientebo.cadastrar(cliente);
			resp.sendRedirect("/LojaBone/cliente?acao=Listar");
			} catch (SQLException  e) {
				msg = "Erro ao inserir um novo usuario!!";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}catch( CampoClienteVazioException e){
				msg = "Por favor preencha os campos vazios";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}catch(ClienteJaExiteException e){
				msg = "Cliente já cadastrado";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}catch(NomeClienteIncompletoException e){
				msg = "Por favor digite nome completo do cliente";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
				
			} catch (ValorInvalidoException e) {
				msg = "Valor inválido na idade!";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}
			
			
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
			
			try {
				cliente.setNome(req.getParameter("nome"));
				cliente.setIdade(Integer.parseInt(clientebo.consultaIdade(req.getParameter("idade"))));
				cliente.setCPF(req.getParameter("cpf"));
				cliente.setIdcliente(Integer.parseInt(req.getParameter("Id")));
				clientebo.alterar(cliente);
				resp.sendRedirect("/LojaBone/cliente?acao=Listar");			
			} catch (SQLException  e) {
				msg = "Erro ao inserir um novo usuario!!";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}catch( CampoClienteVazioException e){
				msg = "Por favor preencha os campos vazios";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}catch(ClienteJaExiteException e){
				msg = "Cliente já cadastrado";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}catch(NomeClienteIncompletoException e){
				msg = "Por favor digite nome completo do cliente";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
				
			} catch (ValorInvalidoException e) {
				msg = "Valor inválido na idade! Por favor digite número inteiro";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}
			
			
			
		}else if(acao.equals("deletar")){
			cliente = clientebo.ConsultarPorId(Integer.parseInt(req.getParameter("id")));
			if(clientebo.verificarParaExcluir(cliente.getIdcliente())){
			clientebo.excluir(cliente);
			resp.sendRedirect("/LojaBone/cliente?acao=Listar");
			}else{
				msg = "Cliente não pode ser excluido pois existe vinculo com a venda (Acesse o cadastro de venda e deleta a venda vinculada ao cliente)";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}
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