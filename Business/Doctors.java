package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Victorino Martinez
 * Date: 1/27/2025
 */

import java.sql.*;
public class Doctors {

    private String docid;
    private String pwd;
    private String firstname;
    private String lastname;
    private String email;
    private Boolean admin;


    public Doctors() {
        docid = "";
        pwd = "";
        firstname = "";
        lastname = "";
        email = "";
        admin = false;
    }


    public Doctors(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL, Boolean ADMIN) {
        docid = DOCID;
        pwd = PWD;
        firstname = FIRSTNAME;
        lastname = LASTNAME;
        email = EMAIL;
        admin = ADMIN;

    }


    //Getter methods
    public String getdocid() { return docid;}                                  //DocID
    public String getpwd() { return pwd;}                                      //Pwd
    public String getfirstname() { return firstname;}                       //FirstName
    public String getlastname() { return lastname;}                         //LastName
    public String getemail() { return email;}                               //Email
    public Boolean getadmin() { return admin;}                              //Admin


    //Setter methods
    public void setdocid(String DOCID) {docid = DOCID;}                        //DocID
    public void setpwd(String PWD) {pwd = PWD;}                                //Pwd
    public void setfirstname(String FIRSTNAME) {firstname = FIRSTNAME;}     //FirstName
    public void setlastname(String LASTNAME) {lastname = LASTNAME;}         //LastName
    public void setemail(String EMAIL) {email = EMAIL;}                     //Email
    public void setadmin(Boolean ADMIN) {admin = ADMIN;}                    //Admin

    /**
     * Selects from the database by doctor id and stores doctor information in variables.
     * @param DOCID doctor id
     */
    public void selectDB(String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            //SqL statement
            String sql = "SELECT * FROM Doctors WHERE DocID = '" + docid + "'";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            rs.next();
                docid = rs.getString(1);
                pwd = rs.getString(2);
                firstname = rs.getString(3);
                lastname = rs.getString(4);
                email = rs.getString(5);
                admin = rs.getBoolean(6);


            //Close Connection
            con.close();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch

    }//end selectDB()

    /**
     * Updates database with provided doctor information.
     * @param DOCID doctor id
     * @param PWD doctor password
     * @param FIRSTNAME doctor first name
     * @param LASTNAME doctor last name
     * @param EMAIL doctor email
     */
    public void updateDB(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            //SQL statement
            String sql = ("UPDATE Doctors SET Pwd = ?, FirstName = ?, LastName = ?, Email = ? WHERE DocID = ?");

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

    /**
     * Inserts into database with provided doctor information.
     * @param DOCID doctor id
     * @param PWD doctor password
     * @param FIRSTNAME doctor first name
     * @param LASTNAME doctor last name
     * @param EMAIL doctor email
     * @param ADMIN admin boolean
     */
    public void insertDB(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL, Boolean ADMIN) {
        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            //SQL statement
            String sql = ("INSERT INTO Doctors(DocID, Pwd, FirstName, Lastname, Email, Admin) Values(?,?,?,?,?,?)");
            System.out.println(sql);

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            //Creating new doctor in Doctors Database
            stmt.setString(1, DOCID);
            stmt.setString(2, PWD);
            stmt.setString(3, FIRSTNAME);
            stmt.setString(4, LASTNAME);
            stmt.setString(5, EMAIL);
            stmt.setBoolean(6, ADMIN);


            //Execute Statement
            stmt.executeUpdate();

            //Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch

    }//end insertDB()

    /**
     * Deletes from database by provided doctor id.
     * @param DOCID doctor id
     */
    public void deleteDB(String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            //SQL statement
            String sql = ("DELETE * FROM Doctors WHERE DocID = '" + docid + "'");

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            //Execute Statement
            stmt.executeUpdate();
            System.out.println("Doctor" + docid + "has been removed");

            //Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch

    }//end deleteDB()

}
