/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jurusan;
import Model.Mahasiswa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    
    public static ArrayList<Jurusan> getAllJurusan() {
        ArrayList<Jurusan> jurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jurusan ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jur = new Jurusan();
                jur.setKode(rs.getString("Kode"));
                jur.setNama(rs.getString("Nama"));
                jurusan.add(jur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (jurusan);
    }
    
    //insert jurusan
    public static boolean insertJurusan(String kode, String nama){
        conn.connect();
        String query = "INSERT INTO jurusan VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, kode);
            stmt.setString(2, nama);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
    
    //mengecek KODE didatabase (mencegah duplikat entry)
    public static int cekDuplikatKode(String kode){
        conn.connect();
        int total = 0;
        String query = "SELECT kode FROM jurusan WHERE kode = '" + kode + "'";
        ArrayList<Jurusan> listJur = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jur = new Jurusan();
                jur.setKode(rs.getString("Kode"));
                listJur.add(jur);
            }
            total = listJur.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    
      //insert jurusan
    public static boolean insertMABA(String nim, String nama, int angkatan, String jurusan){
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nim);
            stmt.setString(2, nama);
            stmt.setInt(3, angkatan);
            stmt.setString(4, jurusan);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
    //(mencegah duplikat NIM)
    public static int cekDuplikatNIM(String NIM){
        conn.connect();
        int total = 0;
        String query = "SELECT nim FROM mahasiswa WHERE nim = '" + NIM + "'";
        ArrayList<Mahasiswa> listMa = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa maba = new Mahasiswa();
                maba.setNim(rs.getString("NIM"));
                listMa.add(maba);
            }
            total = listMa.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    
  
}
