/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unpam.model;

/**
 *
 * @author dingg
 */
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mahasiswa {

    public boolean simpan(
            String nim,
            String nama,
            int semester,
            String kelas,
            String password) {

        try {

            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();

            String sql = "INSERT INTO tbmahasiswa VALUES (?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setInt(3, semester);
            ps.setString(4, kelas);
            ps.setString(5, password);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }
}
