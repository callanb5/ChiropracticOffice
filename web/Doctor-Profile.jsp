<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %>
<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Profile.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Doctor-Profile-Page</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>
<%
    Doctors d1;

    d1 = (Doctors)session.getAttribute("d1");

    String docName = d1.getfirstname() + " " + d1.getlastname();


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
            <li><a href="Doctor-Home.jsp">DASHBOARD</a></li>
            <li><a href="Patient-Appointment_List.jsp">APPOINTMENTS</a></li>
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
    <br><br>
        <Form class="New-Acc">
            <table>
            <TR>
                <TD>Doctor ID:</TD>
                <TD><INPUT TYPE = "text" name = "idtb" value="<%=d1.getdocid()%>" readonly></TD>
            </TR>
       
            <TR>
                <TD>Password:</TD>
                <TD><INPUT TYPE = "text" name = "pwtb" value="<%=d1.getpwd()%>" readonly></TD>
            </TR>
       
            <TR>
                <TD>First Name:</TD>
                <TD><INPUT TYPE = "text" name = "fntb#" value="<%=d1.getfirstname()%> " readonly></TD>
            </TR>
        
            <TR>
                <TD>Last Name:</TD>
                <TD><INPUT TYPE = "text" name = "lntb" value="<%=d1.getlastname()%>" readonly></TD>
            </TR>
        
            <TR>
                <TD>Email:</TD>
                <TD><INPUT TYPE = "text" name = "emtb" value="<%=d1.getemail()%>" readonly></TD>
            </TR>
       </table>
            </Form>
        <div class="fix">
     <a class="Next" href="DoctorProfileEdit.jsp"><button>Edit Profile</button></a>
     </div>
        <br>
            
   
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
        <p>&copy;CT-Chiropractic 2025. All rights reserved.</p>
    </section>
</footer>
</body>

</html>
