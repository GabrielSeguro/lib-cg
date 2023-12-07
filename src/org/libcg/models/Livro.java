package org.libcg.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.libcg.core.Model;

public class Livro extends Model<Livro> {
    private Integer id;
    private String titulo;
    private String descricao;

    private String autor;
    private Boolean emprestado;
    
    public Livro() { super(); }
    public Livro(String titulo, String descricao, String autor) {
        super();
        
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void deletar() throws SQLException {
        if (id != null) {
            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/lib_db")) {
                String sql = "DELETE FROM Livro WHERE id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, id);
                    int rowsDeleted = statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
