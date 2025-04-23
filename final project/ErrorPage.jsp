<%@ page import="org.example.chiropractorproject.BusinessObjects.Patients" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.Appointments" %><%--
  Last Modified: 2/24/2025
  Author: Victorino Martinez
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chiropractic - ErrorPage</title>
</head>
<form>
    <%
        Patients p1;
        Doctors d1;
        Appointments a1;

        p1 = (Patients)session.getAttribute("p1");
        d1 = (Doctors)session.getAttribute("d1");
        a1 = (Appointments)session.getAttribute("a1");


    %>

    <h1><%= "Error logging in for User with ID " + p1.getpatid() + "!" %></h1>

    <h1><%= "Error logging in for Doctor with ID " + d1.getdocid() + "!" %></h1>

    <h1><%= "Error retrieving appointment information for User with ID " + p1.getpatid() + "!" %></h1>


    <a href = "login.jsp" > Login Page</a>


</form>
</html>
