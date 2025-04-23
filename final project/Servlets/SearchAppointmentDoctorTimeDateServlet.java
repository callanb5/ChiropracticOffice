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
import org.example.chiropractorproject.BusinessObjects.ApptList;
import org.example.chiropractorproject.BusinessObjects.Doctors;

/**
 *
 * @author Calla
 */
@WebServlet(name = "SearchAppointmentDoctorTimeDateServlet", urlPatterns = {"/SearchAppointmentDoctorTimeDateServlet"})
public class SearchAppointmentDoctorTimeDateServlet extends HttpServlet {

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

        Doctors doc = new Doctors();
        doc.selectDBDocLN(request.getParameter("docln"));

        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String dateStr = year + "-" + month + "-" + day;

        if ("".equals(doc.getdocid()) || doc.getdocid() == null || "".equals(dateStr) || dateStr == null) {
            System.out.println("Error: Either docid is null/empty or dateStr is null/empty < 0");
            System.out.println("docid: " + doc.getdocid());
            System.out.println("dateStr: " + dateStr);
            RequestDispatcher r = request.getRequestDispatcher("/Error.jsp");
            r.forward(request, response);
        } else {
            Timestamp today = Timestamp.valueOf(LocalDate.now().atStartOfDay());
            Timestamp ts = Timestamp.valueOf(dateStr + " 00:00:00");
            System.out.println("Timestamp: " + ts);
            System.out.println("Today: " + today);

            if (ts.before(today)) {
                System.out.println("Error: Cannot show available appointments in a day before today");
                RequestDispatcher r = request.getRequestDispatcher("/Error.jsp");
                r.forward(request, response);
            }

            ApptList apptlist = new ApptList();
            ArrayList<Timestamp> tsl = apptlist.getAvailableAppointments(doc.getdocid(), ts);

            if (tsl.size() > 0) {
                session.setAttribute("searchdoc", doc);
                session.setAttribute("timelist", tsl);
                RequestDispatcher r = request.getRequestDispatcher("/Schedule-Appointment.jsp");
                r.forward(request, response);
            } else {
                System.out.println("Error: tsl.size() < 0");
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