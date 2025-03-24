<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Pationt-Login.jsp
 ======================================================  --%>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CT-Chiroprtic Pationt-Login-Page</title>
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
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="Just-Appointments">APPOINTMENTS</a></li>
                    <li><a href="F&Q.jsp">CONTACT US</a></li>
                    <li><a href="Patient-Home.jsp">Work around HELP</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li><a href="Doctor-Login.jsp" class="logBtn">Doctor Login<div>&#8594;</div></a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
        <main>
               <section class="mb">
                <div class="mb1">
                    <section>
                 <form action="LoginServlet">
                 <div>
                    <div class="logTab">
                    <h1 class="logh1"> Customer Login  </h1>
                    <table border="3">
                        <tr>
                            <td class="tableName">ID:</td>
                            <td><input type="text" name="idtb" /></td>
                        </tr>
                        <tr>
                            <td class="tableName">Password:</td>
                            <td><input class="tableName1" type="text" name="pwtb" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Login" class="buttons"/></td>
                            <td><input type="reset" value="Clear" class="buttons"/></td>
                        </tr>
                    </table>
                </div>
            </form>
                    </section>
                    
                    <section>
                        <div>
                        <h2>Main Hook for this section</h2>
                        <p>This is what i was waiting for, this is waht i was waiting for.
                        testing the limit of the text size to determin how to fill this space along with making it more barabol.</p>
                        </div>
                    </section>
                </div>
                
                <div class="mb2">
                    <section></section>

                    <section>
                        <a href="">
                            <button>Join us</button>
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
