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
    <title>CT-Chiropractic Doctor-Home-Page</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>
<%
    Doctors d1;

    d1 = (Doctors)session.getAttribute("d1");

    String docName = d1.getfirstname() + " " + d1.getlastname() + "\n" + "(Admin)";


%>
<body>
<nav class="navbar">
    <div class="logo">
        <a href="">
            <img src="img/CTC_Logo.png" alt="logo">
        </a>
    </div>

    <div class="mNav">
        <ul>
            <li><a href="Admin-Home.jsp">HOME</a></li>
            <li><a href="">APPOINTMENTS</a></li>
            <li><a href="">CONTACT US</a></li>
            <li><a href="">HELP</a></li>
        </ul>
    </div>

    <div class="sNav">
        <ul>
            <h3><%=docName%></h3>
            <li><a href="landingPage.jsp" class="logBtn">Sign Out</a></li>
            <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
        </ul>
    </div>

</nav>
<main>
    <div class="mb">
        <div class="mb1">
            <section>
                <h2>Review Profile and Login Information</h2>
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

        <div class="mb2">
            <section>
                <h2>View Appointments for the day</h2>
                <a href="">
                    <button>View Appointments</button>
                </a>
            </section>

            <section>
                <h2>View Patient History</h2>
                <a href="Doctor-P-L-Appointments.jsp">
                    <button>View Patient History</button>
                </a>
            </section>
        </div>

        <div class="mb2">
            <section>
                <h2>Create Doctor Account</h2>
                <a href="New_D-Account.jsp">
                    <button>Create Account</button>
                </a>
            </section>

            <section>
                <h2>View/Change Weekly Schedule</h2>
                <a href="">
                    <button>View Appointments</button>
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
                    <li><a href="">Our </a></li>
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

