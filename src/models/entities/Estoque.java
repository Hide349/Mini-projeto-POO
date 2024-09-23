package models.entities;

import java.util.ArrayList;
import java.util.List;

import models.employees.Funcionario;

public class Estoque {
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public Estoque(String nome, Gerente gerente) {
		this.nome = nome;
		funcionarios.add(gerente);
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void mostrarEstoque() {
		for(Produto produto : produtos) {
			System.out.println(produto);
		}
	}
	
	public void mostrarFuncionarios() {
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}
	
	public Funcionario getFuncionario(Integer ID) {
		for(Funcionario funcionario : funcionarios) {
			if(funcionario.getID().equals(ID)) {
				return funcionario;
			}
		}
		return null;
	}
	
	
}
