package org.libcg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInit {
    private static final String JDBC_URL = "jdbc:h2:~/lib-cg";

    public static String[] run() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            if (connection != null) {
                System.out.println("Conexão com o banco de dados estabelecida!");

                try (Statement statement = connection.createStatement()) {
                    String[] queries = {
                        "DROP TABLE IF EXISTS Livro",
                        "CREATE TABLE Livro(id INT PRIMARY KEY AUTO_INCREMENT, titulo VARCHAR(255) NOT NULL, descricao VARCHAR(255) NOT NULL, autor VARCHAR(255) not NULL, emprestado BOOLEAN DEFAULT false)",
                        "INSERT INTO Livro(titulo, descricao, autor) VALUES('Engenharia de Software Moderna', 'Engenharia de Software Moderna eh um livro-texto destinado a alunos de cursos de graduação em Computacao', 'a definir')",
                        "INSERT INTO Livro(titulo, descricao, autor) VALUES('O Pequeno Principe', 'Eh uma novela do escritor, aviador aristocrata frances Antoine de Saint-Exupery', 'a definir')",
                        "INSERT INTO Livro(titulo, descricao, autor) VALUES('Romeu e Julieta', 'Eh uma novela do escritor, aviador aristocrata frances Antoine de Saint-Exupery', 'a definir')"
                    };

                    for (String query : queries) {
                        statement.executeUpdate(query);
                    }

                    System.out.println("Banco de dados inicializado com sucesso!");
                    return queries;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println("Falha ao estabelecer conexão com o banco de dados!");
            e.printStackTrace();
        }
        return null;
    }
}
