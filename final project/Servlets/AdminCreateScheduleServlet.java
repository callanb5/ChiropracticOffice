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
import org.example.chiropractorproject.BusinessObjects.Schedule;

@WebServlet(name = "AdminCreateScheduleServlet", urlPatterns = {"/AdminCreateScheduleServlet"})
public class AdminCreateScheduleServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String monday = "";
        String tuesday = "";
        String wednesday = "";
        String thursday = "";
        String friday = "";
        String saturday = "";
        String sunday = "";



        try {
            monday = request.getParameter("Monday");
            tuesday = request.getParameter("Tuesday");
            wednesday = request.getParameter("Wednesday");
            thursday = request.getParameter("Thursday");
            friday = request.getParameter("Friday");
            saturday = request.getParameter("Saturday");
            sunday = request.getParameter("Sunday");


            //Schedule Business Object
            Schedule s1 = new Schedule();


                    //updating schedule for Monday
                    s1.updateDB("Monday", monday);
                    //updating schedule for Tuesday
                    s1.updateDB("Tuesday", tuesday);
                    //updating schedule for Wednesday
                    s1.updateDB("Wednesday", wednesday);
                    //updating schedule for Thursday
                    s1.updateDB("Thursday", thursday);
                    //updating schedule for Friday
                    s1.updateDB("Friday", friday);
                    //updating schedule for Saturday
                    s1.updateDB("Saturday", saturday);
                    //updating schedule for Sunday
                    s1.updateDB("Sunday", sunday);


            //forward page to Patient-Home.jsp if all patient fields are filled out/ not null
            if (monday != null && tuesday != null && wednesday != null && thursday != null && friday != null && saturday != null && sunday != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/Admin-DocSchedule.jsp");
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



}


