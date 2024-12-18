/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConexaoBanco {
    final private String url = "jdbc:mysql://localhost/cliente";
    final private String usuario ="root";
    final private String senha="";
    
    public Connection getpegarConexao() {
    try{
 return DriverManager.getConnection(url, usuario, senha);
    }catch (SQLException e){
     JOptionPane.showMessageDialog(null,"Erro ao se conectar ao banco de dados!");
    }
   return null; 
    }

    

   

}
