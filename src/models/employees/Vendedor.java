package models.employees;

import model.exceptions.ForaDeEstoque;
import models.entities.Estoque;
import models.entities.Produto;

public class Vendedor extends Funcionario{

	
	public Vendedor(String nome, Integer senha){
		super(nome,senha);
	}
	
	public void venderProduto(Integer ID,Estoque estoque, Integer quantidade,Integer senha) throws ForaDeEstoque{
		if(checarSenha(senha)) {
			Produto produto = procurarProduto(ID,estoque);
			if(quantidade <= produto.getQuantidade()) {
				produto.DiminuirProduto(quantidade);
				System.out.println("Produto vendido com sucesso!");
				System.out.println("Preço: " + String.format("%.2f", produto.calcularPrecoTotal()));
			}else {
				throw new ForaDeEstoque("Não temos produtos o suficiente no estoque!");
			}
		}else {
			System.out.println("Senha incorreta!");
		}
	}
}
