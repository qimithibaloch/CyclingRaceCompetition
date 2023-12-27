package main.java.model;

import java.util.Date;

public class CyclingRace {
    private int raceID;
    private String raceName;
    private Date raceDate;
    private String location;
    private String category;

    /**
   
      @param raceName  
      @param raceDate  
      @param location 
      @param category 
     */
    public CyclingRace(int raceID, String raceName, Date raceDate, String location, String category) {
        this.raceID = raceID;
        this.raceName = raceName;
        this.raceDate = raceDate;
        this.location = location;
        this.category = category;
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void startRace() {
        System.out.println("Starting the race: " + raceName);
    }

    public void endRace() {
        System.out.println("Ending the race: " + raceName);
    }

    public void generateResults() {
        System.out.println("Generating results for the race: " + raceName);
    }

    /**
     */
    public void scheduleRace() {
        System.out.println("Scheduling the race: " + raceName);
    }

    @Override
    public String toString() {
        return "CyclingRace{" +
                "raceID=" + raceID +
                ", raceName='" + raceName + '\'' +
                ", raceDate=" + raceDate +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

