package org.libcg.controllers;

import java.sql.SQLException;
import java.util.List;
import org.libcg.core.Controller;
import org.libcg.dto.LivroDTO;

import org.libcg.models.Livro;
import org.libcg.views.livro.CadastraLivroScreen;
import org.libcg.views.livro.ListaLivroScreen;
import org.libcg.views.livro.LivrosPrincipalScreen;
import org.libcg.views.livro.MostraLivroScreen;

public class LivroController extends Controller {
    
    @Override
    public void principal() {
        LivrosPrincipalScreen view = new LivrosPrincipalScreen();
        
        view.render();
    }

    public void listar() {
        List<Livro> livros = Livro.findAll(Livro.class);
        List<LivroDTO> livroDTO = livros.stream()
                .map(livro -> new LivroDTO(
                        livro.getId(), 
                        livro.getTitulo(), 
                        livro.getDescricao(), 
                        livro.estaEmprestado(),
                        livro.getAutor()
                )).toList();
        
        ListaLivroScreen view = new ListaLivroScreen(livroDTO);
            
        view.render();
    }
    
    public void mostarLivro(int id) {
        Livro livro = Livro.findOne(id, Livro.class);
        LivroDTO livroDTO = new LivroDTO(
                        livro.getId(), 
                        livro.getTitulo(), 
                        livro.getDescricao(), 
                        livro.estaEmprestado(),
                        livro.getAutor()
        );
        
        MostraLivroScreen view = new MostraLivroScreen(livroDTO);
            
        view.render();
    }
    
    public void emprestar(LivroDTO livroDTO) {
        Livro livro = Livro.findOne(livroDTO.getId(), Livro.class);
        System.out.println("\"Autor do livro cadastrado:" + livro.getAutor());
        livro.emprestar();
        
        livro.save();
    }
    
    public void cadastrar() {
        CadastraLivroScreen view = new CadastraLivroScreen();
        
        view.render();
    }
    public void removerUmLivro(int id) throws SQLException {
        Livro livro = Livro.findOne(id, Livro.class);
        
        if (livro != null) {
            livro.deletar();
            System.out.println("Livro removido com sucesso.");
        }
    }
    public boolean verificarExistenciaLivro(int id) {
        Livro livro = Livro.findOne(id, Livro.class);
        return livro != null;
    }
    public void atualizaUmLivroCasoExista(int id, String novoTituloParaOLivro, String novaDescricaoParaOLivro, String novoAutorParaOLivro) {
        Livro livro = Livro.findOne(id, Livro.class);
        
        if (livro != null) {
            livro.setTitulo(novoTituloParaOLivro);
            livro.setDescricao(novaDescricaoParaOLivro);
            livro.setAutor(novoAutorParaOLivro);
            livro.save();
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
    
    public void guardar(LivroDTO livroDTO) {
        Livro livro = new Livro(livroDTO.getTitulo(), livroDTO.getDescricao(), livroDTO.getAutor());
        livro.save();
    }
}
