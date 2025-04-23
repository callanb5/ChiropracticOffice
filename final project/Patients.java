package org.example.chiropractorproject.BusinessObjects;

/*
 * ASP (Chiropractor)
 * Last Editor: Victorino Martinez
 * Date: 1/27/2025
 */

import java.sql.*;


public class Patients {

    private String patid;
    private String pwd;
    private String firstname;
    private String lastname;
    private String email;
  //  private String highid;
    public ApptList a1 = new ApptList();

    public Patients() {
        patid = "";
        pwd = "";
        firstname = "";
        lastname = "";
        email = "";
      //  highid = "";
    }

    public Patients(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL, String HIGHID) {
        patid = PATID;
        pwd = PWD;
        firstname = FIRSTNAME;
        lastname = LASTNAME;
        email = EMAIL;
      //  highid = HIGHID;

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

    public void selectDB(String PATID) {
        patid = PATID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");

            //SqL statement
            String sql = "SELECT * FROM Patients WHERE PatID = '" + patid + "'";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                patid = rs.getString(1);
                pwd = rs.getString(2);
                firstname = rs.getString(3);
                lastname = rs.getString(4);
                email = rs.getString(5);
            }

            //Close Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }//end try/catch

        a1.selectDBPatId(patid);


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

    }//end selectDB()

    public void insertDB(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
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
            System.out.println("Patient " + PATID + " has been added to the database");


            //Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }//end catch

    }//end insertDB()

    public boolean updateDB(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        patid = PATID;
        pwd = PWD;
        firstname = FIRSTNAME;
        lastname = LASTNAME;
        email = EMAIL;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            //SQL statement
            String sql = ("UPDATE Patients SET PatID = '" + this.patid + "',Pwd = '" + this.pwd + "', FirstName = '" + this.firstname + "', LastName = '" + this.lastname + "', Email = '" + this.email + "' WHERE PatID = '" + this.patid + "'");
            System.out.println(sql);

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);

            //Execute Statement
            int n = stmt.executeUpdate();
            if (n==1) {
                System.out.println("Patient " + PATID + " information has been changed");
            } else {
                System.out.println("Patient " + PATID + " information change failed");
            }

            //Close Connection
            con.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }//end try/catch

    }//end updateDB()

    /*
    public void getAppointments(String PATID) {
        patid = PATID;


        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            String sql = ("SELECT ApptID from Appointments WHERE PatID = '" + patid + "'");
            Statement stmt = con.createStatement();

            //Create Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            String an;
            ApptList a1 = new ApptList();


            rs.next();
            an = rs.getString(1);
            a1.selectDBPatId(an);



            //Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }//end catch
    }
    */
    public void display(){

        System.out.println("====================================");
        System.out.println("Patient ID: "+ patid);
        System.out.println("Patient Password: "+ pwd);
        System.out.println("Patient First Name: "+ firstname);
        System.out.println("Patient Last Name: " + lastname);
        System.out.println("Customer Email: "+ email);
        a1.displayList();
        System.out.println("====================================");
    }

    public static void main(String[] Args) {

        //SelectDB() works correctly
        Patients p1 = new Patients();
        p1.selecthighIDDB();


        /*
        //InsertDB() works correctly
        Patients p2 = new Patients();
        p1.insertDB("0006","6666","Anna","Emilie","AnnEmi@gmail.com");
        p1.selectDB("0006");
        p1.display();
        */

        /*
        //InsertDB() works correctly
        Patients p3 = new Patients();
        p3.selectDB("0003");

        p3.setpwd("3333");
        p3.setfirstname("Margret");
        p3.setlastname("Smithsfield");
        p3.setemail("MS@gmail.com");
        p3.updateDB("0003");

        p3.selectDB("0003");
        p3.display();
        */


    }

}
