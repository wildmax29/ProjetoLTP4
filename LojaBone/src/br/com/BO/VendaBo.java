package br.com.BO;

import java.util.List;

import br.com.Dao.VendaDao;
import br.com.entidade.Venda;

public class VendaBo {

	public void realizaVenda(Venda venda) {
		VendaDao vendadao = new VendaDao();
		vendadao.realizaVenda(venda);
	}

	public List<Venda> listar() {
		VendaDao vendadao = new VendaDao();
		return vendadao.listar();
	}

	public void excluir(Venda venda) {
		VendaDao vendadao = new VendaDao();
		vendadao.excluir(venda);
		
	}
}
