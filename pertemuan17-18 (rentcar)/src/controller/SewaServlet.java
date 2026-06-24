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

@WebServlet("/SewaServlet")
public class SewaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int idCustomer =
                    Integer.parseInt(
                            request.getParameter("id_customer"));

            int idMobil =
                    Integer.parseInt(
                            request.getParameter("id_mobil"));

            String tglSewa =
                    request.getParameter("tgl_sewa");

            int lamaSewa =
                    Integer.parseInt(
                            request.getParameter("lama_sewa"));

            Connection conn =
                    Koneksi.getConnection();

            PreparedStatement psHarga =
                    conn.prepareStatement(
                            "SELECT harga FROM mobil WHERE id_mobil=?");

            psHarga.setInt(1, idMobil);

            ResultSet rs =
                    psHarga.executeQuery();

            double harga = 0;

            if(rs.next()){

                harga =
                        rs.getDouble("harga");

            }

            double total =
                    harga * lamaSewa;

            String sql =
                    "INSERT INTO sewa "
                    + "(id_customer,id_mobil,tgl_sewa,lama_sewa,total) "
                    + "VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, idCustomer);
            ps.setInt(2, idMobil);
            ps.setString(3, tglSewa);
            ps.setInt(4, lamaSewa);
            ps.setDouble(5, total);

            ps.executeUpdate();

            PreparedStatement updateMobil =
                    conn.prepareStatement(
                            "UPDATE mobil SET status='Disewa' WHERE id_mobil=?");

            updateMobil.setInt(1, idMobil);

            updateMobil.executeUpdate();

            response.sendRedirect(
                    "sewa/data.jsp");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}