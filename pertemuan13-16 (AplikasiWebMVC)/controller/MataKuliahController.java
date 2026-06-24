/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.unpam.controller;

import com.unpam.model.MataKuliah;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MataKuliahController", urlPatterns = {"/MataKuliahController"})
public class MataKuliahController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String kodeMataKuliah =
                request.getParameter("kodeMataKuliah");

        String namaMataKuliah =
                request.getParameter("namaMataKuliah");

        int jumlahSks =
                Integer.parseInt(
                        request.getParameter("jumlahSks"));

        MataKuliah mk = new MataKuliah();

        boolean hasil = mk.simpan(
                kodeMataKuliah,
                namaMataKuliah,
                jumlahSks
        );

        response.setContentType("text/html;charset=UTF-8");

        if (hasil) {

            response.getWriter().println(
                    "<h2>Data Mata Kuliah Berhasil Disimpan</h2>"
            );

        } else {

            response.getWriter().println(
                    "<h2>Data Mata Kuliah Gagal Disimpan</h2>"
            );

        }
    }
}
