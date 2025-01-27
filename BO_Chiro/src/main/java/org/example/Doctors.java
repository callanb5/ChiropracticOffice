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


}
