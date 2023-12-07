package org.libcg.views.livro;

import org.libcg.controllers.LivroController;
import org.libcg.core.View;
import org.libcg.dto.LivroDTO;

public class CadastraLivroScreen extends View {

    @Override
    public void render() {
        System.out.print("Digite o título do livro: ");
        String tituloDoLivro = this.scanner.nextLine();
        System.out.println("");
        System.out.print("Digite a descrição do livro: ");
        String descricaoDoLivro = this.scanner.nextLine();
        System.out.println("");
        System.out.print("Digite o nome do autor do livro a ser cadastrado: ");
        String autorDoLivro = this.scanner.nextLine();
        System.out.println("");
            LivroDTO livro = new LivroDTO(tituloDoLivro, descricaoDoLivro, autorDoLivro);

            LivroController livroController = this.app.make(LivroController.class);

            livroController.guardar(livro);
            livroController.principal();
        }
}
