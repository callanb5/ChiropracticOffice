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

    public void addAppointment(Patients a1) {
        patArrayList.add(a1);
        count++;
    }
    
    public void displayList() {
        System.out.println("# of Patients: " + count);
        
        for (int x = 0; x < patArrayList.size(); x++) {
            this.patArrayList.get(x).display();
            
        }
    }   
}
