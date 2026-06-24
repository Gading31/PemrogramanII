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

public class TestKoneksi {

    public static void main(String[] args) {

        Koneksi koneksi = new Koneksi();

        Connection con = koneksi.getConnection();

        if (con != null) {

            System.out.println("DATABASE TERHUBUNG");

        } else {

            System.out.println("DATABASE GAGAL TERHUBUNG");

        }
    }
}
