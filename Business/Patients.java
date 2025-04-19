package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 04/19/2025
 */
import java.sql.*;
public class Patients {

    private String patid;
    private String pwd;
    private String firstname;
    private String lastname;
    private String email;
    public ApptList a1 = new ApptList();

    public Patients() {
        patid = "";
        pwd = "";
        firstname = "";
        lastname = "";
        email = "";
    }

    public Patients(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        patid = PATID;
        pwd = PWD;
        firstname = FIRSTNAME;
        lastname = LASTNAME;
        email = EMAIL;

    }



    //Getter methods
    public String getpatid() { return patid;}                                  //PatID
    public String getpwd() { return pwd;}                                      //Pwd
    public String getfirstname() { return firstname;}                       //FirstName
    public String getlastname() { return lastname;}                         //LastName
    public String getemail() { return email;}                               //Email



    //Setter methods
    public void setpatid(String PATID) {patid = PATID;}                        //PatID
    public void setpwd(String PWD) {pwd = PWD;}                                //Pwd
    public void setfirstname(String FIRSTNAME) {firstname = FIRSTNAME;}     //FirstName
    public void setlastname(String LASTNAME) {lastname = LASTNAME;}         //LastName
    public void setemail(String EMAIL) {email = EMAIL;}                     //Email
    /**
     * Selects appointments from the database by patient id and stores in variables.
     *
     * @param PATID patient id
     */
    public void selectDB(String PATID) {
        patid = PATID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            //SqL statement
            String sql = "SELECT * FROM Patients WHERE PatID = '" + patid + "'";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            rs.next();
            patid = rs.getString(1);
            pwd = rs.getString(2);
            firstname = rs.getString(3);
            lastname = rs.getString(4);
            email = rs.getString(5);


            //Close Connection
            con.close();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch

    }//end selectDB()

    /**
     * Selects patient with the highest patient id from the database
     */
    public void selecthighIDDB() {

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");
            System.out.println("Connection created");

            //SqL statement
            String sql = "SELECT MAX(PatID) FROM Patients ";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                patid = rs.getString(1);
            }

            //Close Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }//end try/catch

        a1.selectDBPatId(patid);


    }//end selectDB()
    /**
     * Inserts provided values into database.
     *
     * @param PATID patient id
     * @param PWD password
     * @param FIRSTNAME first name
     * @param LASTNAME last name
     * @param EMAIL email
     */
     public void insertDB(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");
            System.out.println("Connection created");


            String sql = ("INSERT INTO Patients(PatID,Pwd,FirstName,LastName,Email) Values(?,?,?,?,?)");
            System.out.println(sql);

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, PATID);
            stmt.setString(2, PWD);
            stmt.setString(3, FIRSTNAME);
            stmt.setString(4, LASTNAME);
            stmt.setString(5, EMAIL);

            //Execute Statement
            stmt.executeUpdate();
            System.out.println("Patient" + PATID + "has been added to the database");


            //Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }//end catch

    }//end insertDB()
     
    /**
     * Updates database with values provided.
     *
     * @param PATID patient id
     * @param PWD password
     * @param FIRSTNAME first name
     * @param LASTNAME last name
     * @param EMAIL email
     */
    public void updateDB(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        patid = PATID;
        pwd = PWD;
        firstname = FIRSTNAME;
        lastname = LASTNAME;
        email = EMAIL;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            //SQL statement
            String sql = ("UPDATE Patients SET Pwd = ?, FirstName = ?, LastName = ?, Email = ? WHERE PatID = ?");

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(2, PWD);
            stmt.setString(3, FIRSTNAME);
            stmt.setString(4, LASTNAME);
            stmt.setString(5, EMAIL);


            //Execute Statement
            stmt.executeUpdate();

            //Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch

    }//end updateDB()

    public void display() {
        System.out.println("PatID: " + getpatid());
        System.out.println("Password: " + getpwd());
        System.out.println("First Name: " + getfirstname());
        System.out.println("Last Name: " + getlastname());
        System.out.println("Email: " + getemail());
    }
    
}
