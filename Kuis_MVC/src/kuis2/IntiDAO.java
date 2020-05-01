
package kuis2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class IntiDAO {
    private int jmlData;
    private Connection koneksi;
    private Statement statement;
    
    public IntiDAO(){
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
    public void Create(IntiModel Model){
        try{
            String query = "INSERT INTO data_inti VALUES ('32','"+Model.getJudul()+"','"+Model.getTipe()+"','"+Model.getEpisode()+"','"+Model.getGenre()+"','"+Model.getStatus()+"','"+Model.getRating()+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Disimpan");
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void Update(IntiModel Model){
        try{
            String query = "UPDATE data_inti SET judul = '"+Model.getJudul()+"', tipe = '"+Model.getTipe()+"', episode = '"+Model.getEpisode()+"', genre = '"+Model.getGenre()+"', status = '"+Model.getStatus()+"', rating = '"+Model.getRating()+"' WHERE judul = '"+Model.getJudul()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Terupdate");
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void Delete(IntiModel Model){
        try{
            String query = "DELETE FROM data_inti WHERE judul = '"+Model.getJudul()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }
    public String[][] readData(){
            try{
                int jmlData = 0, wew = 0;
                String data[][] = new String[getJmldata()][8];
                String query = "SELECT * FROM data_inti";
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    wew = jmlData+1;
                    String pager = Integer.toString(wew);
                    data[jmlData][0] = pager;
                    //data[jmlData][0] = Integer.toString(kode);
                    data[jmlData][1] = resultSet.getString("id");
                    data[jmlData][2] = resultSet.getString("judul");
                    data[jmlData][3] = resultSet.getString("tipe");
                    data[jmlData][4] = resultSet.getString("episode");
                    data[jmlData][5] = resultSet.getString("genre");
                    data[jmlData][6] = resultSet.getString("status");
                    data[jmlData][7] = resultSet.getString("rating");
                    jmlData++;
                }
                return data;
            }catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return null;
            }
        }

    public int getJmldata() {
        int jmlData = 0;
        try{
            String query = "SELECT * FROM data_inti";
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    jmlData++;
                }
                return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] searchData(IntiModel model){
            try{
                int jmlData = 0, wew;
                String data[][] = new String[getJmldata()][8];
                String query = "SELECT * FROM data_inti WHERE judul = '%" + model.getCari() + "%'";
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    wew = jmlData+1;
                    String pager = Integer.toString(wew);
                    data[jmlData][0] = pager;
                    data[jmlData][1] = resultSet.getString("id");
                    data[jmlData][2] = resultSet.getString("judul");
                    data[jmlData][3] = resultSet.getString("tipe");
                    data[jmlData][4] = resultSet.getString("episode");
                    data[jmlData][5] = resultSet.getString("genre");
                    data[jmlData][6] = resultSet.getString("status");
                    data[jmlData][7] = resultSet.getString("rating");
                    jmlData++;
                }
                return data;
            }catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
                return null;
            }
        }
}
