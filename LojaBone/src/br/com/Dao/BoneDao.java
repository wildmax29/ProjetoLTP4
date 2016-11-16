package br.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.ConexaoBanco;
import br.com.entidade.Bone;
import br.com.entidade.Cliente;

public class BoneDao {

	public void cadastrar(Bone bone) {
		
		Connection c= ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("INSERT INTO bone (cor,preco,tamanho ) values (?,?,?)");
			ps.setString(1,bone.getCor());
			ps.setFloat(2, bone.getPreco());
			ps.setString(3,bone.getTamanho());
			ps.execute();
			c.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public List<Bone> listartodos() {
		Bone bone = null;
		List<Bone> lista = new ArrayList<Bone>();
		Connection c = ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM bone");
			ResultSet result = ps.executeQuery();
			
			while(result.next()){
				bone= new Bone();
				bone.setIdbone(result.getInt("Idbone"));
				bone.setCor(result.getString("cor"));
				bone.setPreco(result.getFloat("preco"));
				bone.setTamanho(result.getString("tamanho"));
				lista.add(bone);
								
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		return lista;
	}

	public static Bone ConsultarPorIdBone(int Idbone){
		Bone bone=null;
		Connection c = ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM bone where idbone = ?");
			ps.setInt(1, Idbone);
			ResultSet result = ps.executeQuery();
			
			
			while(result.next()){
				bone= new Bone();
				bone.setIdbone(result.getInt("idbone"));
				bone.setCor(result.getString("cor"));
				bone.setPreco(result.getFloat("preco"));
				bone.setTamanho(result.getString("tamanho"));
												
			}
		}
			catch(SQLException e){
			e.printStackTrace();
			
	}
	return bone;
	
}
	public void alterarbone(Bone bone) {
		Connection c= ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("UPDATE bone set cor = ?,preco = ?,tamanho = ? WHERE idbone= ?");
			ps.setString(1,bone.getCor());
			ps.setFloat(2, bone.getPreco());
			ps.setString(3,bone.getTamanho());
			ps.setInt(4, bone.getIdbone());
			ps.execute();
			ps.close();
			c.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(Bone bone) {
		Connection c = ConexaoBanco.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("DELETE FROM bone WHERE idbone = ?");
			ps.setInt(1,bone.getIdbone());
			ps.execute();
			ps.close();
			c.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}