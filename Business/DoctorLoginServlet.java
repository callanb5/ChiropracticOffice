package org.example.chiropractorproject;
/*
    Last Modified: 3/17/2025
    Author: Victorino Martinez
*/
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.example.chiropractorproject.BusinessObjects.Doctors;

@WebServlet(name = "DoctorLoginServlet", urlPatterns = {"/DoctorLoginServlet"})
public class DoctorLoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = "";
        String pw = "";

        try {
            id = request.getParameter("idtb");
            pw = request.getParameter("pwtb");
            System.out.println("---Password Received---");

            //Doctor Business Object
            Doctors d1;
            d1 = new Doctors();

            //getting Doctor info from Doctors
            d1.selectDB(id);
            String CID = d1.getdocid();
            String PASS = d1.getpwd();
            Boolean ADMIN = d1.getadmin();
            System.out.println("Doctor ID: " + d1.getdocid());
            System.out.println("Password: " + d1.getpwd());
            if (ADMIN = true) {
                System.out.println("Admin: True");
            } else if (ADMIN = false) {
                System.out.println("Admin: False");
            }

            //Putting Customer object into the Session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("d1", d1);
            System.out.println("Patient added to Session/scheduling Doctor-Home.jsp or Admin-Home.jsp");


            //forward page to Doctor-Home.jsp if login matches database/ else forward to ErrorPage.jsp
            if (pw.equals(PASS) && id.equals(CID) && ADMIN.equals(false)) {
                RequestDispatcher rd = request.getRequestDispatcher("/Doctor-Home.jsp");
                rd.forward(request, response);

            } else if (pw.equals(PASS) && id.equals(CID) && ADMIN.equals(true)) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin-Home.jsp");
                rd.forward(request, response);

            } else {
                System.out.println("Error Occurred");
            }


        } finally {
            out.close();

        }//end try/finally

    }//end processRequest()

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

}//end DoctorLoginServlet()
