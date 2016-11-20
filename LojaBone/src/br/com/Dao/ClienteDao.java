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
			
			e.printStackTrace();
		}
		
	}
	public static boolean verificarCPFIgual(String string) {
		try {
			Connection con = ConexaoBanco.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*)  FROM cliente WHERE cpf  = ? ");
			ps.setString(1, string);
			ResultSet result = ps.executeQuery();
			result.last();
			if (result.getInt(1) > 0) {
				return true;
			} else {
				return false;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
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
	
	public static Cliente ConsultarPorId(int Id){
		Cliente cliente=null;
		Connection c = ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM cliente where idcliente = ?");
			ps.setInt(1, Id);
			ResultSet result = ps.executeQuery();
			
			
			while(result.next()){
				cliente= new Cliente();
				cliente.setIdcliente(result.getInt("idcliente"));
				cliente.setNome(result.getString("nome"));
				cliente.setIdade(result.getInt("idade"));
				cliente.setCPF(result.getString("cpf"));
												
			}
		}
			catch(SQLException e){
			e.printStackTrace();
			
	}
	return cliente;
	

	}

	public void alterarcliente(Cliente cliente) {
		Connection c= ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE cliente set nome = ?,idade = ?,cpf = ? WHERE idcliente = ?");
			ps.setString(1,cliente.getNome());
			ps.setInt(2, cliente.getIdade());
			ps.setString(3,cliente.getCPF());
			ps.setInt(4, cliente.getIdcliente());
			ps.execute();
			ps.close();
			c.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(Cliente cliente) {
		Connection c = ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
			ps.setInt(1,cliente.getIdcliente());
			ps.execute();
			ps.close();
			c.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}