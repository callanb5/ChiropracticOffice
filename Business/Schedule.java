package org.example.chiropractorproject.BusinessObjects;
/**
 * ASP (Chiropractor)
 * Last Editor: Callan Bramblett
 * Date: 3/10/2025
 */

import java.sql.*;

public class Schedule {

    private String docid;
    private String date;


    public Schedule() {
        docid = "";
        date = "";
    }


    public Schedule(String DOCID, String DATE) {
        docid = DOCID;
        date = DATE;
    }


    //Getter methods
    public String getdocid() {return docid;}
    public String getdate() {return date;}


    //Setter methods
    public void setdocid(String DOCID) {docid = DOCID; }
    public void setdate(String DATE) {date = DATE;}



    /**
     * Selects from the database by date
     * @param DATE date
     */
    public void selectDB(String DATE) {
        date = DATE;

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver Loaded");


            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");
            System.out.println("Connection created");

            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM Schedule WHERE Date = '" + date + "'";
            System.out.println(sql);

            ResultSet rs;
            rs = stmt.executeQuery(sql);

            if (!rs.isBeforeFirst()) {
                System.out.println("No rows found for Date: " + date);  // This will tell us if no rows were returned
            } else {
                while (rs.next()) {
                    System.out.println("DocID: " + rs.getString("DocID") + ", Date: " + rs.getString("Date"));
                    docid = rs.getString("DocID");
                    date = rs.getString("Date");
                }
            }


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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

            String sql = "UPDATE Schedule SET DocID = '" + this.docid + "', Date = '" + this.date + "' WHERE Date = '" + date + "'";
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

    public void display(){

        System.out.println("====================================");
        System.out.println("Doctor ID: " + docid);
        System.out.println("Date : "+ date);
        System.out.println("====================================");
    }

    public static void main(String Args[]) {
        //SelectDB() works
        /*
        Schedule s1 = new Schedule();
        s1.selectDB("Sunday");
        s1.display();*/

        //UpdateDB() works
        /*
        Schedule s2 = new Schedule();
        s2.selectDB("Tuesday");
        s2.display();

        s2.setdocid("007");
        s2.setdate("TUESDAY");
        s2.updateDB();
        */

    }

}
