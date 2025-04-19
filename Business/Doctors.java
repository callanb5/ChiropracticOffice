package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 4/16/2025
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
     * Selects appointments from the database by doctor id and stores in variables.
     *
     * @param DOCID doctor id
     */
    public void selectDB(String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

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
     * Selects from the database by doctor last name and stores information in variables.
     * @param docln doctor id
     */
    public void selectDBDocLN(String docln) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Doctors WHERE LastName='" + docln + "'";

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            this.docid = rs.getString(1);
            this.pwd = rs.getString(2);
            this.firstname = rs.getString(3);
            this.lastname = rs.getString(4);
            this.email = rs.getString(5);
            this.admin = rs.getBoolean(6);

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    /**
     * Updates database with values provided.
     *
     * @param DOCID doctor id
     * @param PWD password
     * @param FIRSTNAME first name
     * @param LASTNAME last name
     * @param EMAIL email
     */
    public void updateDB(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

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
     * Inserts provided values into database.
     *
     * @param DOCID doctor id
     * @param PWD password
     * @param FIRSTNAME first name
     * @param LASTNAME last name
     * @param EMAIL email
     * @param ADMIN administrator privileges
     */
    public void insertDB(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL, Boolean ADMIN) {




        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

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
     * Deletes from the database by provided id.
     *
     * @param DOCID doctor id
     */
    public void deleteDB(String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

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
