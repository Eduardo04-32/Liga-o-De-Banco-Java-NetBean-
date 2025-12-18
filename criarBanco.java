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
import java.sql.Statement; // Permite trabnalhar com SQL em um codigo JAVA

public class criarBanco {
    
    public static void main(String[] args) {
        //URL
        final String url = "jdbc:mysql://localhost:3306/";
        // Usuario do banco
        final String usuario = "root";
        // senha do banco
        final String senha = "root"; 
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); Statement stmt = conexao.createStatement()){
            //comando SQL para crar o banco de dados
            // IF NOT EXISTS evite erros caso o banco ja exista 
            String sql = "CREATE DATABASE IF NOT EXISTS funcionarios";
            // executar o comando SQL 
            stmt.execute(sql);
            // mensagem de sucesso
            System.out.println("Banco de dado 'funcionarios' crado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao criar o banco de dado.");
        }
    }
    
}
