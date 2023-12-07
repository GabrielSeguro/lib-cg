package org.libcg.dto;

public class LivroDTO {
    private final Integer id;
    private final String titulo;
    private final String descricao;
    private final Boolean emprestado;
    private final String autor;

    public LivroDTO(String titulo, String descricao, String autor) {
        this.id = 0;
        this.titulo = titulo;
        this.descricao = descricao;
        this.emprestado = false;
        this.autor = autor;
    }

    public LivroDTO(Integer id, String titulo, String descricao, Boolean emprestado, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.emprestado = emprestado;
        this.autor = autor; 
    }
    public LivroDTO(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = null;
        this.autor = null;
        this.emprestado = null; 
    }
    public LivroDTO(Integer id, String novoTitulo, String novaDescricao, String novoAutorDoLivro) {
        this.id = id;
        this.titulo = novoTitulo;
        this.descricao = novaDescricao;
        this.autor = novoAutorDoLivro;
        this.emprestado = true; // Você pode definir o emprestado como desejar
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public String getAutor() {
        return autor;
    }

    public Boolean estaEmprestado() {
        return emprestado;
    }
}
