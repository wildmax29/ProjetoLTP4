package br.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.BoneBO;
import br.com.Exception.CampoBoneVazioException;
import br.com.Exception.ValorInvalidoException;
import br.com.entidade.Bone;

public class BoneServlet extends HttpServlet {
	private String acao;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		acao=req.getParameter("acao");
		HttpSession session = req.getSession();
		Bone bone= new Bone();
		BoneBO bonebo = new BoneBO();
		String msg = null;
	
		if(acao.equals("cadastrar")){
			
			
			try {
				bone.setCor(req.getParameter("cor"));
				bone.setPreco(Integer.parseInt(bonebo.consultaValor(req.getParameter("preco"))));
				bone.setTamanho(req.getParameter("tamanho"));
				bonebo.cadastrar(bone);
				resp.sendRedirect("/LojaBone/bone?acao=Listar");
			} catch ( ValorInvalidoException e) {
				msg = "Digite número no campo preço!!";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
						
			}catch (CampoBoneVazioException e){
				msg = "Existe campos não preenchidos, por favor preencha";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("JSP/Problemas/Problema.jsp").forward(req, resp);
			}
			
		
			
		}else if(acao.equals("Listar")){
			List<Bone> bones;
			bones = bonebo.ListarTodos();
			req.setAttribute("bones", bones);
			req.getRequestDispatcher("/JSP/Bone/ListarBone.jsp").forward(req, resp);
			
		}else if(acao.equals("consultar")){
			bone=bonebo.ConsultarPorIdBone(Integer.parseInt(req.getParameter("idbone")));
			req.setAttribute("bone", bone);
			req.getRequestDispatcher("/JSP/Bone/AlterarBone.jsp").forward(req, resp);
			
		}
		else if(acao.equals("alterar")){
			bone.setCor(req.getParameter("cor"));
			bone.setPreco(Float.parseFloat(req.getParameter("preco")));
			bone.setTamanho(req.getParameter("tamanho"));
			bone.setIdbone(Integer.parseInt(req.getParameter("idbone")));
			bonebo.alterar(bone);
			resp.sendRedirect("/LojaBone/bone?acao=Listar");			
			
			
		}else if(acao.equals("deletar")){
			bone = bonebo.ConsultarPorIdBone(Integer.parseInt(req.getParameter("idbone")));
			bonebo.excluir(bone);
			resp.sendRedirect("/LojaBone/bone?acao=Listar");
		}else{
			System.out.println("Não encontrada nenhuma ação");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}	
	

}
