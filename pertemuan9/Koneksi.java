package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public static Connection getKoneksi() {

        Connection conn = null;

        try {

            String url =
            "jdbc:mysql://localhost:3306/penjualan_db";

            String user = "root";
            String pass = "";

            conn =
            DriverManager.getConnection(url,user,pass);

            System.out.println("Koneksi Berhasil");

        } catch(Exception e){

            System.out.println(e);

        }

        return conn;
    }
}