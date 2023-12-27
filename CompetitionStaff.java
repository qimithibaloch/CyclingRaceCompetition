package main.java.model;

public class CompetitionStaff {
    private int staffID;
    private String staffName;
    private String staffRole;

    /**
   
     
      @param staffID  
      @param staffName 
      @param staffRole 
     */
    public CompetitionStaff(int staffID, String staffName, String staffRole) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffRole = staffRole;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public void coordinateEmergency() {
        System.out.println("Coordinating emergency");
    }

    public void manageCompetition() {
        System.out.println("Managing competition");
    }

    public void setEvent(String event) {
        System.out.println("Setting event: " + event);
    }

    public void viewDetails() {
        System.out.println("Viewing details for staff " + staffName + " with staff ID " + staffID);
    }

    public void generateReports() {
        System.out.println("Generating reports");
    }

    @Override
    public String toString() {
        return "CompetitionStaff{" +
                "staffID=" + staffID +
                ", staffName='" + staffName + '\'' +
                ", staffRole='" + staffRole + '\'' +
                '}';
    }
}
