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
    
    <%
        Patients p1;

        p1 = (Patients) session.getAttribute("p1");

        String patName = p1.getfirstname() + " " + p1.getlastname();


    %>
    
    <body>
     <nav class="navbar">
            <div class="logo">
                <a href="index.jsp">
                    <img src="img/CTC_Logo.png" alt="logo">
                </a>   
            </div>

             <div class="mNav">
                <ul>
                    <li><a href="Patient-Home.jsp">DASHBOARD</a></li>
                     <li><a href="Patient-APPMain.jsp">APPOINTMENTS</a></li>
                    <li><a href="Patient-profile.jsp">PROFILE</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li class="Sign">Signed in as <%=patName%></li>
                    <li><a href="Patient-Login.jsp" class="logBtn">Sign Out</a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
    <main>
    
        <%
            ArrayList<Timestamp> tsl = (ArrayList<Timestamp>) session.getAttribute("timelist");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < tsl.size(); i++) {
                Timestamp ts = tsl.get(i);
        %>
        <div class="New-Acc">
        <form class="New-Acc">
        <table>
      <tr> <td> <h4>Appointment Available At: <%=dateFormat.format(ts)%></h4>  </td> </tr>
      <tr> <td> <form form action="http://localhost:8080/CTC-Chiropratic/ScheduleAppointmentServlet" method="post">  </td> </tr>
      <tr> <td>     <input type="hidden" name="timestamp" value="<%=ts%>">  </td> </tr>
      <tr> <td>     <button type="submit">Schedule Appointment</button>  </td> </tr>
      <tr> <td>     </table>
        </form>
       
        <%}%>
        </div>
        </main>

          <footer>
            <section class="mFoot">
                <div class="fLogo">
                    <img src="img/CTC_Logo.png" alt="">
                </div>
                
                <section class="sFoot">
                    <div>
                        <h4>Campaign</h4>
                        <ul>
                            <li><a href="">Appointments</a></li>
                            <li><a href="">Pharmacy</a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                        </ul>
                    </div>
        
                    <div>
                        <h4>About us</h4>
                        <ul>
                            <li><a href="">Staff</a></li>
                            <li><a href="">Open hours</a></li>
                            <li><a href="">Policies</a></li>
                            <li><a href="">Locations</a></li>
                        </ul>
                    </div>
    
                    <div>
                        <h4>Contact us</h4>
                        <ul>
                            <li><a href="">(404) 456-7890</a></li>
                            <li><a href="">info@CT-Chiroprtic.com</a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                        </ul>
                    </div>
                </section>
    
                <div class="follow">
                    <h4>Follow us on</h4>
                    <ul>
                        <li><a href="">Gmail</a></li>
                        <li><a href="">Facebook</a></li>
                        <li><a href="">Instagram</a></li>
                        <li><a href="">Twitter</a></li>
                    </ul>
                </div>
            </section>
    
            <section>
                <p>&copy;CT-Chiroprtic 2025. All rights reserved.</p>
            </section>
        </footer>
    </body>
</html>
