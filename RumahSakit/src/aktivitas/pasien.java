/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aktivitas;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql (CRUD)
/**
 *
 * @author User
 */
public class pasien {
   private String databaseName = "2210010366_angri_santoso";
    private String username = "root";
    private String password ="";
    public static Connection connectionDB;
    private String ID_Kunjungan;
    private String ID_Pasien;
    
    public pasien(){
         try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(location, username, password);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tambahpasien(String ID_Pasien, String Nama_Lengkap, String Alamat, String Tanggal_Lahir, String Jenis_Kelamin, String Golongan_Darah){
        try {
            String sql = "insert into pasien (ID_Pasien, Nama_Lengkap, Alamat, Tanggal_Lahir, Jenis_Kelamin, Golongan_Darah) value(?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Pasien);
            perintah.setString(2, Nama_Lengkap);
            perintah.setString(3, Alamat);
            perintah.setString(4, Tanggal_Lahir);
            perintah.setString(5, Jenis_Kelamin);
            perintah.setString(6, Golongan_Darah);
            
            perintah.executeUpdate();
            System.out.println("Added");
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahpasien(String ID_Pasien, String Nama_Lengkap, String Alamat, String Tanggal_Lahir, String Jenis_Kelamin, String Golongan_Darah){
        try {
            String sql = "update pasien set Nama_Lengkap = ?, Alamat = ?, Tanggal_Lahir = ?, Jenis_Kelamin = ?, Golongan_Darah = ? where ID_Pasien = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, Nama_Lengkap);
            perintah.setString(2, Alamat);
            perintah.setString(3, Tanggal_Lahir);
            perintah.setString(4, Jenis_Kelamin);
            perintah.setString(5, Golongan_Darah);
            perintah.setString(6, ID_Pasien);
            
            perintah.executeUpdate();
            System.out.println("updated");
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapuspasien(String ID_pasien){
        try {
            String sql = "delete from pasien where ID_Pasien = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_pasien);
            
            perintah.executeUpdate();
            System.out.println("deleted");
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
//    String NIK;           // Tipe data String
//    String nama;          // Tipe data String
//    String alamat;        // Tipe data String
//    String nomorTelepon;  // Tipe data String
//
//    // Konstruktor
//    public pasien(String NIK, String nama, String alamat, String nomorTelepon) {
//        this.NIK = NIK;
//        this.nama = nama;
//        this.alamat = alamat;
//        this.nomorTelepon = nomorTelepon;
//    }
}

