package org.example.chiropractorproject.BusinessObjects;

public class PatientList {
    public int count;
    public Patients patArr[] = new Patients[10];

    public PatientList() {

    }

    public void addPatient(Patients p1) {
        patArr[count] = p1;
        count++;
    }

    public void displayList() {
        System.out.println("# of Patients: " + count);

        for (int x = 0; x < count; x++) {
            patArr[x].display();
        }
    }
}