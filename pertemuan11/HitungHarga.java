/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dingg
 */
@WebServlet(urlPatterns = {"/HitungHarga"})
public class HitungHarga extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String namaBarang =
request.getParameter("namaBarang");

double hargaSatuan =
Double.parseDouble(
request.getParameter("hargaSatuan")
);

int jumlah =
Integer.parseInt(
request.getParameter("jumlah")
);

double totalHarga =
hargaSatuan * jumlah;

double diskon = 0;

if(jumlah >= 100 &&
   totalHarga >= 1000000){

    diskon = totalHarga * 0.05;

}

double bayar =
totalHarga - diskon;
        
        try (PrintWriter out =
response.getWriter()) {

out.println("<html>");
out.println("<body>");

out.println("<h2>Hasil Perhitungan</h2>");

out.println("Nama Barang : "
+ namaBarang);

out.println("<br><br>");

out.println("Harga Satuan : "
+ hargaSatuan);

out.println("<br><br>");

out.println("Jumlah : "
+ jumlah);

out.println("<br><br>");

out.println("Total Harga : "
+ totalHarga);

out.println("<br><br>");

out.println("Diskon : "
+ diskon);

out.println("<br><br>");

out.println("Total Bayar : "
+ bayar);

out.println("</body>");
out.println("</html>");

}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
