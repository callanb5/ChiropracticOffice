package org.example.chiropractorproject.BusinessObjects;
/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 3/22/2025
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.*;
import java.sql.Timestamp;

public class Appointments {

    private int ApptID;
    private Timestamp ApptDateTime;
    private String PatID;
    private String DocID;
    private String Notes;

    public Appointments() {
        ApptID = 0;
        ApptDateTime = new Timestamp(0);
        PatID = "";
        DocID = "";
        Notes = "";
    }


    public Appointments(int apptid, Timestamp apptdatetime, String patid, String docid, String notes) {
        ApptID = apptid;
        ApptDateTime = apptdatetime;
        PatID = patid;
        DocID = docid;
        Notes = notes;
    }


    //Getter methods
    public int getApptID() {return ApptID;}
    public Timestamp getApptDateTime() { return ApptDateTime;}                             //ApptDateTime
    public String getPatID() {return PatID;}                                                      //PatID
    public String getDocID() {return DocID;}                                                      //DocID
    public String getNotes() {return Notes;}                                                   //Notes


    //Setter methods
    public void setApptID(int apptid) {ApptID = apptid;}
    //public void setApptDateTime(long apptdatetime) {ApptDateTime = new Timestamp(apptdatetime);}     //ApptDateTime
    public void setApptDateTime (Timestamp apptdatetime) {ApptDateTime = apptdatetime;}
    public void setPatID(String patid) {PatID = patid;}                                           //PatID
    public void setDocID(String docid) {DocID = docid;}                                           //DocID
    public void setNotes(String notes) {Notes = notes;}                                      //Notes



    /**
     * Selects from the database by patient id and stores appointment information in variables.
     * @param patid patient id
     */
    public void selectDBPatId(String patid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE PatId='" + patid + "'";

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            this.ApptID = rs.getInt(1);
            this.ApptDateTime = rs.getTimestamp(2);
            this.PatID = rs.getString(3);
            this.DocID = rs.getString(4);
            this.Notes = rs.getString(5);

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Selects from the database by doctor id and stores appointment information in variables.
     * @param docid doctor id
     */
    public void selectDBDocId(String docid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE DocID='" + docid + "'";

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            this.ApptID = rs.getInt(1);
            this.ApptDateTime = rs.getTimestamp(2);
            this.PatID = rs.getString(3);
            this.DocID = rs.getString(4);
            this.Notes = rs.getString(5);

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Updates database with stored values.
     * @return True on success, False on fail.
     */
    public boolean updateDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "UPDATE Appointments SET ApptID='"+this.ApptID+"', ApptDateTime="+this.ApptDateTime+","+" PatID='"+this.PatID+"',"+" DocID='"+this.DocID+"',"+" Notes='"+this.Notes+"' WHERE ApptID='"+this.ApptID+"'";
            System.out.println(sql);
            int n = statement.executeUpdate(sql);
            if (n==1) {
                System.out.println("UPDATE Successful.");
            } else {
                System.out.println("UPDATE Failed.");
            }
            con.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    /**
     * Inserts appointment into database from provided apptId, apptDateTime, docId, patId, and notes.
     * @param apptId appointment id
     * @param apptDateTime appointment date and time
     * @param docId doctor id
     * @param patId patient id
     * @param notes appointment notes
     * @return True on success, False on fail.
     */
    public boolean insertDB(int apptId, Timestamp apptDateTime, String docId, String patId, String notes) {
        try {
            this.ApptID = apptId;
            this.ApptDateTime = apptDateTime;
            this.DocID = docId;
            this.PatID = patId;
            this.Notes = notes;

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "INSERT INTO Appointments values (" + apptId + ", #" + apptDateTime.toString().substring(0, 19).replace('T', ' ') + "#,'" + patId + "','" + docId + "','" + notes + "')";

            System.out.println(sql);

            int n1 = statement.executeUpdate(sql);
            if (n1 == 1) {
                System.out.println("INSERT Successful.");
            } else {
                System.out.println("INSERT Failed.");
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    /**
     * Deletes appointment from database from stored ApptID.
     * @return True on succeed, False on fail.
     */
    public boolean deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "DELETE from Appointments where ApptID='" + ApptID + "'";

            System.out.println(sql);

            int n = statement.executeUpdate(sql);
            if (n == 1) {
                System.out.println("DELETE Successful.");
            } else {
                System.out.println("DELETE Failed.");
            }
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public void selecthighIDDB() {

        try {
            //Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");

            //Creating Connection
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");

            //SqL statement
            String sql = "SELECT MAX(ApptID) FROM Appointments";
            System.out.println(sql);

            //Create Statement
            Statement stmt = con.createStatement();

            //Execute Statement
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ApptID = rs.getInt(1);
            }

            //Close Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }//end try/catch

    }

    public void display() {
        System.out.println("ApptId " + getApptID());
        System.out.println("ApptDateTime " + getApptDateTime());
        System.out.println("PatID " + getPatID());
        System.out.println("DocID " + getDocID());
        System.out.println("Notes " + getNotes());
    }

    public static void main(String[] args) {
        /*
        Appointments a = new Appointments();
        
        long epochSeconds = 1741152000L;
        Timestamp timestamp = new Timestamp(epochSeconds * 1000);
        
        a.setApptID(3);
        a.setApptDateTime(timestamp);
        a.setPatID("PATIENTIDHOLDER");
        a.setDocID("DOCTORIDHOLDER");
        a.setNotes("NOTESHOLDER");
        a.display();
        */

        Appointments a = new Appointments();
        a.selecthighIDDB();
        System.out.println(a.ApptID);
    }
}