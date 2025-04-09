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

@WebServlet(name = "CreatePatientAccountServlet", urlPatterns = {"/CreatePatientAccountServlet"})
public class CreatePatientAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int id = 0;
        String realid = null;
        String patid = "";
        String pw = "";
        String fn = "";
        String ln = "";
        String email = "";


        try {
            patid = request.getParameter("idtb");
            pw = request.getParameter("pwtb");
            fn = request.getParameter("fntb");
            ln = request.getParameter("lntb");
            email = request.getParameter("emtb");


            //Patients Business Object
            Patients p1 = new Patients();
            Patients p2 = new Patients();

            //retrieving the highest PatID from database
            p1.selecthighIDDB();
            id = Integer.parseInt(p1.getpatid());
            System.out.println("Id Pulled from database: " + id);
            //Incrementing id up by 1 to provide new ID to new patient
            id++;
            System.out.println("New ID: " + id);

            //if id pulled is single digit, add (3) 000's to number making 0001...0009
            if (id < 10) {
                String.valueOf(id);
                realid = "000" + id;
            }
            //if id pulled is double digits, add (2) 00's to number making 0010...0099
            else if (id >= 10) {
                String.valueOf(id);
                realid = "00" + id;
            }
            //if id pulled is triple digits, add (1) 0's to number making 0100...0999
            else if (id >= 100) {
                String.valueOf(id);
                realid = "0" + id;
            }
            //if id pulled is 4 digits, add no 0's to number making 1000...9999
            else if (id >= 1000) {
                String.valueOf(id);
            }

            //inserting new patient information into database
            p2.insertDB(realid,pw,fn,ln,email);
            p2.selectDB(realid);

            //Putting Customer object into the Session
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("p1", p2);
            System.out.println("Customer added to Session/scheduling Patient-Home.jsp");

            //forward page to Patient-Home.jsp if all patient fields are filled out/ not null
            if (patid != null && pw != null && fn != null && ln != null && email != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Patient-Home.jsp");
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

}//end CreatePatientAccountServlet()
