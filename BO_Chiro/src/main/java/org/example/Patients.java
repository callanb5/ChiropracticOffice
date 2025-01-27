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


}