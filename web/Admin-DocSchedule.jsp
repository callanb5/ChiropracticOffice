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
    <title>CT-Chiroprtic Pationt-Login-Page</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>
<%
    Doctors d1;
    d1 = (Doctors)session.getAttribute("d1");
    String docName = d1.getfirstname() + " " + d1.getlastname();

    Schedule s1 = new Schedule();
    s1.selectDB("Monday");
    String doc1 = s1.getdocid();
    s1.selectDB("Tuesday");
    String doc2 = s1.getdocid();
    s1.selectDB("Wednesday");
    String doc3 = s1.getdocid();
    s1.selectDB("Thursday");
    String doc4 = s1.getdocid();
    s1.selectDB("Friday");
    String doc5 = s1.getdocid();
    s1.selectDB("Saturday");
    String doc6 = s1.getdocid();
    s1.selectDB("Sunday");
    String doc7 = s1.getdocid();

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

            <tr><td>
                <label for="Monday">Monday  </label>
                <label for="Tuesday">Tuesday   </label>
                <label for="Wednesday">Wednesday</label>
                <label for="Thursday">Thursday </label>
                <label for="Friday">Friday   </label>
                <label for="Saturday">Saturday  </label>
                <label for="Sunday">Sunday</label></td></tr>

            <%
                DoctorList doclist = new DoctorList();
                doclist.selectDB();
            %>
            <tr><td>
                <select name="Monday" id="Monday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select>

                <select name="Tuesday" id="Tuesday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select>

                <select name="Wednesday" id="Wednesday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select>

                <select name="Thursday" id="Thursday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select>

                <select name="Friday" id="Friday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select>

                <select name="Saturday" id="Saturday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select>

                <select name="Sunday" id="Sunday">
                    <%
                        for (int i = 0; i < doclist.count; i++) {
                            Doctors doc = doclist.docArrayList.get(i);
                    %>
                    <option value="<%=doc.getdocid()%>"><%=doc.getlastname()%></option>
                    <%}%>
                </select></td></tr>

            <tr>
                <td><input type="submit" value="Change" class="search-button"></td>
            </tr>
        </table>

        <table class="New-Acc">
            <tr><td>
                <label for="Monday">Monday  </label>
                <label for="Tuesday">Tuesday   </label>
                <label for="Wednesday">Wednesday</label>
                <label for="Thursday">Thursday </label>
                <label for="Friday">Friday   </label>
                <label for="Saturday">Saturday  </label>
                <label for="Sunday">Sunday</label></td></tr>

            <tr><td>
                <label name="Monday" id="doc1">
                    <option><%=doc1%></option>
                </label>
                <label name="Tuesday" id="doc2">
                    <option><%=doc2%></option>
                </label>
                <label name="Wednesday" id="doc3">
                    <option><%=doc3%></option>
                </label>
                <label name="Thursday" id="doc4">
                    <option><%=doc4%></option>
                </label>
                <label name="Friday" id="doc5">
                    <option><%=doc5%></option>
                </label>
                <label name="Saturday" id="doc6">
                    <option><%=doc6%></option>
                </label>
                <label name="Sunday" id="doc7">
                    <option><%=doc7%></option>
                </label>
        </table>



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
