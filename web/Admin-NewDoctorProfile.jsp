<%@ page import="org.example.chiropractorproject.BusinessObjects.Doctors" %>
<%-- ==================================================
    Lucas Lawless
    CT-Chiroprtic
    index.jsp
 ======================================================  --%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CT-Chiropractic New_P-Account-Page</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Helvetica |Iceberg |Tangerine">
</head>

<body>
<nav class="navbar">
    <div class="logo">
        <a href="index.jsp">
            <img src="img/CTC_Logo.png" alt="logo">
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

    <%

        String highid = null;
        int tempid;

        Doctors d1;

        d1 = new Doctors();

        d1.selecthighIDDB();

        int id = Integer.parseInt(d1.getdocid());
        id++;
        System.out.println(id);

        //if id pulled is single digit, add (3) 000's to number making 0001...0009
        if (id < 10) {
            highid = "00" + id;

        }
        //if id pulled is double digits, add (2) 00's to number making 0010...0099
        else if (id >= 10) {
            highid = "0" + id;
        }
        //if id pulled is triple digits, add (1) 0's to number making 0100...0999
        else if (id >= 100) {
            highid = String.valueOf(id);
        }

    %>
    <form class="New-Acc" action="CreateDoctorAccountServlet">
        <h1>Doctor Account</h1>
        <table border="3">
            <tr>
                <td>ID:</td>
                <td><input type="text" name="idtb" value="<%=highid%>" readonly/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="pwtb" value="" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="fntb" value="" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lntb" value="" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="emtb" value="" /></td>
            </tr>
            <tr>
                <td>Admin Privileges:</td>
                <td><input type="checkbox" name="adtb" size="small" value="true"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="update"  value="Create Account" /></td>
                <td><input type="reset" value="Clear" /></td>
            </tr>

        </table>
    </form>

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
