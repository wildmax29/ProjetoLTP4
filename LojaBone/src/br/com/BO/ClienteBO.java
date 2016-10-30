package br.com.BO;

import java.util.List;

import br.com.Dao.ClienteDao;
import br.com.entidade.Cliente;

public class ClienteBO {
	ClienteDao clientedao= new ClienteDao();
	
	public void cadastrar(Cliente cliente) {
		clientedao.cadastrar(cliente);
	}

	public List<Cliente> ListarTodos() {
		
		return clientedao.listartodos();
	}
	

}
