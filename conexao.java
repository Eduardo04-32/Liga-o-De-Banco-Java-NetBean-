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

public class conexao {
    public static void main(String[] args) {
        // URL minimo de conexao com MySQL 
        // çocalhost -> banco local
        //33306 -> porta padrao 
        // funcionarios - > nome do banco
        
        //URL
        final String url = "jdbc:mysql://localhost:3306/";
        // Usuario do banco
        final String usuario = "root";
        // senha do banco
        final String senha = "root"; 
        
        try {
            // Abre a conexao com banco 
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao efetuada com sucesso");
            conexao.close();
            
        } catch (SQLException e) {
            //Tratamento de rsso simples
            System.out.println("Erro ao conectar o banco de dados");
        }

    }
}
