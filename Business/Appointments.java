package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 3/10/2025
 */

import java.time.*;
import java.sql.Timestamp;

public class Appointments {

    private String ApptID
    private Timestamp ApptDateTime;
    private String PatID;
    private String DocID;
    private String Notes;


    public Appointments() {
        ApptID = 0;
        ApptDateTime = new Timestamp(0);
        PatID = 0;
        DocID = 0;
        Notes = "";
    }


    public Appointments(String apptid, Timestamp apptdatetime, int patid, int docid, String notes) {
        ApptID = apptid;
        ApptDateTime = apptdatetime;
        PatID = patid;
        DocID = docid;
        Notes = notes;
    }


    //Getter methods
    public String getApptID() {return ApptID;}
    public Timestamp getApptDateTime() { return ApptDateTime;}                             //ApptDateTime
    public String getPatID() {return PatID;}                                                      //PatID
    public String getDocID() {return DocID;}                                                      //DocID
    public String getNotes() {return Notes;}                                                   //Notes


    //Setter methods
    public void setApptID(String apptid) {ApptID}
    public void setApptDateTime(long apptdatetime) {ApptDateTime = new Timestamp(apptdatetime);}     //ApptDateTime
    public void setPatID(String patid) {PatID = patid;}                                           //PatID
    public void setDocId(String docid) {DocID = docid;}                                           //DocID
    public void setNotes(String notes) {Notes = notes;}                                      //Notes
    

    
    /**
     * Selects from the database by patient id and stores appointment information in variables.
     * @param patid patient id
     */
    public void selectDBPatId(String patid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE PatId='" + patid + "'";

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            this.ApptID = rs.getInt(1);
            this.ApptDateTime = rs.getTimestamp(2);
            this.PatID = rs.getInt(3);
            this.DocID = rs.getInt(4);
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

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE DocID='" + docid + "'";

            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            this.ApptID = rs.getInt(1);
            this.ApptDateTime = rs.getTimestamp(2);
            this.PatID = rs.getInt(3);
            this.DocID = rs.getInt(4);
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

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

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
    public boolean insertDB(String apptId, Timestamp apptDateTime, int docid, String patId, String notes) {
        try {
            this.ApptID
            this.ApptDateTime = apptDateTime;
            this.DocID = docId;
            this.PatID = patId;
            this.Notes = notes;

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "INSERT INTO Appointments values ('" + apptId + "', " + apptDateTime + ",'" + docId + "','" + patId + "','" + notes + "')";

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

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://../ChiropracticDB.accdb");

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
    
}
