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
import java.util.Scanner;
import java.sql.PreparedStatement;

public class NovoFuncionario {
    public static void main(String[] args) {
        //URL
        final String url = "jdbc:mysql://localhost:3306/funcionarios";
        // Usuario do banco
        final String usuario = "root";
        // senha do banco
        final String senha = "root"; 
        
        // Etrada para escaner dos dados
        Scanner entrada = new Scanner(System.in);
        
        // Solicita o nome do funcionario
        System.out.println("Informa o nome funcionario: ");
        String nome = entrada.nextLine();
        
        // solicita o cargo do funcionario
        System.out.println("Informe o cargo do funcionario: ");
        String carga = entrada.nextLine();
        
        /*
        SQL TA ME ENLOQUESENDOOOOOOOOOOOOOOOOOOOOO
        O uso de ? evita o SQL Injectioin 
        */
        
        String sql = "INSERT INTO funcionarios (nome, carga) VALUES (?, ?)";
                //INSERTE INTO funcionario (nome) VALUES ('DUDU'); from funcionario ('1' = '1')
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha); PreparedStatement stmt = conexao.prepareStatement(sql)){
            // Substitui os parametrso SQL 
            stmt.setString(1, nome);
            stmt.setString(2, carga);
            
            // executar o INSER
            stmt.executeUpdate();
            // Configurações no console 
            System.out.println("Funcionario incluido com sucesso.");
            
        } catch (SQLException e) {
            // Tratamento simples
            System.out.println("Erro ao inserir o funcionario");
        }finally{
            // fechar o scaner
            entrada.close();
        }
        
    } 
    
}
