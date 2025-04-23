<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.ApptList" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.Appointments" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.Patients" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CTC Chiropractic - Search Results</title>
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
            <li><a href="Patient-Home.jsp">DASHBOARD</a></li>
            <li><a href="Patient-APPMain.jsp">APPOINTMENTS</a></li>
            <li><a href="Patient-profile.jsp">PROFILE</a></li>
        </ul>
    </div>

    <div class="sNav">
        <ul>
            <li class="Sign">Signed in as <%=docName%></li>
            <li><a href="Patient-Login.jsp" class="logBtn">Sign Out</a></li>
            <!-- <li><a href="" class="signBtn">SIGN UP</a></li> -->
        </ul>
    </div>

</nav>
<main>
    <h1 class="Welcome">Appointment Details</h1>

    <%

        ApptList apptlist = (ApptList) session.getAttribute("apptlist");
        for (int i = 0; i < apptlist.count; i++) {
            Appointments appt = apptlist.appArrayList.get(i);
            Patients pat = new Patients();
            pat.selectDB(appt.getPatID());
            Doctors doc = new Doctors();
            doc.selectDB(appt.getDocID());

    %>
    <div class = "New-Acc">
        <form class="New-Acc">
            <table>
                <tr> <td>   <h4>Appointment ID: <%=appt.getApptID()%></h4>                         </td> </tr>
                <tr> <td>   <h4>Appointment Date/Time: <%=appt.getApptDateTime()%></h4>            </td> </tr>
                <tr> <td>   <h4>Patient: <%=pat.getfirstname() + " " + pat.getlastname()%></h4>    </td> </tr>
                <tr> <td>   <h4>Doctor: <%=doc.getfirstname() + " " + doc.getlastname()%></h4>     </td> </tr>
                <tr> <td>   <h4>Notes: <%=appt.getNotes()%></h4>                                   </td> </tr>
            </table>
        </form>

        <%}%>
        <a href="Doctor-Home.jsp" class="back">Back</a>


    </div>

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