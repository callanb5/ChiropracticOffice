package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Victorino Martinez
 * Date: 1/27/2025
 */

public class Doctors {

    private int DocID;
    private int Pwd;
    private String FirstName;
    private String LastName;
    private String Email;
    private Boolean Admin;


    public Doctors() {
        DocID = 0;
        Pwd = 0;
        FirstName = "";
        LastName = "";
        Email = "";
        Admin = false;
    }


    public Doctors(int docid, int pwd, String firstname, String lastname, String email, Boolean admin) {
        DocID = docid;
        Pwd = pwd;
        FirstName = firstname;
        LastName = lastname;
        Email = email;
        Admin = admin;

    }


    //Getter methods
    public int getDocID() { return DocID;}                                  //DocID
    public int getPwd() { return Pwd;}                                      //Pwd
    public String getFirstName() { return FirstName;}                       //FirstName
    public String getLastName() { return LastName;}                         //LastName
    public String getEmail() { return Email;}                               //Email
    public Boolean getAdmin() { return Admin;}                              //Admin


    //Setter methods
    public void setDocID(int docid) {DocID = docid;}                        //DocID
    public void setPwd(int pwd) {Pwd = pwd;}                                //Pwd
    public void setFirstName(String firstname) {FirstName = firstname;}     //FirstName
    public void setLastName(String lastname) {LastName = lastname;}         //LastName
    public void setEmail(String email) {Email = email;}                     //Email
    public void setAdmin(Boolean admin) {Admin = admin;}                    //Admin

    public void selectDB(Int docid) {
        DocID = docid;

        try {
            //Load Driver

            //Creating Connection

            //SqL statement
            String sql = "SELECT * FROM Doctors WHERE DocID = '" + docid + "'";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                docid = rs.getInt(1);
                pwd = rs.getInt(2);
                firstname = rs.getString(3);
                lastname = rs.getString(4);
                email = rs,getString(5);
                admin = rs.getBoolean(6);
            }

            //Close Connection
            con.close();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch
                
    }//end selectDB()

    public void updateDB(Int docid) {
        DocID = docid;

        try {
            //Load Driver

            //Creating Connection

            //Create Statement
            PreparedStatement stmt = con.prepareStatement(sql);
            
            //SQL statement
            String sql = ("UPDATE Doctors SET Pwd = ?, FirstName = ?, LastName = ?, Email = ? WHERE DocID = ?")

            stmt.setInt(2, );
            stmt.setString(3, );
            stmt.setString(4, );
            stmt.setString(5, );


            //Execute Statement
            stmt.executeUpdate();

            //Close Connection
            con.close();
            
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }//end try/catch
        
    }//end updateDB()

}
