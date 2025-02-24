package org.example;
/**
 * ASP (Chiropractor)
 * Last Editor: Victorino Martinez
 * Date: 1/27/2025
 */

import java.time.*;

public class Appointments {

    private LocalDateTime ApptDateTime;
    private int PatID;
    private int DocID;
    private String Notes;


    public Appointments() {
        ApptDateTime = 0;
        PatID = 0;
        DocID = 0;
        Notes = "";
    }


    public Appointments(LocalDateTime apptdatetime, int patid, int docid, String notes) {
        ApptDateTime = apptdatetime;
        PatID = patid;
        DocID = docid;
        Notes = notes;
    }


    //Getter methods
    public LocalDateTime getApptDateTime() { return ApptDateTime;}                             //ApptDateTime
    public int getPatID() {return PatID;}                                                      //PatID
    public int getDocID() {return DocID;}                                                      //DocID
    public String getNotes() {return Notes;}                                                   //Notes


    //Setter methods
    public void setApptDateTime(LocalDateTime apptdatetime) {ApptDateTime = apptdatetime;}     //ApptDateTime
    public void setPatID(int patid) {PatID = patid;}                                           //PatID
    public void setDocId(int docid) {DocID = docid;}                                           //DocID
    public String setNotes(String notes) {Notes = notes;}                                      //Notes


}
