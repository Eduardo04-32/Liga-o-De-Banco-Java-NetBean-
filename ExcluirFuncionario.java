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

public class ExcluirFuncionario {
    public static void main(String[] args) {
         //URL
        final String url = "jdbc:mysql://localhost:3306/funcionarios";
        // Usuario do banco
        final String usuario = "root";
        // senha do banco
        final String senha = "root";
        
        //Scabner para entrada de dados
        Scanner entrada = new Scanner(System.in);
        // solicitar o ID do funcionario
        System.out.println("Informe o ID do funcionario para Ecluir: ");
        int id = entrada.nextInt();
        entrada.nextLine();// limpa o buffer
        
        String sql = 
                "DELETE FROM funcionarios WHERE id = ? ";
        
        try  (Connection conexao = 
                DriverManager.getConnection(url, usuario, senha);
                PreparedStatement stmt = 
                        conexao.prepareStatement(sql)){
            
            // Subititui o parametro do SQL 
            stmt.setInt(1, id);
            
            // Execute o DELETE
            int linhasAfetadas = stmt.executeUpdate();
            
             //  verifica se algo foi alterado
            if(linhasAfetadas > 0 ){
                System.out.println("Funcionario Atualizado com sucesso");
            }else{
                System.out.println("Funcionario nao encontrado");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionario");
            e.printStackTrace();
            
        }finally{
            entrada.close();
        }
            
        }
    }
