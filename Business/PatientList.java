package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PatientList {
    /**
     * Number of patients
     */
    public int count;

    /**
     * Patient array list.
     */
    public ArrayList<Patients> patArrayList;

    public PatientList() {
        count = 0;
        patArrayList = new ArrayList<Patients>();
    }

    public void addPatient(Patients p1) {
        patArrayList.add(p1);
        count++;
    }
    
    public void displayList() {
        System.out.println("# of Patients: " + count);
        
        for (int x = 0; x < patArrayList.size(); x++) {
            this.patArrayList.get(x).display();
            
        }
    }  
    
   /**
     * Recursively selects patients from the database by doctor id and adds to patArrayList.
     * @param docid doctor id
     */
    public void selectDBDocId(String docid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT DISTINCT Patients.* FROM Patients INNER JOIN Appointments ON Patients.PatID = Appointments.PatID WHERE Appointments.DocID='" + docid + "'";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Patients pat = new Patients();
                pat.setpatid(rs.getString(1));
                pat.setpwd(rs.getString(2));
                pat.setfirstname(rs.getString(3));
                pat.setlastname(rs.getString(4));
                pat.setemail(rs.getString(5));
                addPatient(pat);
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void selectDBDocIdPatId(String docid, String patid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT DISTINCT Patients.* FROM Patients INNER JOIN Appointments ON Patients.PatID = Appointments.PatID WHERE Appointments.DocID='" + docid + "'";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Patients pat = new Patients();
                pat.setpatid(rs.getString(1));
                pat.setpwd(rs.getString(2));
                pat.setfirstname(rs.getString(3));
                pat.setlastname(rs.getString(4));
                pat.setemail(rs.getString(5));
                addPatient(pat);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String[] args) {
        PatientList pl = new PatientList();
        pl.selectDBDocId("003");
        pl.displayList();

    }
}
