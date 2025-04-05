/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Calla
 */
@WebServlet(name = "SearchAppointmentTimeDateServlet", urlPatterns = {"/SearchAppointmentTimeDateServlet"})
public class SearchAppointmentTimeDateServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Patients pat = (Patients) session.getAttribute("p1");

        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String dateStr = year + "-" + month + "-" + day;
        
        if ("".equals(dateStr) || dateStr == null) {
            RequestDispatcher r = request.getRequestDispatcher("/Error.jsp");
            r.forward(request, response);
        } else {
            Timestamp ts = Timestamp.valueOf(dateStr + " 00:00:00");
            System.out.println("Timestamp: " + ts);

            ApptList apptlist = new ApptList();
            apptlist.selectDBApptDate(pat.getpatid(), ts);

            if (apptlist.count > 0) {
                session.setAttribute("apptlist", apptlist);
                RequestDispatcher r = request.getRequestDispatcher("/SearchResults.jsp");
                r.forward(request, response);
            } else {
                RequestDispatcher r = request.getRequestDispatcher("/Error.jsp");
                r.forward(request, response);
            }
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
