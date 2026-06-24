/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.unpam.controller;

import com.unpam.model.Nilai;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "NilaiController",
        urlPatterns = {"/NilaiController"}
)
public class NilaiController extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nim =
                request.getParameter("nim");

        String kodeMk =
                request.getParameter("kodeMk");

        double tugas =
                Double.parseDouble(
                        request.getParameter("tugas"));

        double uts =
                Double.parseDouble(
                        request.getParameter("uts"));

        double uas =
                Double.parseDouble(
                        request.getParameter("uas"));

        Nilai nilai = new Nilai();

        boolean hasil =
                nilai.simpan(
                        nim,
                        kodeMk,
                        tugas,
                        uts,
                        uas);

        response.setContentType(
                "text/html;charset=UTF-8");

        if (hasil) {

            response.getWriter().println(
                    "<h2>Data Nilai Berhasil Disimpan</h2>"
            );

        } else {

            response.getWriter().println(
                    "<h2>Data Nilai Gagal Disimpan</h2>"
            );

        }
    }
}
