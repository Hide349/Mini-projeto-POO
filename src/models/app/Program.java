package models.app;

import java.util.Scanner;

import model.exceptions.ForaDeEstoque;
import model.exceptions.RedundanciaException;
import models.employees.Vendedor;
import models.entities.Estoque;
import models.entities.Gerente;
import models.entities.Produto;

public class Program {
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void menu() {
		System.out.println("..........Menu.........");
		System.out.println("......Criar estoque(1) ....");
		System.out.println("......Contratar vendedor(2).....");
		System.out.println("......Alterar Estoque(3).....");
		System.out.println("......Realizar venda(4).....");
		System.out.println("......Mostrar estoque(5).....");
		System.out.println("......Mostrar funcionários(6).....");
		System.out.println("......Sair(7).....");


	}
	
	public static void menuEstoque() {
		System.out.println("..........Menu.........");
		System.out.println("......Adicionar Produto(1) ....");
		System.out.println("......Atualizar quantidade Produto(2).....");
		System.out.println("......Atualizar nome Produto(3).....");
		System.out.println("......Atualizar preço Produto(4).....");
		System.out.println("......Remover Produto(5).....");
	}
	
	public static void main(String[] args) throws RedundanciaException, ForaDeEstoque {
		boolean sair = false;
		int opcao = 0;
		Scanner sc = new Scanner(System.in);
		Estoque estoque = null;
		boolean existeEstoque = false;
		while(!sair) {
			clearScreen();
			menu();
			opcao = sc.nextInt();
			switch(opcao) {
				case 1:{
					if(!existeEstoque) {
						System.out.println("Digite o nome do estoque: ");
						String nome = sc.next();
						System.out.println("Digite o nome do gerente: ");
						String gerente = sc.next();
						System.out.println("Digite a senha do gerente: ");
						Integer senha = sc.nextInt();
						estoque = new Estoque(nome,new Gerente(gerente,senha));
					}else {
						System.out.println("Um estoque já foi criado!");
					}
					break;
				}
				case 2:{
					System.out.println("ID do gerente: ");
					Integer idGerente = sc.nextInt();
					System.out.println("Senha do gerente: ");
					Integer senha = sc.nextInt();
					System.out.println("Nome do vendedor: ");
					String nome = sc.next();
					System.out.println("Senha vendedor: ");
					Integer senhaVendedor = sc.nextInt();
					if(estoque != null) {
						Gerente gerente = (Gerente)estoque.getFuncionario(idGerente);
						try {
							gerente.contratarFuncionario(estoque, new Vendedor(nome, senhaVendedor),senha);

						}catch (RedundanciaException e) {
							System.out.println(e.getMessage());
						}
					}else {
						System.out.println("Não existe um estoque!");
					}
					break;
				}
				case 3:{
					System.out.println("ID do gerente: ");
					Integer idGerente = sc.nextInt();
					System.out.println("Senha do gerente: ");
					Integer senha = sc.nextInt();
					menuEstoque();
					opcao = sc.nextInt();
					Gerente gerente = (Gerente)estoque.getFuncionario(idGerente);
					switch(opcao) {
						case 1:{
							System.out.println("Nome produto: ");
							String nomeProduto = sc.next();
							System.out.println("Quantidade de produtos: ");
							Integer quantidade = sc.nextInt();
							System.out.println("Preço do produto: ");
							Double precoProduto = sc.nextDouble();
							Produto produto = new Produto(nomeProduto,quantidade,precoProduto);
							gerente.adicionarProduto(produto, idGerente, estoque, senha);
							break;
						}
						case 2:{
							System.out.println("Id do produto: ");
							Integer idProduto = sc.nextInt();
							System.out.println("Nova quantidade: ");
							Integer quantidade = sc.nextInt();
							gerente.AtualizarProdutoQuantidade(idProduto, quantidade, estoque, senha);
							break;
						}
						case 3:{
							System.out.println("Id do produto: ");
							Integer idProduto = sc.nextInt();
							System.out.println("Novo nome: ");
							String novoNome = sc.next();
							gerente.AtualizarProdutoNome(idProduto, novoNome, estoque, senha);
							break;
						}
						case 4:{
							System.out.println("Id do produto: ");
							Integer idProduto = sc.nextInt();
							System.out.println("Novo preço: ");
							Double novoPreco = sc.nextDouble();
							gerente.AtualizarProdutoPreco(idProduto, novoPreco, estoque, senha);
							break;
						}
						case 5:{
							System.out.println("Id do produto: ");
							Integer idProduto = sc.nextInt();
							System.out.println("Digite a quantidade: ");
							Integer quantidade = sc.nextInt();
							gerente.removerProduto(idProduto, quantidade, estoque, senha);
						}
					}
					break;
				}
				case 4:{
					System.out.println("Id do vendedor: ");
					Integer id = sc.nextInt();
					System.out.println("Senha do vendedor: ");
					Integer senha = sc.nextInt();
					Vendedor vendedor = (Vendedor)estoque.getFuncionario(id);
					System.out.println("Id do produto: ");
					Integer idProduto = sc.nextInt();
					System.out.println("Quantidade: ");
					Integer quantidade = sc.nextInt();
					try {
						vendedor.venderProduto(idProduto, estoque, quantidade, senha);

					}catch (ForaDeEstoque e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case 5:{
					estoque.mostrarEstoque();
					break;
				}
				case 6:{
					estoque.mostrarFuncionarios();
					break;
				}
				case 7:{
					sair = true;
					break;
				}
				default:{
					System.out.println("Digite um opção válida!");
				}
			}
		}
		sc.close();
	}
}
