package br.com.BO;

import java.util.List;

import br.com.Dao.BoneDao;
import br.com.Exception.CampoBoneVazioException;
import br.com.Exception.CampoClienteVazioException;
import br.com.Exception.NomeClienteIncompletoException;
import br.com.Exception.ValorInvalidoException;
import br.com.entidade.Bone;
import br.com.entidade.Cliente;

public class BoneBO {
	BoneDao bonedao= new BoneDao();
	
	public void cadastrar(Bone bone) throws CampoBoneVazioException {
		verificarBone(bone);
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
	public boolean verificarBone(Bone bone) throws CampoBoneVazioException {
		
		if(bone.getCor() == "" ||bone.getTamanho()==""){
			throw new CampoBoneVazioException();
		}
		return true;
			
	}
	public String consultaValor(String preco)throws ValorInvalidoException{
		if(preco==""){
			throw new ValorInvalidoException();
			
		}
			for (int i = 0; i < preco.length(); i++) {
				if (preco.charAt(i) != '1' && preco.charAt(i) != '2' && preco.charAt(i) != '3' && preco.charAt(i)!='4' && preco.charAt(i)!='5'&& preco.charAt(i)!='6' && preco.charAt(i)!='7'&& preco.charAt(i)!='8' && preco.charAt(i)!='9'&& preco.charAt(i)!='0'){
				throw new ValorInvalidoException();
					
				}
				
			}
			return preco;
		}

}
