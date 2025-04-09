package org.example;

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

@WebServlet(name = "DAccountInfoServlet", urlPatterns = {"/DAccountInfoServlet"})
public class DAccountInfoServlet extends HttpServlet {

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


            //Doctors Business Object
            Doctors d1 = new Doctors();

            //updating doctor information in database based on doctor ID
            d1.updateDB(id, pw, fn, ln, email);

            //Putting Customer object into the Session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("d1", d1);
            System.out.println("Doctor added to Session/scheduling Doctor-Profile.jsp");

            //forward page to Patient-Home.jsp if all patient fields are filled out/ not null
            if (id != null && pw != null && fn != null && ln != null && email != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Doctor-Profile.jsp");
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

