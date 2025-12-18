/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionario;

/**
 *
 * @author JESUSSANCHEZ
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarATabeleFuncionario {
    public static void main(String[] args) {
        //URL
        final String url = "jdbc:mysql://localhost:3306/funcionarios";
        // Usuario do banco
        final String usuario = "root";
        // senha do banco
        final String senha = "root"; 
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); Statement stmt = conexao.createStatement()){
            
            // Comando de SQL para crair uma tabela de funcionaros
            
            String sql = 
                    "CREATE TABLE IF NOT EXISTS funcionarios("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nome VARCHAR (80) NOT NULL, "
                    + "carga VARCHAR (50) NOT NULL "
                    + ")";
                    
                    stmt.execute(sql);
                    // confimacao do console
                    System.out.println(" Tabela 'funcionarios' criada com sucesso");
                    
        } catch (SQLException e) {
            // Tratamento simples 
            System.out.println(" Erro ao criar a teabela 'funcionarios'.");
            
        }
    }
    
}
