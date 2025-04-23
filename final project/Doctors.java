package org.example.chiropractorproject.BusinessObjects;

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
    public PatientList pList = new PatientList();


    public Doctors() {
        docid = "";
        pwd = "";
        firstname = "";
        lastname = "";
        email = "";
        admin = null;
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

    public void selectDB(String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");


            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");


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
                System.out.println(admin);


            //Close Connection
            con.close();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch

    }//end selectDB()

    public void selecthighIDDB() {

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");

            //SqL statement
            String sql = "SELECT MAX(DocID) FROM Doctors ";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                docid = rs.getString(1);
            }

            //Close Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }//end try/catch

    }//end selecthighIDDB()

    public void selectDBDocLN(String docln) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Doctors WHERE LastName='" + docln + "'";

            ResultSet rs;
            rs = statement.executeQuery(sql);

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

    public boolean updateDB(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        docid = DOCID;
        pwd = PWD;
        firstname = FIRSTNAME;
        lastname = LASTNAME;
        email = EMAIL;


        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");


            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");


            //SQL statement
            String sql = ("UPDATE Doctors SET DocID = '" + this.docid + "',Pwd = '" + this.pwd + "', FirstName = '" + this.firstname + "', LastName = '" + this.lastname + "', Email = '" + this.email + "' WHERE DocID = '" + this.docid + "'");

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            //Execute Statement
            int n = stmt.executeUpdate();
            if (n==1) {
                System.out.println("Doctor " + DOCID + " information has been changed");
            } else {
                System.out.println("Doctor " + DOCID + " information change failed");
            }

            //Close Connection
            con.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }//end try/catch

    }//end updateDB()

    public void insertDB(String DOCID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL, Boolean ADMIN) {

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");


            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");


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
            e.printStackTrace();
        }//end try/catch

    }//end insertDB()

    public void deleteDB(String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");


            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");


            //SQL statement
            String sql = ("DELETE * FROM Doctors WHERE DocID = '" + docid + "'");

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            //Execute Statement
            stmt.executeUpdate();
            System.out.println("Doctor " + docid + " has been removed");

            //Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }//end try/catch

    }//end deleteDB()

    public void getPatients (String DOCID) {
        docid = DOCID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            String sql = ("SELECT PatID from Appointments WHERE DocID = '" + docid + "'");
            Statement stmt = con.createStatement();

            //Create Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            String an;
            Patients p1;

            while (rs.next()) {
                an = rs.getString(3);
                p1 = new Patients();
                p1.selectDB(an);
                pList.addPatient(p1);

            }

            //Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }//end catch
    }

    public void display(){

        System.out.println("====================================");
        System.out.println("Doctor ID: "+ docid);
        System.out.println("Doctor Password: "+ pwd);
        System.out.println("Doctor First Name: "+ firstname);
        System.out.println("Doctor Last Name: " + lastname);
        System.out.println("Doctor Email: "+ email);
        System.out.println("====================================");
    }

    public static void main(String[] Args) {
        /*
        //SelectDB() works correctly
        Doctors d1 = new Doctors();
        d1.selectDB("001");
        d1.display();
        */

        /*
        //InsertDB() works correctly
        Doctors d2 = new Doctors();
        d2.insertDB("007","6666","Gerard","House","GerHouse@gmail.com", false);
        d2.selectDB("007");
        d2.display();
        */

        /*
        //UpdateDB() works correctly
        Doctors d3 = new Doctors();
        d3.selectDB("007");
        d3.display();

        d3.setpwd("7777");
        d3.setfirstname("Gerry");
        d3.setlastname("Houfield");
        d3.updateDB("007");

        d3.selectDB("007");
        d3.display();
        */

        /*
        //DeleteDB() works correctly
        Doctors d4 = new Doctors();
        d4.deleteDB("007");
        */

    }

}
