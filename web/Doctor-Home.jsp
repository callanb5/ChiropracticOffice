<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CT-Chiroprtic Pationt-Login-Page</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
    </head>
    <%@page import="org.example.Doctors"%>
    <%
        Doctors doc = (Doctors) session.getAttribute("d1");
        String docName = doc.getfirstname() + " " + doc.getlastname();
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
                    <li><a href="landingPage.jsp">HOME</a></li>
                    <li><a href="">APPOINTMENTS</a></li>
                    <li><a href="">CONTACT US</a></li>
                    <li><a href="">HELP</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li>Signed in as <%=docName%></li>
                     <li><a href="Doctor-Login.jsp" class="logBtn">Sign Out</a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
        <main>
            <br>
            <center><h1>Welcome, <%=docName%></h1></center>
               <section class="mb">
                <div class="mb1">
                    <section>
                        <h2>Account Information</h2>
                        <a href="Doctor-Profile.jsp">
                            <button>Acount Info</button>
                        </a>
                    </section>
                    
                    <section>
                        <h2>Search by Day</h2>
                        <a href="Doctor-D_T-Appointments.jsp">
                            <button>Search by Day</button>
                        </a>
                    </section>
                </div>
                
                <div class="mb1">

                    <section>
                        <h2>View Patient List</h2>
                        <a href="Doctor-P-List.jsp">
                            <button>Patient List</button>
                        </a>
                    </section>
                    
                    <section>
                        <h2>Search Patient History</h2>
                        <a href="Doctor-P_L-Appointments.jsp">
                            <button>Search Patient History</button>
                        </a>
                    </section>
                </div>
            </section>

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
