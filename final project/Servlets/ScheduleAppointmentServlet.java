package org.example.chiropractorproject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chiropractorproject.BusinessObjects.Appointments;
import org.example.chiropractorproject.BusinessObjects.Doctors;
import org.example.chiropractorproject.BusinessObjects.Patients;

/**
 *
 * @author Calla
 */
@WebServlet(name = "ScheduleAppointmentServlet", urlPatterns = {"/ScheduleAppointmentServlet"})
public class ScheduleAppointmentServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Patients pat = (Patients) session.getAttribute("p1");
        Doctors doc = (Doctors) session.getAttribute("searchdoc");
        String tsString = request.getParameter("timestamp");
        Timestamp ts = Timestamp.valueOf(tsString);

        if ("".equals(doc.getdocid()) || doc.getdocid() == null || "".equals(pat.getpatid()) || pat.getpatid() == null || "".equals(tsString) || tsString == null) {
            System.out.println("Error: null/empty string");
            RequestDispatcher r = request.getRequestDispatcher("/Error.jsp");
            r.forward(request, response);
        } else {
            System.out.println("Timestamp: " + ts);

            Appointments a = new Appointments();
            a.selecthighIDDB();
            a.setApptID(a.getApptID() + 1);

            if (a.insertDB(a.getApptID(), ts, doc.getdocid(), pat.getpatid(), "None")) {
                session.setAttribute("appt", a);
                RequestDispatcher r = request.getRequestDispatcher("/Schedule-Success.jsp");
                r.forward(request, response);
            } else {
                System.out.println("Error: Insert failed");
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
