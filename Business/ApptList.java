package org.example.chiropractorproject.BusinessObjects;

public class ApptList {
    public int count;
    public Appointments apptArr[] = new Appointments[10];

    public ApptList() {

    }

    public void addAppointment(Appointments a1) {
        apptArr[count] = a1;
        count++;
    }

    public void displayList() {
        System.out.println("# of Appointments: " + count);

        for (int x = 0; x < count; x++) {
            apptArr[x].display();
        }
    }
}
