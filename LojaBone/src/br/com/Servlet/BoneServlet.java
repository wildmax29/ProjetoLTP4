package br.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.BoneBO;
import br.com.entidade.Bone;

public class BoneServlet extends HttpServlet {
	private String acao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao=req.getParameter("acao");
		HttpSession session = req.getSession();
		Bone bone= new Bone();
		BoneBO bonebo = new BoneBO();
	if((session.getAttribute("usuario")!= null && session.getAttribute("senha")!=null)){	
		if(acao.equals("cadastrar")){
			
			bone.setCor(req.getParameter("cor"));
			bone.setPreco(Integer.parseInt(req.getParameter("preco")));
			bone.setTamanho(req.getParameter("tamanho"));
			bonebo.cadastrar(bone);
			resp.sendRedirect("/LojaBone/bone?acao=ListarBone");
		
			
		}else if(acao.equals("Listar")){
			List<Bone> bones;
			bones = bonebo.ListarTodos();
			req.setAttribute("bones", bones);
			req.getRequestDispatcher("JSP/Bone/ListarBone.jsp").forward(req, resp);
			
		}else if(acao.equals("alterar")){
			bone.setCor(req.getParameter("cor"));
			bone.setPreco(Integer.parseInt(req.getParameter("preco")));
			bone.setTamanho(req.getParameter("tamanho"));
			bone.setIdbone(Integer.parseInt(req.getParameter("Idbone")));
			bonebo.alterar(bone);
			resp.sendRedirect("/LojaBone/bone?acao=ListarBone");			
			
			
		}else if(acao.equals("deletar")){
			bone = bonebo.ConsultarPorIdBone(Integer.parseInt(req.getParameter("idbone")));
			bonebo.excluir(bone);
			resp.sendRedirect("/LojaBone/bone?acao=ListarBone");
		}else{
			System.out.println("Não encontrada nenhuma ação");
		}
	}else{
		resp.sendRedirect("../LojaBone/JSP/Login.jsp");
	}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	
	

}
