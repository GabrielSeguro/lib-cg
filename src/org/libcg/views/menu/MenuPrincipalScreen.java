package org.libcg.views.menu;

import java.sql.SQLException;

import org.libcg.controllers.LivroController;
import org.libcg.core.View;

public class MenuPrincipalScreen extends View {
    @Override
    public void render() {
        boolean sairDoSistema = false;
        LivroController livroController = this.app.make(LivroController.class);

        while (!sairDoSistema) {
            System.out.println("Bem vindo a loja virtual da Biblioteca CG!");
            System.out.println("Digite 1 para acessar a área de livros");
            System.out.println("Digite 2 para remover um livro");
            System.out.println("Digite 3 para atualizar um livro");
            System.out.println("Digite 0 para sair");
            System.out.println("=====================================");
            System.out.print("> ");
            int opcao = this.scanner.nextInt();

            switch (opcao) {
                case 1:
                    livroController.principal();
                    break;
                case 2:
                    System.out.println("Insira o número do livro que você quer remover do sistema:");
                    int id = this.scanner.nextInt();
                    try {
                        livroController.removerUmLivro(id);
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                    case 3:
                    System.out.println("Insira o número do livro que você quer atualizar:");
                    int idAtualizar = this.scanner.nextInt();
                    this.scanner.nextLine(); 
                    
                    System.out.println("Digite o novo título:");
                    String novoTituloCadastro = this.scanner.nextLine();
                    
                    System.out.println("Digite a nova descrição:");
                    String novaDescricaoCadastro = this.scanner.nextLine();
                    System.out.println("Digite um novo autor:");
                    String novoAutorCadastro = this.scanner.nextLine();
                    
                    livroController.atualizaUmLivroCasoExista(idAtualizar, novoTituloCadastro, novaDescricaoCadastro, novoAutorCadastro);
                    break;             
                case 0:
                    System.out.println("Saindo...");
                    sairDoSistema = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
