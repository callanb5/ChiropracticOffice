<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.Schedule" %>
<%@ page import="org.example.chiropractorproject.BusinessObjects.DoctorList" %>
<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    Doctor-Home_page.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CT-Chiropractic Admin-DocSchedule</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>
<%
    Doctors d1;
    d1 = (Doctors)session.getAttribute("d1");
    String docName = d1.getfirstname() + " " + d1.getlastname();

    Schedule s1 = new Schedule();
    Doctors d2 = new Doctors();
    s1.selectDB("Monday");
    String doc1 = s1.getdocid();
    d2.selectDB(doc1);
    doc1 = d2.getlastname();

    s1.selectDB("Tuesday");
    String doc2 = s1.getdocid();
    d2.selectDB(doc2);
    doc2 = d2.getlastname();

    s1.selectDB("Wednesday");
    String doc3 = s1.getdocid();
    d2.selectDB(doc3);
    doc3 = d2.getlastname();

    s1.selectDB("Thursday");
    String doc4 = s1.getdocid();
    d2.selectDB(doc4);
    doc4 = d2.getlastname();

    s1.selectDB("Friday");
    String doc5 = s1.getdocid();
    d2.selectDB(doc5);
    doc5 = d2.getlastname();

    s1.selectDB("Saturday");
    String doc6 = s1.getdocid();
    d2.selectDB(doc6);
    doc6 = d2.getlastname();

    s1.selectDB("Sunday");
    String doc7 = s1.getdocid();
    d2.selectDB(doc7);
    doc7 = d2.getlastname();


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
            <li><a href="Admin-Home.jsp">DASHBOARD</a></li>
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

    <form action="AdminCreateScheduleServlet">

        <table class="New-Acc">
                <h1 style="text-align: center;">Set SChedule<h1>
            <tr style="text-align: center;">
                <td class="Sub-Acc"><label for="Monday"><p>Monday</p></label></td>
                <td class="Sub-Acc"><label for="Tuesday"><p>Tuesday</p></label></td>
                <td class="Sub-Acc"><label for="Wednesday"><p>Wednesday</p></label></td>
                <td class="Sub-Acc"><label for="Thursday"><p>Thursday</p></label></td>
                <td class="Sub-Acc"><label for="Friday"><p>Friday</p></label></td>
                <td class="Sub-Acc"><label for="Saturday"><p>Saturday</p></label></td>
                <td class="Sub-Acc"><label for="Sunday"><p>Sunday</p></label></td>
            </tr>

            <%
                DoctorList doclist = new DoctorList();
                doclist.selectDB();
            %>
            <tr style="text-align: center;">
                <td>
                    <select name="Monday" id="Monday">
                        <%
                          for (int i = 0; i < doclist.count; i++) {
                               Doctors doc = doclist.docArrayList.get(i);
                        %>
                       <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                       <%}%>
                    </select>
                </td>

                <td>
                    <select name="Tuesday" id="Tuesday">
                        <%
                            for (int i = 0; i < doclist.count; i++) {
                                Doctors doc = doclist.docArrayList.get(i);
                        %>
                        <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                        <%}%>
                    </select>
                </td>

                <td>
                    <select name="Wednesday" id="Wednesday">
                        <%
                            for (int i = 0; i < doclist.count; i++) {
                                Doctors doc = doclist.docArrayList.get(i);
                        %>
                        <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                        <%}%>
                    </select>
                </td>

                <td>
                    <select name="Thursday" id="Thursday">
                        <%
                            for (int i = 0; i < doclist.count; i++) {
                                Doctors doc = doclist.docArrayList.get(i);
                        %>
                        <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                        <%}%>
                    </select>
                </td>

                <td>
                    <select name="Friday" id="Friday">
                        <%
                            for (int i = 0; i < doclist.count; i++) {
                                Doctors doc = doclist.docArrayList.get(i);
                        %>
                        <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                        <%}%>
                    </select>
                </td>

                <td>
                    <select name="Saturday" id="Saturday">
                        <%
                            for (int i = 0; i < doclist.count; i++) {
                                Doctors doc = doclist.docArrayList.get(i);
                        %>
                        <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                        <%}%>
                    </select>
                </td>

                <td>
                    <select name="Sunday" id="Sunday">
                        <%
                            for (int i = 0; i < doclist.count; i++) {
                                Doctors doc = doclist.docArrayList.get(i);
                        %>
                        <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                        <%}%>
                    </select>
                </td>
            </tr>

            <tr>
                <td><input type="submit" value="Change" class="search-button"></td>
            </tr>
        </table>

        <table class="New-Acc">
                        <h1 style="text-align: center;">Review SChedule<h1>
            <tr style="text-align: center;">
                <td class="Sub-Acc"><label for="Monday"><p>Monday</p></label></td>
                <td class="Sub-Acc"><label for="Tuesday"><p>Tuesday</p></label></td>
                <td class="Sub-Acc"><label for="Wednesday"><p>Wednesday</p></label></td>
                <td class="Sub-Acc"><label for="Thursday"><p>Thursday</p></label></td>
                <td class="Sub-Acc"><label for="Friday"><p>Friday</p></label></td>
                <td class="Sub-Acc"><label for="Saturday"><p>Saturday</p></label></td>
                <td class="Sub-Acc"><label for="Sunday"><p>Sunday</p></label></td>
            </tr>

            <tr style="text-align: center;">
                <td><label id="doc1"><p><%=doc1%></p></label></td>
                <td><label id="doc2"><p><%=doc2%></p></label></td>
                <td><label id="doc3"><p><%=doc3%></p></label></td>
                <td><label id="doc4"><p><%=doc4%></p></label></td>
                <td><label id="doc5"><p><%=doc5%></p></label></td>
                <td><label id="doc6"><p><%=doc6%></p></label></td>
                <td><label id="doc7"><p><%=doc7%></p></label></td>
            </tr>
        </table>
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
