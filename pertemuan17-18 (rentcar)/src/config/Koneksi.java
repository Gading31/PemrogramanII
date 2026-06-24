package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        try {

            if (koneksi == null || koneksi.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                koneksi = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/rentcar",
                        "root",
                        ""
                );
            }

        } catch (Exception e) {

            System.out.println("Koneksi Gagal : " + e.getMessage());

        }

        return koneksi;
    }
}