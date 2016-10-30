package br.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	

}
