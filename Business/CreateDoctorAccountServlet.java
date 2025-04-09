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
import org.example.chiropractorproject.BusinessObjects.Patients;

@WebServlet(name = "CreateDoctorAccountServlet", urlPatterns = {"/CreateDoctorAccountServlet"})
public class CreateDoctorAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int id;
        String realid = null;
        String docid = "";
        String pw = "";
        String fn = "";
        String ln = "";
        String email = "";
        String tempadmin;
        Boolean admin;


        try {
            docid = request.getParameter("idtb");
            pw = request.getParameter("pwtb");
            fn = request.getParameter("fntb");
            ln = request.getParameter("lntb");
            email = request.getParameter("emtb");
            tempadmin = request.getParameter("adtb");
            System.out.println(tempadmin);

            if (tempadmin != null && tempadmin.equals("true")) {
                admin = true;
            } else {
                admin = false;
            }


            //Doctors Business Object
            Doctors d1 = new Doctors();
            Doctors d2 = new Doctors();

            //retrieving the highest DocID from database
            d1.selecthighIDDB();
            id = Integer.parseInt(d1.getdocid());
            System.out.println("Id Pulled from database: " + id);
            //Incrementing id up by 1 to provide new ID to new doctor
            id++;
            System.out.println("New ID: " + id);

            //if id pulled is single digit, add (3) 000's to number making 0001...0009
            if (id < 10) {
                String.valueOf(id);
                realid = "00" + id;
            }
            //if id pulled is double digits, add (2) 00's to number making 0010...0099
            else if (id >= 10) {
                String.valueOf(id);
                realid = "0" + id;
            }
            //if id pulled is triple digits, add (1) 0's to number making 0100...0999
            else if (id >= 100) {
                realid = String.valueOf(id);
            }

            //inserting new doctor information into database
            d2.insertDB(realid,pw,fn,ln,email,admin);
            d2.selectDB(realid);

            //forward page to Patient-Home.jsp if all patient fields are filled out/ not null
            if (docid != null && pw != null && fn != null && ln != null && email != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin-Home.jsp");
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

}//end CreateDoctorAccountServlet()
