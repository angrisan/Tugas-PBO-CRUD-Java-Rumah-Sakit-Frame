/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aktivitas;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; // menghubungkan database
import java.sql.PreparedStatement; //perintah sql CRUD
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 *
 * @author User
 */
public class kamar { 
     private String databaseName = "2210010366_angri_santoso";
    private String username = "root";
    private String password ="";
    public static Connection connectionDB;
    private String ID_Kunjungan;
    private String ID_Kamar;
    
    public kamar(){
         try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(location, username, password);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tambahkamar(String ID_Kamar, String No_Kamar, String Jumlah_Bed, String Keterangan){
        try {
            String sql = "insert into kamar (ID_Kamar, No_Kamar, Jumlah_Bed, Keterangan) value(?, ?, ?, ?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Kamar);
            perintah.setString(2, No_Kamar);
            perintah.setString(3, Jumlah_Bed);
            perintah.setString(4, Keterangan);
            
            perintah.executeUpdate();
            System.out.println("added");
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahkamar(String ID_kamar, String No_Kamar, String Jumlah_Bed, String Keterangan){
        try {
            String sql = "update kamar set No_Kamar = ?, Jumlah_Bed = ?, Keterangan = ? where ID_Kamar = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, No_Kamar);
            perintah.setString(2, Jumlah_Bed);
            perintah.setString(3, Keterangan);
            perintah.setString(4, ID_kamar);
            
            perintah.executeUpdate();
            System.out.println("updated");
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapuskamar(String ID_Kamar){
        try {
            String sql = "delete from kamar where ID_Kamar = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Kamar);
            
            perintah.executeUpdate();
            System.out.println("deleted");
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//    String nomorKamar;   
//    String tipeKamar;    
//    double hargaPerHari; 
//
//    public kamar(String nomorKamar, String tipeKamar, double hargaPerHari) {
//        this.nomorKamar = nomorKamar;
//        this.tipeKamar = tipeKamar;
//        this.hargaPerHari = hargaPerHari;
//    }
}
    

