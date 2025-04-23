<%@ page import="org.example.chiropractorproject.BusinessObjects.Patients" %>
<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Pataint-Home_page.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Patient-Home</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>

<%
    Patients pat = (Patients) session.getAttribute("p1");
    String patName = pat.getfirstname() + " " + pat.getlastname();
%>
<body>
<nav class="navbar">
    <div class="logo">
        <a href="index.jsp">
            <img src="CTC_Logo.png" alt="logo">
        </a>
    </div>
    <%--
                 <div class="mNav">
                    <ul>
                        <li><a href="Patient-Home.jsp">DASHBOARD</a></li>
                         <li><a href="Patient-APPMain.jsp">APPOINTMENTS</a></li>
                        <li><a href="Patient-profile.jsp">PROFILE</a></li>
                    </ul>
                </div>
                 --%>
    <div class="sNav">
        <ul>
            <li class="Sign">Signed in as <%=patName%></li>
            <li><a href="Patient-Login.jsp" class="logBtn">Sign Out</a></li>
            <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
        </ul>
    </div>

</nav>
<main>
    <br>
    <h1 class="Welcome">Welcome, <%=patName%></h1>
    <section class="mb">
        <div class="mb1">
            <section>
                <h2>Review Profile and Contact Information</h2>
                <a href="Patient-Profile.jsp">
                    <button>Account Info</button>
                </a>
            </section>

            <section>
                <h2>View Appointments</h2>
                <a href="Patient-APPMain.jsp">
                    <button>View Appointments</button>
                </a>
            </section>
        </div>
    </section>
</main>

<footer>
    <section class="mFoot">
        <div class="fLogo">
            <img src="CTC_Logo.png" alt="">
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