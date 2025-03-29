package org.example;

/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 3/22/2025
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ApptList {
    /**
     * Number of appointments
     */
    public int count;

    /**
     * Appointment array list.
     */
    public ArrayList<Appointments> appArrayList;

    public ApptList() {
        count = 0;
        appArrayList = new ArrayList<Appointments>();
    }

    public void addAppointment(Appointments a1) {
        appArrayList.add(a1);
        count++;
    }

    public void displayList() {
        System.out.println("# of Appointments: " + count);
        
        for (int x = 0; x < appArrayList.size(); x++) {
            this.appArrayList.get(x).display();
            
        }
    }
    
   /**
     * Recursively selects appointments from the database by patient id and adds to appArrayList.
     * @param patid patient id
     */
    public void selectDBPatId(String patid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE PatId='" + patid + "'";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Appointments a = new Appointments();
                a.setApptID(rs.getInt(1));
                a.setApptDateTime(rs.getTimestamp(2));
                a.setPatID(rs.getString(3));
                a.setDocID(rs.getString(4));
                a.setNotes(rs.getString(5));
                addAppointment(a);
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
       /**
     * Recursively selects appointments from the database by doctor id and adds to appArrayList.
     * @param docid doctor id
     */
    public void selectDBDocId(String docid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE DocID='" + docid + "'";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Appointments a = new Appointments();
                a.setApptID(rs.getInt(1));
                a.setApptDateTime(rs.getTimestamp(2));
                a.setPatID(rs.getString(3));
                a.setDocID(rs.getString(4));
                a.setNotes(rs.getString(5));
                addAppointment(a);
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void selectDBApptDate(String patid, Timestamp apptdate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String apptDateString = dateFormat.format(apptdate);
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE PatId='" + patid + "' AND DateValue(ApptDateTime) = DateValue(#" + apptDateString + "#)";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Appointments a = new Appointments();
                a.setApptID(rs.getInt(1));
                a.setApptDateTime(rs.getTimestamp(2));
                a.setPatID(rs.getString(3));
                a.setDocID(rs.getString(4));
                a.setNotes(rs.getString(5));
                addAppointment(a);
            }
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void selectDBApptDateDoc(String patid, String docid, Timestamp apptdate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String apptDateString = dateFormat.format(apptdate);

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE PatId='" + patid + "' AND DocId='" + docid + "' AND DateValue(ApptDateTime) = DateValue(#" + apptDateString + "#)";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Appointments a = new Appointments();
                a.setApptID(rs.getInt(1));
                a.setApptDateTime(rs.getTimestamp(2));
                a.setPatID(rs.getString(3));
                a.setDocID(rs.getString(4));
                a.setNotes(rs.getString(5));
                addAppointment(a);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String[] args) {
        String dateStr = "2025-03-11";
        Timestamp ts = Timestamp.valueOf(dateStr + " 00:00:00");
        System.out.println("Timestamp: " + ts);
        
        ApptList al = new ApptList();
        al.selectDBApptDateDoc("0001", "001", ts);
        al.displayList();
    }
}
