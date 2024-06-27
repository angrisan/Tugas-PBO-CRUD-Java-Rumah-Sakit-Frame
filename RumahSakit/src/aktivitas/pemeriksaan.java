/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aktivitas;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan koneksi
import java.sql.PreparedStatement; // perintah sql CRUD
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class pemeriksaan {
    private String databaseName = "2210010366_angri_santoso";
    private String username = "root";
    private String password ="";
    public static Connection connectionDB;
    private String ID_Kunjungan;
    
    public pemeriksaan(){
         try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(location, username, password);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tambahpemeriksaan(String ID_Pemeriksaan, String Nama_Pemeriksaan, String Keterangan, String ID_Jenis_Pemeriksaan){
        try {
            String sql = "insert into pemeriksaan (ID_Pemeriksaan, Nama_Pemeriksaan, Keterangan, ID_Jenis_Pemeriksaan) value(?, ?, ?, ?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Pemeriksaan);
            perintah.setString(2, Nama_Pemeriksaan);
            perintah.setString(3, Keterangan);
            perintah.setString(4, ID_Jenis_Pemeriksaan);
            
            perintah.executeUpdate();
            System.out.println("added");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahpemeriksaan(String ID_Pemeriksaan, String Nama_Pemeriksaan, String Keterangan, String ID_Jenis_Pemeriksaan){
        try {
            String sql = "update pemeriksaan set Nama_Pemeriksaan = ?, Keterangan = ?, ID_Jenis_Pemeriksaan = ? where ID_Pemeriksaan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, Nama_Pemeriksaan);
            perintah.setString(2, Keterangan);
            perintah.setString(3, ID_Jenis_Pemeriksaan);
            perintah.setString(4, ID_Pemeriksaan);
            
            perintah.executeUpdate();
            System.out.println("updated");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapuspemeriksaan(String ID_Pemeriksaan){
        try {
            String sql = "delete from pemeriksaan where ID_Pemeriksaan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Pemeriksaan);
            
            perintah.executeUpdate();
            System.out.println("deleted");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//   String nomorKamar;   
//    String tipeKamar;    
//    double hargaPerHari; 
//
//    String NIK;          
//    String nama;         
//    String alamat;       
//    String nomorTelepon; 
//
//    LocalDate tanggalPemeriksaan; 
//    String hasilPemeriksaan;      
//
//    public pemeriksaan(kamar kamar, pasien pasien, String tanggalPemeriksaan, String hasilPemeriksaan) {
//        // Inisialisasi atribut dari kamar
//        this.nomorKamar = kamar.nomorKamar;
//        this.tipeKamar = kamar.tipeKamar;
//        this.hargaPerHari = kamar.hargaPerHari;
//
//        // Inisialisasi atribut dari pasien
//        this.NIK = pasien.NIK;
//        this.nama = pasien.nama;
//        this.alamat = pasien.alamat;
//        this.nomorTelepon = pasien.nomorTelepon;
//
//        // Parsing dan validasi tanggal
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            this.tanggalPemeriksaan = LocalDate.parse(tanggalPemeriksaan, formatter);
//        } catch (DateTimeParseException e) {
//            System.err.println("Format tanggal tidak valid. Gunakan format yyyy-MM-dd.");
//            this.tanggalPemeriksaan = LocalDate.now(); // Default ke tanggal saat ini jika parsing gagal
//        }
//
//        this.hasilPemeriksaan = hasilPemeriksaan;
//    }
//
//    public void displayInfo() {
//        System.out.println("Informasi Pemeriksaan:");
//        System.out.println("Nomor Kamar: " + nomorKamar);
//        System.out.println("Tipe Kamar: " + tipeKamar);
//        System.out.println("Harga Per Hari: " + hargaPerHari);
//        System.out.println("NIK Pasien: " + NIK);
//        System.out.println("Nama Pasien: " + nama);
//        System.out.println("Alamat Pasien: " + alamat);
//        System.out.println("Nomor Telepon Pasien: " + nomorTelepon);
//        System.out.println("Tanggal Pemeriksaan: " + tanggalPemeriksaan);
//        System.out.println("Hasil Pemeriksaan: " + hasilPemeriksaan);
//    }
}