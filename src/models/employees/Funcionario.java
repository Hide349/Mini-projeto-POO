package models.employees;

import models.entities.Estoque;
import models.entities.Produto;

public abstract class Funcionario {
	private Integer ID;
	private String nome;
	private Integer senha;
	
	public Funcionario(String nome, Integer senha) {
		this.nome = nome;
		this.senha = senha;
		ID = (int)(Math.random() * (1000 - 1 + 1)+1);
	}
	
	public Integer getID() {
		return ID;
	}
	public String getNome() {
		return nome;
	}
	
	public boolean checarSenha(Integer senha) {
		return !(senha == this.senha);
	}
	
	protected Produto procurarProduto(Integer ID, Estoque estoque) {
		for(Produto produto : estoque.getProdutos()) {
			if(produto.getID().equals(ID)) {
				return produto;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder bg = new StringBuilder();
		bg.append("\n ID: ");
		bg.append(getID());
		bg.append("\n Nome: ");
		bg.append(getNome());
		
		return bg.toString();

	}


}
