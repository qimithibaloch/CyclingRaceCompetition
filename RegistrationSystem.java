import java.util.ArrayList;
import java.util.Date;

import main.java.model.Cyclist;

public class RegistrationSystem<cyclist> {
    private int registrationID;
    private ArrayList<Cyclist> cyclists;
    private Date date;
    private String status;

    public RegistrationSystem(int registrationID, ArrayList<Cyclist> cyclists, Date date, String status) {
        this.registrationID = registrationID;
        this.cyclists = cyclists;
        this.date = date;
        this.status = status;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public ArrayList<Cyclist> getCyclists() {
        return cyclists;
    }

    public void setCyclists(ArrayList<Cyclist> cyclists) {
        this.cyclists = cyclists;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void registerCyclist(Cyclist cyclist) {
        System.out.println("Registeringcyclist: " + cyclist.getName());
    }

    public Cyclist searchCyclist(int cyclistID) {
        System.out.println("Searching for cyclist with ID: " + cyclistID);
        return null; 
    }

    public void approveRegistration(int cyclistID) {
        System.out.println("Approving registration for competitor with ID: " + cyclistID);
    }

    public void rejectRegistration(int cyclistID) {
        System.out.println("Rejecting registration for competitor with ID: " + cyclistID);
    }

    public void viewDetails() {
        System.out.println("Viewing registration details");
    }

    public void generateReports() {
        System.out.println("Generating reports");
    }

    @Override
    public String toString() {
        return "RegistrationSystem{" +
                "registrationID=" + registrationID +
                ", cyclists=" + cyclists +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
