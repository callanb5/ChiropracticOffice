<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Login.jsp
 ======================================================  --%>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor-Login-Page</title>
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
                    <li><a href="index.jsp">HOME</a></li>
                    <li><a href="F&Q.jsp">CONTACT US</a></li>
                    <li><a href="Doctor-Home.jsp">Work around HELP</a></li>
                </ul>
            </div>
            
            <div class="sNav">
                <ul>
                    <li><a href="Patient-Login.jsp" class="logBtn">Patient Login<div>&#8594;</div></a></li>
                    <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
                </ul>
            </div>
    
    </nav> 
       <main>
               <section class="mb">
                <div class="mb1">
                    <section>
                    <div  class="logIn">
                       <form action="LoginServlet">
                 <div>
                    <div class="logTab">
                    <h1 class="logh1"> Doctor Login  </h1>
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
                            <td><input type="submit" value="Login" class="button"/></td>
                            <td><input type="reset" value="Clear" class="button"/></td>
                        </tr>
                    </table>
                </div>
            </form>
                         </div>
                    </section>
                    
                    <section>
                        <div>
                        <h2>IF you mistakenly got onto this page, click the button below to get back to the Home page!</h2><br>
                        <h2>Or click the Patient Button an the navigation bar to login into you account!</h2><br>
                        <a href="index.jsp">
                            <button>Back Home!</button>
                        </a>
                        </div>
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
