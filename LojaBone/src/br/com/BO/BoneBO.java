package br.com.BO;

import java.util.List;

import br.com.Dao.BoneDao;
import br.com.entidade.Bone;
import br.com.entidade.Cliente;

public class BoneBO {
	BoneDao bonedao= new BoneDao();
	
	public void cadastrar(Bone bone) {
		bonedao.cadastrar(bone);
	}

	public List<Bone> ListarTodos() {
		
		return bonedao.listartodos();
	}

	public Bone ConsultarPorIdBone(int Idbone){
		return bonedao.ConsultarPorIdBone(Idbone);
		
	}

	public void alterar(Bone bone) {
		bonedao.alterarbone(bone);
		
	}

	public void excluir(Bone bone) {
		bonedao.excluir(bone);
		
	}

	
}
