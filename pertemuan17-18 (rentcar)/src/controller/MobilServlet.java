package controller;

import config.Koneksi;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MobilServlet")
public class MobilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("hapus".equals(action)) {

            try {

                int id = Integer.parseInt(
                        request.getParameter("id"));

                Connection conn =
                        Koneksi.getConnection();

                String sql =
                        "DELETE FROM mobil WHERE id_mobil=?";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setInt(1, id);

                ps.executeUpdate();

                response.sendRedirect("mobil/data.jsp");

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        try {

            Connection conn =
                    Koneksi.getConnection();

            if ("update".equals(action)) {

                int id =
                        Integer.parseInt(
                                request.getParameter("id_mobil"));

                String sql =
                        "UPDATE mobil SET "
                        + "plat_nomor=?, "
                        + "merk=?, "
                        + "tahun=?, "
                        + "harga=?, "
                        + "status=? "
                        + "WHERE id_mobil=?";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setString(1,
                        request.getParameter("plat_nomor"));

                ps.setString(2,
                        request.getParameter("merk"));

                ps.setInt(3,
                        Integer.parseInt(
                                request.getParameter("tahun")));

                ps.setDouble(4,
                        Double.parseDouble(
                                request.getParameter("harga")));

                ps.setString(5,
                        request.getParameter("status"));

                ps.setInt(6, id);

                ps.executeUpdate();

            } else {

                String sql =
                        "INSERT INTO mobil "
                        + "(plat_nomor, merk, tahun, harga, status) "
                        + "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setString(1,
                        request.getParameter("plat_nomor"));

                ps.setString(2,
                        request.getParameter("merk"));

                ps.setInt(3,
                        Integer.parseInt(
                                request.getParameter("tahun")));

                ps.setDouble(4,
                        Double.parseDouble(
                                request.getParameter("harga")));

                ps.setString(5,
                        request.getParameter("status"));

                ps.executeUpdate();

            }

            response.sendRedirect("mobil/data.jsp");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}