/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unpam.model;

/**
 *
 * @author dingg
 */
public class TestMahasiswa {

    public static void main(String[] args) {

        Mahasiswa mhs = new Mahasiswa();

        boolean hasil = mhs.simpan(
                "231011401651",
                "Muhammad Gading Herlambang Sopian",
                6,
                "06TPLE016",
                "310105"
        );

        if (hasil) {

            System.out.println("DATA BERHASIL DISIMPAN");

        } else {

            System.out.println("DATA GAGAL DISIMPAN");

        }
    }
}
