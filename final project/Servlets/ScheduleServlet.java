/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.chiropractorproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.chiropractorproject.BusinessObjects.ApptList;
import org.example.chiropractorproject.BusinessObjects.Doctors;
import org.example.chiropractorproject.BusinessObjects.Patients;

import java.io.*;

/**
 *
 * @author Calla
 */
@WebServlet(name = "ScheduleServlet", urlPatterns = {"/ScheduleServlet"})
public class ScheduleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Patients pat = (Patients) session.getAttribute("p1");

        Doctors doc = new Doctors();
        doc.selectDBDocLN(request.getParameter("docln"));
        if ("".equals(doc.getdocid()) || doc.getdocid() == null) {
            RequestDispatcher r = request.getRequestDispatcher("/Error.jsp");
            r.forward(request, response);
        } else {
            ApptList apptlist = new ApptList();
            apptlist.selectDBDocId(doc.getdocid());

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


}