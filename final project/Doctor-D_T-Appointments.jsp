<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %><%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Doctor-D_T-Appointments</title>
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

    <div class="mNav">
        <ul>
            <li><a href="Doctor-Home.jsp">HOME</a></li>
            <li><a href="F&Q.jsp">CONTACT US</a></li>
        </ul>
    </div>

    <div class="sNav">
        <ul>
            <h3><%=docName%></h3>
            <li><a href="Doctor-Login.jsp" class="logBtn">Sign Out</a></li>
        </ul>
    </div>

</nav>
<main>


    <form action="SearchAppointmentDoctorDateServlet" method="post">
        <form action="SearchAppointmentDoctorDateServlet" method="post">

            <table class="New-Acc">
                <tr>
                    <td><label for="year">Year:</label>
                        <select name="year" id="year">
                            <option value="2026">2027</option>
                            <option value="2026">2026</option>
                            <option value="2025">2025</option>
                            <option value="2024">2024</option>
                            <option value="2023">2023</option>
                        </select></td></tr>
                <tr>
                    <td><label for="month">Month:</label>
                        <select name="month" id="month">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select></td></tr>
                <tr>
                    <td><label for="day">Day:</label>
                        <select name="day" id="day">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select></td></tr>
                <tr>
                    <td>
                        <input type="submit" value="Search" class="search-button">
                    </td></tr>
            </table>
        </form>

        <button onclick="history.back()">Back</button>
    </form>
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