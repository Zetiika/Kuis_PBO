
package kuis2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginDAO {
    private Connection koneksi;
    private Statement statement;
    
    public LoginDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/kuismvc";
            koneksi = DriverManager.getConnection(url, "root", "");
            statement = koneksi.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class Not Found : " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Exception : " + ex);
        }
    }
    
    public void Login(LoginModel model){
        try{
            String query = "SELECT * FROM login WHERE username = '"+model.getUsername() +"' && password = '"+ model.getPassword() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            JOptionPane.showMessageDialog(null, "Selamat Login Anda Sukses");
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
