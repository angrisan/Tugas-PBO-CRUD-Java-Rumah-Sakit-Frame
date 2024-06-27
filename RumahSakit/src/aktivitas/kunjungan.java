/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aktivitas;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql [CRUD]
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author User
 */
public class kunjungan {
    private String databaseName = "2210010366_angri_santoso";
    private String username = "root";
    private String password ="";
    public static Connection connectionDB;
    private String ID_Kunjungan;
    
    public kunjungan(){
         try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            connectionDB = DriverManager.getConnection(location, username, password);
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tambahkunjungan (String ID_Kunjungan, String Tanggal_Masuk, String Jam_Masuk,String Tanggal_Keluar, String Jam_Keluar, String Keluhan, String Keadaan_Pasien, String Kelompok_Pasien){
        try {
            String sql = "insert into kunjungan (ID_Kunjungan, Tanggal_Masuk, Jam_Masuk, Tanggal_Keluar, Jam_Keluar, Keluhan, Keadaan_Pasien, Kelompok_Pasien) value(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Kunjungan);
            perintah.setString(2, Tanggal_Masuk);
            perintah.setString(3, Jam_Masuk);
            perintah.setString(4, Tanggal_Keluar);
            perintah.setString(5, Jam_Keluar);
            perintah.setString(6, Keluhan);
            perintah.setString(7, Keadaan_Pasien);
            perintah.setString(8, Kelompok_Pasien);
            
            perintah.executeUpdate();
            System.out.println("added");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ubahkunjungan (String ID_Kunjungan, String Tanggal_Masuk, String Jam_Masuk,String Tanggal_Keluar, String Jam_Keluar, String Keluhan, String Keadaan_Pasien, String Kelompok_Pasien){
        try {
            String sql = "update kunjungan set Tanggal_Masuk = ?, Jam_Masuk = ?, Tanggal_Keluar = ?, Jam_Keluar = ?, Keluhan = ?, Keadaan_Pasien = ?, Kelompok_Pasien = ? where ID_Kunjungan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, Tanggal_Masuk);
            perintah.setString(2, Jam_Masuk);
            perintah.setString(3, Tanggal_Keluar);
            perintah.setString(4, Jam_Keluar);
            perintah.setString(5, Keluhan);
            perintah.setString(6, Keadaan_Pasien);
            perintah.setString(7, Kelompok_Pasien);
            perintah.setString(8, ID_Kunjungan);
            
            perintah.executeUpdate();
            System.out.println("updated");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void hapuskunjungan(String ID_Kunjungan){
        try {
            String sql = "delete from kunjungan where ID_Kunjungan = ?";
            PreparedStatement perintah = connectionDB.prepareStatement(sql);
            perintah.setString(1, ID_Kunjungan);
            
            perintah.executeUpdate();
            System.out.println("deleted");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
{
        
    }
}
      
//    private final String NIK;
//    private final String nama;
//    private final String alamat;
//    private final String nomorTelepon;
//    private final String nomorKamar;
//    private final String tipeKamar;
//    private final double hargaPerHari;
//    private LocalDate tanggalKunjungan;
//    private final String keperluan;
//    public kunjungan(pasien pasien, kamar kamar, String tanggalKunjungan, String keperluan) {
//        // Inisialisasi atribut dari pasien
//        this.NIK = pasien.NIK;
//        this.nama = pasien.nama;
//        this.alamat = pasien.alamat;
//        this.nomorTelepon = pasien.nomorTelepon;
//
//        // Inisialisasi atribut dari kamar
//        this.nomorKamar = kamar.nomorKamar;
//        this.tipeKamar = kamar.tipeKamar;
//        this.hargaPerHari = kamar.hargaPerHari;
//
//        // Parsing dan validasi tanggal kunjungan
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            this.tanggalKunjungan = LocalDate.parse(tanggalKunjungan, formatter);
//        } catch (DateTimeParseException e) {
//            System.err.println("Format tanggal tidak valid. Gunakan format yyyy-MM-dd.");
//            this.tanggalKunjungan = LocalDate.now(); // Default ke tanggal saat ini jika parsing gagal
//        }
//
//        this.keperluan = keperluan;
//    }
//
//    public void displayInfo() {
//        System.out.println("Informasi Kunjungan:");
//        System.out.println("NIK Pasien: " + NIK);
//        System.out.println("Nama Pasien: " + nama);
//        System.out.println("Alamat Pasien: " + alamat);
//        System.out.println("Nomor Telepon Pasien: " + nomorTelepon);
//        System.out.println("Nomor Kamar: " + nomorKamar);
//        System.out.println("Tipe Kamar: " + tipeKamar);
//        System.out.println("Harga Per Hari: " + hargaPerHari);
//        System.out.println("Tanggal Kunjungan: " + tanggalKunjungan);
//        System.out.println("Keperluan: " + keperluan);
//    }
}

