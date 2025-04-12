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
       <nav class="navbar">
            <div class="logo">
                <a href="index.jsp">
                    <img src="img/CTC_Logo.png" alt="logo">
                </a>   
            </div>

            <div class="mNav">
                <ul>
                    <li><a href="landingPage.jsp">HOME</a></li>
                    <li><a href="">APPOINTMENTS</a></li>
                    <li><a href="">CONTACT US</a></li>
                    <li><a href="">HELP</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li><a href="Doctor-Login.jsp" class="logBtn">Sign Out</a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
        <main>

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
                            <li><a href="">info@CTC-Chiropractic.com</a></li>
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
                <p>&copy;CTC Chiropractic 2025. All rights reserved.</p>
            </section>
        </footer>
    </body>
</html>
