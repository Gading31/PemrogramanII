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
import java.sql.DriverManager;

public class Koneksi {

    private Connection connection;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbaplikasipenilaianmahasiswa",
                    "root",
                    ""
            );

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {

            System.out.println("Koneksi Gagal");
            System.out.println(e);

        }

        return connection;
    }
}