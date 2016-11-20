package br.com.BO;


import java.sql.SQLException; 
import java.util.List;
import br.com.Dao.ClienteDao;
import br.com.Dao.VendaDao;
import br.com.Exception.CampoClienteVazioException;
import br.com.Exception.ClienteJaExiteException;
import br.com.Exception.NomeClienteIncompletoException;
import br.com.Exception.ValorInvalidoException;
import br.com.entidade.Cliente;

public class ClienteBO {
	ClienteDao clientedao= new ClienteDao();
	
	public void cadastrar(Cliente cliente) throws  SQLException,ValorInvalidoException, CampoClienteVazioException, NomeClienteIncompletoException, ClienteJaExiteException {
		vereficarCliente(cliente);
			
		if(verificarNoBancoCliente(cliente.getCPF())){
			throw new ClienteJaExiteException();
		}
			clientedao.cadastrar(cliente);
		
		
		
	}
	public String consultaIdade(String idade) throws CampoClienteVazioException, ValorInvalidoException{
	if(idade==""){
		throw new CampoClienteVazioException();
		
	}else if(Integer.parseInt(idade)>120){
		throw new ValorInvalidoException();
	}
	for (int i = 0; i < idade.length(); i++) {
	if(idade.charAt(i)!='1' && idade.charAt(i)!='2' && idade.charAt(i)!='3'&& idade.charAt(i)!='4' && idade.charAt(i)!='5'&& idade.charAt(i)!='6' && idade.charAt(i)!='7'&& idade.charAt(i)!='8' && idade.charAt(i)!='9'&& idade.charAt(i)!='0'){
			throw new ValorInvalidoException();
				
			}
			
		}
		return idade;
	}

		private boolean vereficarCliente(Cliente cliente) throws CampoClienteVazioException, NomeClienteIncompletoException {
		
		if(cliente.getNome() == "" || cliente.getCPF() ==""){
			throw new CampoClienteVazioException();
		}
		if(cliente.getNome().indexOf(" ") == -1){
			throw new NomeClienteIncompletoException();
		}
		return true;
			
	}
	private boolean verificarNoBancoCliente(String string) {
			
			return ClienteDao.verificarCPFIgual(string);
		}
	

	public List<Cliente> ListarTodos() {
		
		return clientedao.listartodos();
	}
	
	
	public Cliente ConsultarPorId(int Id){
		return clientedao.ConsultarPorId(Id);
		
	}

	public void alterar(Cliente cliente) throws SQLException, ClienteJaExiteException, CampoClienteVazioException, NomeClienteIncompletoException {
		
		vereficarCliente(cliente);
		
		
		if(verificarNoBancoCliente(cliente.getCPF())){
			throw new ClienteJaExiteException();
		}
	
		clientedao.alterarcliente(cliente);
		
	}

	public void excluir(Cliente cliente) {
		clientedao.excluir(cliente);
		
	}
	public boolean verificarParaExcluir(int idcliente) {
		
		return VendaDao.verificaCliente(idcliente);
	}

}
