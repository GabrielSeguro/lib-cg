
package org.libcg.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.libcg.core.Model;

public class Livro extends Model<Livro> {
    private Integer id;
    private String titulo;
    private String descricao;
    private Boolean emprestado;
    
    public Livro() { super(); }
    public Livro(String titulo, String descricao) {
        super();
        
        this.titulo = titulo;
        this.descricao = descricao;
        this.emprestado = false;
    }
    
    public void emprestar() {
        emprestado = true;
    }
    
    public void devolver() {
        emprestado = false;
    }
    
    public boolean estaEmprestado() {
        return emprestado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void deletar() {
        // Configuração com o db em memória
        String url = "jdbc:h2:~/lib_db"; 
        
        try (Connection conexao = DriverManager.getConnection(url)) {
            // Deleta o livro usando  SQL
            String sql = "DELETE FROM Livro WHERE id = ?";
            try (PreparedStatement declaracao = conexao.prepareStatement(sql)) {
                declaracao.setInt(1, this.id);
                declaracao.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
