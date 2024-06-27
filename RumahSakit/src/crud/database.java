/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql (CRUD)
/**
 *
 * @author User
 */
public class database {
    private String databaseName = "2210010366_angri_santoso";
    private String username = "root";
    private String password = "";
    public static Connection connectionDB;
    
    public database (){
        try {
          String location = "jdbc:mysql://localhost/" + databaseName;
          Class.forName("com.mysql.jdbc.Driver");
          connectionDB = DriverManager.getConnection(location, username, password);
          System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void simpanuji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "Insert into uji (nik, nama, telp, alamat) value(?, ?, ?, ?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, alamat);
            perintah.executeUpdate();
            System.out.println("data berhasil tersimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public void ubahuji(String nik, String nama, String telp, String alamat){
        try {
            String sql = "update uji set nama = ?, telp = ?, alamat = ? where nik = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            System.out.println("data berhasil tersimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tambahkunjungan(String string, String string0, String string1, String string2, String string3, String tipes, String dalam_penanganan, String iii) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
