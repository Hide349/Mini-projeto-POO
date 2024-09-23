package models.entities;

import model.exceptions.RedundanciaException;
import models.employees.Funcionario;

public class Gerente extends Funcionario {

	public Gerente(String nome,Integer senha) {
		super(nome,senha);
	}
	

	
	public void contratarFuncionario(Estoque estoque, Funcionario funcionario, Integer senha)throws RedundanciaException{
		if(checarSenha(senha)){
			if( !estoque.getFuncionarios().contains(funcionario)) {
			estoque.getFuncionarios().add(funcionario);
			}else {
				throw new RedundanciaException("Esse funcionário já está contratado!");
			}
		}else {
			System.out.println("Senha incorreta!");
		}
	}
	
	public void adicionarProduto(Produto produto,Integer quantidade, Estoque estoque,Integer senha) {
		if(checarSenha(senha)) {
			if(estoque.getProdutos().contains(produto)) {
				AtualizarProdutoQuantidade(produto.getID(),quantidade,estoque,senha);
			}else {
				estoque.getProdutos().add(produto);
			}
		}else {
			System.out.println("Senha incorreta!");
		}
	}
	
	public void removerProduto(Integer ID, Integer quantidade, Estoque estoque, Integer senha) {
		if(checarSenha(senha)) {
			if(!estoque.getProdutos().isEmpty()) {
				Produto produto = procurarProduto(ID,estoque);
				estoque.getProdutos().remove(produto);
			}
		}else {
			System.out.println("Senha incorreta!");
		}
	}
	
	public void AtualizarProdutoQuantidade(Integer ID, Integer quantidade, Estoque estoque,Integer senha){
		if(checarSenha(senha)) {
			Produto produto = procurarProduto(ID, estoque);
			produto.setQuantidade(quantidade);
		}else {
			System.out.println("Senha incorreta!");
		}
	}
	
	public void AtualizarProdutoNome(Integer ID, String nome, Estoque estoque,Integer senha){
		if(checarSenha(senha)) {
			Produto produto = procurarProduto(ID, estoque);
			produto.setNome(nome);
		}else {
			System.out.println("Senha incorreta!");
		}
	}
	
	public void AtualizarProdutoPreco(Integer ID, Double preco, Estoque estoque,Integer senha){
		if(checarSenha(senha)) {
			Produto produto = procurarProduto(ID, estoque);
			produto.setPreco(preco);
		}else {
			System.out.println("Senha incorreta!");
		}
	}
	
}
