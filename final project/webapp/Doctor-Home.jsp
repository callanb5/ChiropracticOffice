<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %>
<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CT-Chiropractic Doctor-Home</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>
<%
    Doctors d1;
    String docName;

    d1 = (Doctors)session.getAttribute("d1");

    if (d1.getadmin().equals(true)) {
        docName = d1.getfirstname() + " " + d1.getlastname() + "\n" + "(Admin)";
    } else {
        docName = d1.getfirstname() + " " + d1.getlastname();

    }

%>
<body>
<nav class="navbar">
    <div class="logo">
        <a href="index.jsp">
            <img src="CTC_Logo.png" alt="logo">
        </a>
    </div>

    <div class="sNav">
        <ul>
            <h3><%=docName%></h3>
            <li><a href="Doctor-Login.jsp" class="logBtn">Sign Out</a></li>
            <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
        </ul>
    </div>

</nav>
<main>
    <div class="clean">
        <h1 class="Welcome">Welcome, <%=docName%></h1>
    </div><br>
    <section class="mb">
        <div class="mb1">
            <section>
                <h2>Account Information</h2>
                <a href="Doctor-Profile.jsp">
                    <button>Account Info</button>
                </a>
            </section>

            <section>
                <h2>View your patients</h2>
                <a href="Doctor-P-List.jsp">
                    <button>View Patients</button>
                </a>
            </section>
        </div>

        <div class="mb1">

            <section>
                <h2>View Appointments for the day</h2>
                <a href="Doctor-D_T-Appointments.jsp">
                    <button>View Appointments</button>
                </a>
            </section>

            <section>
                <h2>Patient History</h2>
                <a href="Doctor-P_L-Appointments.jsp">
                    <button>View Patient History</button>
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
        <p>&copy;CT-Chiropractic 2025. All rights reserved.</p>
    </section>
</footer>
</body>

</html>