<%-- 
    Document   : Schedule-Appointment
    Created on : Apr 5, 2025, 6:15:16 PM
    Author     : Calla
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.sql.Timestamp"%>
    <%@page import="org.example.Patients"%>
    <%@page import="org.example.Appointments"%>
    <%@page import="org.example.Doctors"%>
    <%@page import="org.example.ApptList"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Appointments</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
    </head>
    <body>
        <%
            ArrayList<Timestamp> tsl = (ArrayList<Timestamp>) session.getAttribute("timelist");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < tsl.size(); i++) {
                Timestamp ts = tsl.get(i);
        %>
        <h4>Appointment Available At: <%=dateFormat.format(ts)%></h4>
        <form form action="http://localhost:8080/CTC-Chiropratic/ScheduleAppointmentServlet" method="post">
            <input type="hidden" name="timestamp" value="<%=ts%>">
            <button type="submit">Schedule Appointment</button>
        </form>
        <hr>
        <%}%>
    </body>
</html>
