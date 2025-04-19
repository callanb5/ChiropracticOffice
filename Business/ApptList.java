package org.example;

/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 4/16/2025
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


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

    /**
     * Adds provided appointment to apptArrayList
     * @param a1 appointment
     */
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
    
    /**
     * Recursively selects appointments from the database by patient id and appointment date and adds to appArrayList.
     *
     * @param patid patient id
     * @param apptdate appointment date
     */
    public void selectDBApptDatePat(String patid, Timestamp apptdate) {
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
  
    /**
     * Recursively selects appointments from the database by appointment date and adds to appArrayList.
     *
     * @param apptdate appointment date
     */
    public void selectDBApptDate(Timestamp apptdate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String apptDateString = dateFormat.format(apptdate);

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE DateValue(ApptDateTime) = DateValue(#" + apptDateString + "#)";

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
    
    /**
     * Recursively selects appointments from the database by doctor id and appointment date and adds to appArrayList.
     *
     * @param docid doctor id
     * @param apptdate appointment date
     */
    public void selectDBApptDateDoc(String docid, Timestamp apptdate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String apptDateString = dateFormat.format(apptdate);
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Appointments WHERE DocId='" + docid + "' AND DateValue(ApptDateTime) = DateValue(#" + apptDateString + "#)";

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
    
    /**
     * Returns available appointments with specified doctor on day provided in apptdate.
     *
     * @param docid doctor id
     * @param apptdate date
     * @return ArrayList of available appointments
     */
    public ArrayList<Timestamp> getAvailableAppointments(String docid, Timestamp apptdate) {
        try {
            selectDBApptDateDoc(docid, apptdate);
            
            ArrayList<Timestamp> freeSlots = new ArrayList<Timestamp>();
            ArrayList<Timestamp> bookedSlots = new ArrayList<Timestamp>();
            
            for (int i = 0; i < count; i++) {
                Appointments appt = appArrayList.get(i);
                bookedSlots.add(appt.getApptDateTime());
            }
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(apptdate);
            calendar.set(Calendar.HOUR_OF_DAY, 9);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            
            Calendar endCalendar = (Calendar) calendar.clone();
            endCalendar.set(Calendar.HOUR_OF_DAY, 17);
            
            while (calendar.before(endCalendar)) {
                Timestamp slot = new Timestamp(calendar.getTimeInMillis());
                
                boolean booked = false;
                for (int i = 0; i < bookedSlots.size (); i++) {
                    if (bookedSlots.get(i).equals(slot)) {
                        booked = true;
                        break;
                    }
                }
                
                if(!booked) {
                    freeSlots.add(slot);
                }
                calendar.add(Calendar.MINUTE, 30);
            }
            
            return freeSlots;
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            ArrayList<Timestamp> tsl = new ArrayList<Timestamp>();
            return tsl;
        }
    }
    
     /**
     * Returns available appointments with any doctor on day provided in apptdate.
     *
     * @param apptdate date
     * @return ArrayList of available appointments
     */
    public ArrayList<Timestamp> getAvailableAppointmentsDate(Timestamp apptdate) {
        try {
            selectDBApptDate(apptdate);

            ArrayList<Timestamp> freeSlots = new ArrayList<Timestamp>();
            ArrayList<Timestamp> bookedSlots = new ArrayList<Timestamp>();

            for (int i = 0; i < count; i++) {
                Appointments appt = appArrayList.get(i);
                bookedSlots.add(appt.getApptDateTime());
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(apptdate);
            calendar.set(Calendar.HOUR_OF_DAY, 9);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Calendar endCalendar = (Calendar) calendar.clone();
            endCalendar.set(Calendar.HOUR_OF_DAY, 17);

            while (calendar.before(endCalendar)) {
                Timestamp slot = new Timestamp(calendar.getTimeInMillis());

                boolean booked = false;
                for (int i = 0; i < bookedSlots.size(); i++) {
                    if (bookedSlots.get(i).equals(slot)) {
                        booked = true;
                        break;
                    }
                }

                if (!booked) {
                    freeSlots.add(slot);
                }
                calendar.add(Calendar.MINUTE, 30);
            }

            return freeSlots;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            ArrayList<Timestamp> tsl = new ArrayList<Timestamp>();
            return tsl;
        }
    }
    
    public static void main(String[] args) {
        String dateStr = "2025-03-11";
        Timestamp ts = Timestamp.valueOf(dateStr + " 00:00:00");
        System.out.println("Timestamp: " + ts);
        
        ApptList al = new ApptList();
        al.selectDBApptDateDoc("001", ts);
        al.displayList();
    }
    
    
}
