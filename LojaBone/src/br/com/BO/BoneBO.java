package br.com.BO;

import java.util.List;

import br.com.Dao.BoneDao;
import br.com.entidade.Bone;

public class BoneBO {
	BoneDao bonedao= new BoneDao();
	
	public void cadastrar(Bone bone) {
		bonedao.cadastrar(bone);
	}

	public List<Bone> ListarTodos() {
		
		return bonedao.listartodos();
	}
	

}
