<%@ page import="org.example.Patients" %><%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Patient-Update-Profile</title>
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>
<%
  Patients p1;

  p1 = (Patients)session.getAttribute("p1");

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
    </ul>
  </div>

  <div class="sNav">
    <ul>
      <h3><%=patName%></h3>
      <li><a href="Patient-Login.jsp" class="logBtn">Sign Out</a></li>
      <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
    </ul>
  </div>

</nav>
<main><br>
 <form class="New-Acc">
               <table>
        <TR>
          <TD>Patient ID:</TD>
          <TD><INPUT TYPE = "text" name = "idtb" value="<%=p1.getpatid()%>" readonly></TD>
        </TR>
    
        <TR>
          <TD>Password:</TD>
          <TD><INPUT TYPE = "text" name = "pwtb" value="<%=p1.getpwd()%>" ></TD>
        </TR>
     
        <TR>
          <TD>First Name:</TD>
          <TD><INPUT TYPE = "text" name = "fntb" value="<%=p1.getfirstname()%>" ></TD>
        </TR>
     
        <TR>
          <TD>Last Name:</TD>
          <TD><INPUT TYPE = "text" name = "lntb" value="<%=p1.getlastname()%>" ></TD>
        </TR>
      
        <TR>
          <TD>Email:</TD>
          <TD><INPUT TYPE = "text" name = "emtb" value="<%=p1.getemail()%>" ></TD>
        </TR>
     
        <tr>
          <td><input type="submit" value="Confirm" class="button"/></td>
        </tr>
        </table>
    </form>
  </div><br>
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

