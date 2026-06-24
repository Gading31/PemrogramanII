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

public class Nilai {

    public boolean simpan(
            String nim,
            String kodeMk,
            double tugas,
            double uts,
            double uas) {

        try {

            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();

            String sql =
                "INSERT INTO tbnilai VALUES (?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, nim);
            ps.setString(2, kodeMk);
            ps.setDouble(3, tugas);
            ps.setDouble(4, uts);
            ps.setDouble(5, uas);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }
}
