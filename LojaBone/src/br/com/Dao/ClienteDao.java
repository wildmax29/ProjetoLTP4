package br.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.ConexaoBanco;
import br.com.entidade.Cliente;

public class ClienteDao {

	public void cadastrar(Cliente cliente) {
		
		Connection c= ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("INSERT INTO cliente (nome,idade,cpf) values (?,?,?)");
			ps.setString(1,cliente.getNome());
			ps.setInt(2, cliente.getIdade());
			ps.setString(3,cliente.getCPF());
			ps.execute();
			c.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public List<Cliente> listartodos() {
		Cliente cliente = null;
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection c = ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM cliente");
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				cliente= new Cliente();
				cliente.setIdcliente(result.getInt("Idcliente"));
				cliente.setNome(result.getString("nome"));
				cliente.setIdade(result.getInt("idade"));
				cliente.setCPF(result.getString("cpf"));
				lista.add(cliente);
								
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		return lista;
	}
	

}
