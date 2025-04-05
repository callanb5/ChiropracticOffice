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

@WebServlet(name = "PAccountInfoServlet", urlPatterns = {"/PAccountInfoServlet"})
public class PAccountInfoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = "";
        String pw = "";
        String fn = "";
        String ln = "";
        String email = "";


        try {
            id = request.getParameter("idtb");
            pw = request.getParameter("pwtb");
            fn = request.getParameter("fntb");
            ln = request.getParameter("lntb");
            email = request.getParameter("emtb");


            //Patients Business Object
            Patients p1 = new Patients();

            //updating patient information in database based on patient ID
            p1.updateDB(id, pw, fn, ln, email);

            //Putting Customer object into the Session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("p1", p1);
            System.out.println("Customer added to Session/scheduling Patient-Profile.jsp");

            //forward page to Patient-Home.jsp if all patient fields are filled out/ not null
            if (id != null && pw != null && fn != null && ln != null && email != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Patient-Profile.jsp");
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

}
