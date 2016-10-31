package br.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.ConexaoBanco;
import br.com.entidade.Bone;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
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
	

}
