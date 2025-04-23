package org.example.chiropractorproject.BusinessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorList {
    /**
     * Number of doctors
     */
    public int count;

    /**
     * Doctor array list.
     */
    public ArrayList<Doctors> docArrayList;

    public DoctorList() {
        count = 0;
        docArrayList = new ArrayList<Doctors>();
    }

    public void addDoctor(Doctors d1) {
        docArrayList.add(d1);
        count++;
    }

    public void displayList() {
        System.out.println("# of Doctors: " + count);

        for (int x = 0; x < docArrayList.size(); x++) {
            this.docArrayList.get(x).display();

        }
    }

    /**
     * Recursively selects patients from the database by doctor id and adds to patArrayList.
     */
    public void selectDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//17706//Documents//ChiropracticDB.accdb");

            Statement statement = con.createStatement();

            String sql = "SELECT DISTINCT Doctors.* FROM Doctors";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                Doctors doc = new Doctors();
                doc.setdocid(rs.getString(1));
                doc.setpwd(rs.getString(2));
                doc.setfirstname(rs.getString(3));
                doc.setlastname(rs.getString(4));
                doc.setemail(rs.getString(5));
                addDoctor(doc);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        DoctorList dl = new DoctorList();
        dl.selectDB();
        dl.displayList();

    }
}
