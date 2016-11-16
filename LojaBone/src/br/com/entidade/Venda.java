package br.com.entidade;

public class Venda {
	
		private Cliente cliente= new Cliente();
		private Bone bone = new Bone();
		private String Descricao;
		private int idvenda;
		
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public Bone getBone() {
			return bone;
		}
		public void setBone(Bone bone) {
			this.bone = bone;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String descricao) {
			Descricao = descricao;
		}
		public int getIdvenda() {
			return idvenda;
		}
		public void setIdvenda(int idvenda) {
			this.idvenda = idvenda;
		}
			
		
		

}
