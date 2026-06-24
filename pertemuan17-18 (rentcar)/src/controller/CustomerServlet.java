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

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        if ("hapus".equals(action)) {

            try {

                int id =
                        Integer.parseInt(
                                request.getParameter("id"));

                Connection conn =
                        Koneksi.getConnection();

                String sql =
                        "DELETE FROM customer "
                        + "WHERE id_customer=?";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setInt(1, id);

                ps.executeUpdate();

                response.sendRedirect(
                        "customer/data.jsp");

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
                                request.getParameter("id_customer"));

                String sql =
                        "UPDATE customer SET "
                        + "nama=?, "
                        + "alamat=?, "
                        + "telepon=? "
                        + "WHERE id_customer=?";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setString(1,
                        request.getParameter("nama"));

                ps.setString(2,
                        request.getParameter("alamat"));

                ps.setString(3,
                        request.getParameter("telepon"));

                ps.setInt(4, id);

                ps.executeUpdate();

            } else {

                String sql =
                        "INSERT INTO customer "
                        + "(nama,alamat,telepon) "
                        + "VALUES(?,?,?)";

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ps.setString(1,
                        request.getParameter("nama"));

                ps.setString(2,
                        request.getParameter("alamat"));

                ps.setString(3,
                        request.getParameter("telepon"));

                ps.executeUpdate();

            }

            response.sendRedirect(
                    "customer/data.jsp");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}