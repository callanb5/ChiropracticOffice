package org.example;
/**
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

    public void selectDB(String PATID) {
        patid = PATID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

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

    public void updateDB(String PATID, String PWD, String FIRSTNAME, String LASTNAME, String EMAIL) {
        patid = PATID;

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

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

}
