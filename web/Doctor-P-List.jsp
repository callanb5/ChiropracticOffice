<%-- 
    Document   : Doctor-P-List
    Created on : Apr 12, 2025, 12:21:27 AM
    Author     : Calla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CTC Chiropractic - Patient List</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>Patient List</h1>
        <%@page import="org.example.Patients"%>
        <%@page import="org.example.Appointments"%>
        <%@page import="org.example.Doctors"%>
        <%@page import="org.example.PatientList"%>

        <%
            Doctors doc = (Doctors) session.getAttribute("d1");
            PatientList patlist = new PatientList();
            patlist.selectDBDocId(doc.getdocid());
            for (int i = 0; i < patlist.count; i++) {
                Patients pat = patlist.patArrayList.get(i);

        %>
        <div class="New-Acc">
        <form class="New-Acc">
        <table>
        <tr> <td>  <h4>Patient ID: <%=pat.getpatid()%></h4>                                 </td> </tr>
        <tr> <td>  <h4>Patient Name: <%=pat.getfirstname() + " " + pat.getlastname()%></h4> </td> </tr>
        <tr> <td>  <h4>Patient Email: <%=pat.getemail()%></h4>                              </td> </tr>
         </table>
         </form>
        <%}%>
        </dv>
        <button onclick="history.back()">Back</button>
    </body>
</html>
