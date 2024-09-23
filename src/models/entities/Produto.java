package models.entities;

public class Produto {
	private String nome;
	private Integer ID;
	private Integer quantidade;
	private Double preco;
	
	public Produto(String nome,Integer quantidade, Double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		ID = (int)(Math.random() * (1000 -1 + 1) + 1);
	}
	
	public String getNome() {
		return nome;
	}
	protected void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	protected void setPreco(Double preco) {
		this.preco = preco;
	}
	
	protected void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getID() {
		return ID;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public Double calcularPrecoTotal() {
		return preco * quantidade;
	}
	
	public void DiminuirProduto(Integer quantidade) {
		this.quantidade -= quantidade;
	}
	
	public boolean equals(Integer ID) {
		if(ID == this.ID) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder bg = new StringBuilder();
		bg.append(" ID: ");
		bg.append(getID());
		bg.append("\n Nome: ");
		bg.append(getNome());
		bg.append("\n Preço: ");
		bg.append(String.format("%.2f", getPreco()));
		bg.append("\n Quantidade: ");
		bg.append(getQuantidade());
		return bg.toString();
	}
	
	
}
