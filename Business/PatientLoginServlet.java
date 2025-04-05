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

import org.example.chiropractorproject.BusinessObjects.Patients;

@WebServlet(name = "PatientLoginServlet", urlPatterns = {"/PatientLoginServlet"})
public class PatientLoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = "";
        String pw = "";

        try {
            id = request.getParameter("idtb");
            pw = request.getParameter("pawtb");
            System.out.println("---Password Received---");

            //Patients Business Object
            Patients p1;
            p1 = new Patients();

            //getting Customer info from CustomerBO
            p1.selectDB(id);
            String CID = p1.getpatid();
            String PASS = p1.getpwd();
            System.out.println("Customer ID: " + p1.getpatid());
            System.out.println("Password: " + p1.getpwd());

            //Putting Customer object into the Session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("p1", p1);
            System.out.println("Customer added to Session/scheduling PatientHomePage.jsp");


            //forward page to AccountLookup.jsp if login matches database/ else forward to ErrorPage.jsp
            if (pw.equals(PASS) && id.equals(CID)) {
                RequestDispatcher rd = request.getRequestDispatcher("/PatientHomePage.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
                rd.forward(request, response);
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

}//end LoginServlet()
