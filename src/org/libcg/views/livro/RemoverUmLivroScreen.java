package org.libcg.views.livro;

import org.libcg.controllers.LivroController;
import org.libcg.core.View;
import org.libcg.dto.LivroDTO;

public class RemoverUmLivroScreen extends View {

    @Override
    public void render() {
        System.out.print("Digite o ID do livro que deseja remover: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine(); 
        
        LivroController livroController = this.app.make(LivroController.class);
        
        if (livroController.verificarExistenciaLivro(id)) {
            livroController.removerUmLivro(id);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
        
        livroController.principal();
    }
}
