<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CT-Chiroprtic Doctor-profile-Page</title>
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
                    <li><a href="Doctor-Home.jsp">DASHBOARD</a></li>
                     <li><a href="Doctor-P_L-Appointments.jsp">APPOINTMENTS</a></li>
                    <li><a href="Doctor-Profile.jsp">PROFILE</a></li>
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
               <section class="mb">
                
                <div class="mb2">
                    <section></section>

                    <section>
                       <form>           
               <%
                   Account a1;
                   
                   a1 = (Account)session.getAttribute("a1");
                   
                   a1.display();
                   
               %>
               
               
                <h1  class="logh1"> Account Lookup Page  </h1>
                <table border="3">
                    <tr>
                       <td class="tableName">Acct No:</td>
                       <td><input type="text" name="an" value="<%=a1.getAcctNo() %>" /></td>
                    </tr>
                    <tr>
                       <td class="tableName">Customer ID:</td>
                       <td><input type="text" name="custtb" value="<%=a1.getCid()%>" /></td>
                    </tr>
                    <tr>
                       <td class="tableName">Type:</td>
                       <td><input type="text" name="typetb" value="<%=a1.getType() %>" /></td>
                    </tr>
                    <tr>
                       <td class="tableName">Balance:</td>
                       <td><input type="text" name="baltb" value="<%=a1.getBalance() %>" /></td>
                    </tr>
                    <tr>
                       <td><input type="submit" value="Find" class="button"/></td>
                       <td><input type="reset" value="Clear" class="button"/></td>
                    </tr>
                </table>
            </form>
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