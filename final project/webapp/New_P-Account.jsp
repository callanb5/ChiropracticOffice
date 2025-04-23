<%@ page import="org.example.chiropractorproject.BusinessObjects.Patients" %>
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
            <img src="CTC_Logo.png" alt="logo">
        </a>
    </div>

    <div class="mNav">
        <ul>
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="F&Q.jsp">CONTACT US</a></li>
            <li><a href="F&Q.jsp">HELP</a></li>
        </ul>
    </div>



</nav>
<main>

    <%

        String highid = null;
        int tempid;

           Patients p1;

           p1 = new Patients();

           p1.selecthighIDDB();
           
           int id = Integer.parseInt(p1.getpatid());
           id++;
           System.out.println(id);

        //if id pulled is single digit, add (3) 000's to number making 0001...0009
        if (id < 10) {
            highid = "000" + id;

        }
        //if id pulled is double digits, add (2) 00's to number making 0010...0099
        else if (id >= 10) {
            highid = "00" + id;
        }
        //if id pulled is triple digits, add (1) 0's to number making 0100...0999
        else if (id >= 100) {
            highid = "0" + id;
        }
        //if id pulled is 4 digits, add no 0's to number making 1000...9999
        else if (id >= 1000) {
            highid = String.valueOf(id);
        }

       %>
    <form class="New-Acc" action="CreatePatientAccountServlet">
        <h1>Patient Account</h1>
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
                <td><input type="submit" name="update"  value="Create Account" /></td>
                <td><input type="reset" value="Clear" /></td>
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