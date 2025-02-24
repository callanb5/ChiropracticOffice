package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Victorino Martinez
 * Date: 1/27/2025
 */

public class Patients {

    private int PatID;
    private int Pwd;
    private String FirstName;
    private String LastName;
    private String Email;

    public Patients() {
        PatID = 0;
        Pwd = 0;
        FirstName = "";
        LastName = "";
        Email = "";
    }

    public Patients(int patid, int pwd, String firstname, String lastname, String email) {
        PatID = patid;
        Pwd = pwd;
        FirstName = firstname;
        LastName = lastname;
        Email = email;

    }



    //Getter methods
    public int getPatID() { return PatID;}                                  //PatID
    public int getPwd() { return Pwd;}                                      //Pwd
    public String getFirstName() { return FirstName;}                       //FirstName
    public String getLastName() { return LastName;}                         //LastName
    public String getEmail() { return Email;}                               //Email



    //Setter methods
    public void setPatID(int patid) {PatID = patid;}                        //PatID
    public void setPwd(int pwd) {Pwd = pwd;}                                //Pwd
    public void setFirstName(String firstname) {FirstName = firstname;}     //FirstName
    public void setLastName(String lastname) {LastName = lastname;}         //LastName
    public void setEmail(String email) {Email = email;}                     //Email

    //Database methods

    /**
     * Selects from the database from by PatID and stores in variables.
     * @param id patient id
     */
    public void selectDB(String id) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Patients WHERE patId='" + id + "'";

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            this.PatID = rs.getString(1);
            this.Pwd = rs.getString(2);
            this.FirstName = rs.getString(3);
            this.LastName = rs.getString(4);
            this.Email = rs.getString(5);

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    

}
