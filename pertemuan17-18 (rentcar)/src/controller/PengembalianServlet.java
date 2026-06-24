package controller;

import config.Koneksi;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PengembalianServlet")
public class PengembalianServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int idSewa =
                    Integer.parseInt(
                            request.getParameter(
                                    "id_sewa"));

            String tglKembali =
                    request.getParameter(
                            "tgl_kembali");

            double denda =
                    Double.parseDouble(
                            request.getParameter(
                                    "denda"));

            Connection conn =
                    Koneksi.getConnection();

            String sql =
                    "INSERT INTO pengembalian "
                    + "(id_sewa,tgl_kembali,denda) "
                    + "VALUES(?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, idSewa);
            ps.setString(2, tglKembali);
            ps.setDouble(3, denda);

            ps.executeUpdate();

            PreparedStatement psSewa =
                    conn.prepareStatement(
                    "SELECT id_mobil "
                    + "FROM sewa "
                    + "WHERE id_sewa=?");

            psSewa.setInt(1, idSewa);

            ResultSet rs =
                    psSewa.executeQuery();

            if(rs.next()){

                int idMobil =
                        rs.getInt("id_mobil");

                PreparedStatement update =
                        conn.prepareStatement(
                        "UPDATE mobil "
                        + "SET status='Tersedia' "
                        + "WHERE id_mobil=?");

                update.setInt(1, idMobil);

                update.executeUpdate();

            }

            response.sendRedirect(
                    "pengembalian/data.jsp");

        } catch(Exception e){

            e.printStackTrace();

        }

    }

}