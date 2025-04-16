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

    <body>  
        <nav class="navbar">
            <div class="logo">
                <a href="index.jsp">
                    <img src="img/CTC_Logo.png" alt="logo">
                </a>   
            </div>

            <div class="mNav">
        <ul>
            <li><a href="Admin-Home.jsp">DASHBOARD</a></li>
        </ul>
    </div>
            
            <div class="sNav">
                <ul>
                    <li class="Sign">Signed in as <%=docName%></li>
                    <li><a href="Doctor-Login.jsp" class="logBtn">Sign Out</a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
        <main>
              
                            <table class="New-Acc">

                                <tr><td><label for="Monday">Monday</label>
                                <label for="Tuesday">Tuesday</label>
                                <label for="Wednesday">Wednesday</label>
                                <label for="Thursday">Thursday:</label>
                                <label for="Friday">Friday:</label>
                                <label for="Saturday">Saturday:</label>
                                <label for="Sunday">Sunday:</label></td></tr>

                                <tr><td>
                                <select name="Monday" id="Monday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>
                                    
                                </select>
                                
                                <select name="Tuesday" id="Tuesday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>
                                    </select>
                                
                                <select name="Wednesday" id="Wednesday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>
                                </select>
                                
                                <select name="Thursday" id="Thursday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>

                                </select>
                                
                                <select name="Friday" id="Friday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>

                                </select>
                                
                                <select name="Saturday" id="Saturday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>

                                </select>
                                
                                <select name="Sunday" id="Sunday">
                                    <option value="Odom">Odom</option>
                                    <option value="Lucero">Lucero</option>
                                    <option value="Dean">Dean</option>
                                    <option value="Melendez">Melendez</option>
                                    <option value="Keller">Keller</option>
                                    <option value="Emilie">Emilie</option>
                                    <option value="House">House</option>

                                </select></td></tr>

                                <tr>
                                <td><input type="submit" value="Change" class="search-button"></td>
                                </tr>
                            </table>

                            <table class="New-Acc">
                            <h1>
                            <?php
                            $Monday="";
                            ?>
                            </h1>



                            </table>
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