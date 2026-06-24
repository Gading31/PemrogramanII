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

public class MataKuliah {

    public boolean simpan(
            String kodeMataKuliah,
            String namaMataKuliah,
            int jumlahSks) {

        try {

            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();

            String sql = "INSERT INTO tbmatakuliah VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, kodeMataKuliah);
            ps.setString(2, namaMataKuliah);
            ps.setInt(3, jumlahSks);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }
}
