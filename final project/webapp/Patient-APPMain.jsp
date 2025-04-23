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
    <title>Appointment-Main-Page</title>
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
            <img src="CTC_Logo.png" alt="logo">
        </a>
    </div>

    <div class="mNav">
        <ul>
            <li><a href="Patient-Home.jsp">HOME</a></li>
            <li><a href="Patient-Profile.jsp">PROFILE</a></li>
            <li><a href="F&Q.jsp">CONTACT US</a></li>
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
<main>
    <section class="mb">
        <div class="mb1">
            <section>
                <h2>Filter By Doctor</h2>
                <a href="Patient-Appointment_Doc.jsp">
                    <button>Filter by Doctor</button>
                </a>
            </section>

            <section>
                <h2> Filter By Date and Time</h2>
                <a href="Patient-Appointment_T-D.jsp">
                    <button>Filter by Date and Time</button>
                </a>
            </section>
        </div>

        <div class="mb1">

            <section>
                <h2>Schedule Appointment</h2>
                <a href="Patient-Appointment_T-D-Doc.jsp">
                    <button>Schedule Appointment</button>
                </a>
            </section>

            <section>
                <h2>View All Appointments</h2>
                <form action="SearchAppointmentPatientServlet" method="post">
                    <button type="submit" value="View All Appointments" class="search-button">View All Appointments</button>
                </form>
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
        <p>&copy;CTC-Chiropractic 2025. All rights reserved.</p>
    </section>
</footer>
</body>

</html>