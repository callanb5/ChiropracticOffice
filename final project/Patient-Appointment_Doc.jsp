<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CT-Chiroprtic Pationt-calander-Page</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
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
                    <li><a href="Patient-Home.jsp">DASHBOARD</a></li>
                     <li><a href="Patient-APPMain.jsp">APPOINTMENTS</a></li>
                    <li><a href="Patient-profile.jsp">PROFILE</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li><a href="Patient-Login.jsp" class="logBtn">Login<div>&#8594;</div></a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    </nav> 
        <main><br><br><br><br><br>
             
               
                            <form form action="http://localhost:8080/CTC-Chiropratic/SearchAppointmentDoctorServlet" method="post">
                            
                                
                                <table class="New-Acc">
                                <tr>
                               <td> <label for="dent">Doctor Last Name:</label> </td>
                                </tr>
                                <tr>
                               <td> <input type="text" id="docln" name="docln"></td>
                               </tr>
                               <tr>
                               <td> <input type="submit" value="Search" class="search-button"></td>
                             
                           
                            </tr>
                                </table>
                                 
                            </form>
                           <a href="Patient-APPMain.jsp" class="Next">
                            <button>Back</button></a><br><br><br><br><br>

                  
              

        </main>
        
        <footer>
            <section class="mFoot">
                <div class="fLogo">
                    <img src="img/CTC_Logo.png" alt="">
                </div>
                
                <section class="sFoot">
                    <div>
                        <h4>Campain</h4>
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
