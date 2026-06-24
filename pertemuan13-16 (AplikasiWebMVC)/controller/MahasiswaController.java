package com.unpam.controller;

import com.unpam.model.Mahasiswa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MahasiswaController", urlPatterns = {"/MahasiswaController"})
public class MahasiswaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");
        int semester = Integer.parseInt(request.getParameter("semester"));
        String kelas = request.getParameter("kelas");
        String password = request.getParameter("password");

        Mahasiswa mahasiswa = new Mahasiswa();

        boolean hasil = mahasiswa.simpan(
                nim,
                nama,
                semester,
                kelas,
                password
        );

        response.setContentType("text/html;charset=UTF-8");

        if (hasil) {

            response.getWriter().println(
                    "<h2>Data Mahasiswa Berhasil Disimpan</h2>"
            );

        } else {

            response.getWriter().println(
                    "<h2>Data Mahasiswa Gagal Disimpan</h2>"
            );

        }
    }
}