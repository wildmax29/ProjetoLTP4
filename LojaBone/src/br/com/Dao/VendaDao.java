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
import br.com.entidade.Venda;


public class VendaDao {

	public static boolean realizaVenda(Venda venda) {

		try {
			Connection con = null;
			con = new ConexaoBanco().getConnection();

			PreparedStatement stm = con
					.prepareStatement("INSERT INTO venda (descricao, idcliente, idbone) values (?, ?, ?)");
			stm.setString(1, venda.getDescricao());
			stm.setInt(2, venda.getCliente().getIdcliente());
			stm.setInt(3, venda.getBone().getIdbone());

			stm.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error cadastrar venda - DAO");
			return false;
		}
	}

	public List<Venda> listar() {

		java.util.List<Venda> vendas = new ArrayList<Venda>();

		try {
			Connection con = null;
			con = new ConexaoBanco().getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT v.descricao, v.idVenda,c.nome,c.cpf, b.cor,b.preco from venda v JOIN cliente c ON c.idcliente = v.idcliente JOIN bone b ON b.idbone = v.idbone;");
			ResultSet resultado = pst.executeQuery();

			while (resultado.next()) {
				Venda venda = new Venda();

				Bone bone= venda.getBone();
				bone.setCor(resultado.getString("b.cor"));
				bone.setPreco(resultado.getFloat("b.preco"));

				Cliente cliente = venda.getCliente();
				cliente.setNome(resultado.getString("c.nome"));
				cliente.setCPF(resultado.getString("c.cpf"));
				
				venda.setIdvenda(resultado.getInt("v.idVenda"));
				venda.setDescricao(resultado.getString("v.descricao"));

				venda.setBone(bone);
				venda.setCliente(cliente);

				vendas.add(venda);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error cadastrar venda - DAO");

		}
		return vendas;
	}

	public void excluir(Venda venda) {
		String sql = "delete from venda WHERE idVenda=?";
		try {
			Connection con = ConexaoBanco.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, venda.getIdvenda());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

