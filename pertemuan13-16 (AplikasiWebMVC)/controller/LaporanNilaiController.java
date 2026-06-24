/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unpam.controller;

import com.unpam.model.Mahasiswa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MahasiswaController", urlPatterns = {"/MahasiswaController"})
public class LaporanNilaiController extends HttpServlet{
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=UTF-S");
        
        HttpSession session = request.getSession();
    }
              
    
}
