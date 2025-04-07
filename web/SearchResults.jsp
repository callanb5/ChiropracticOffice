<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CTC Chiropractic - Search Results</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
    </head>
    <body>
        <h1>Appointment Details</h1>
        <%@page import="org.example.Patients"%>
        <%@page import="org.example.Appointments"%>
        <%@page import="org.example.Doctors"%>
        <%@page import="org.example.ApptList"%>

        <%
            ApptList apptlist = (ApptList) session.getAttribute("apptlist");
            for (int i = 0; i < apptlist.count; i++) {
            Appointments appt = apptlist.appArrayList.get(i);
            Patients pat = new Patients();
            pat.selectDB(appt.getPatID());
            Doctors doc = new Doctors();
            doc.selectDB(appt.getDocID());
            
        %>
        <h4>Appointment ID: <%=appt.getApptID()%></h4>
        <h4>Appointment Date/Time: <%=appt.getApptDateTime()%></h4>
        <h4>Patient: <%=pat.getfirstname() + " " + pat.getlastname()%></h4>
        <h4>Doctor: <%=doc.getfirstname() + " " + doc.getlastname()%></h4>
        <h4>Notes: <%=appt.getNotes()%></h4>
        <hr>
        <%}%>
        
        <a href="Patient-APPMain.jsp" class="back">Back</a>
    </body>
</html>
