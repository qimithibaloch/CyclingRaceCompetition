package main.java.model;

import java.util.Arrays;

/**
 */
public class RaceScores {
    private int raceID;
    private int cyclistID;
    private int[] scores;
    private int time;
    private int position;

    /**
   
     @param raceID    
     @param cyclistID  
     @param scores     
     @param time       
      @param position   
     */
    public RaceScores(int raceID, int cyclistID, int[] scores, int time, int position) {
        this.raceID = raceID;
        this.cyclistID = cyclistID;
        this.scores = scores;
        this.time = time;
        this.position = position;
    }

    /**
   
     * @return 
     */
    public int getRaceID() {
        return raceID;
    }

    /**
   
     */
    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    /**
   
     * @return The ID of the cyclist.
     */
    public int getCyclistID() {
        return cyclistID;
    }

    /**
   
     */
    public void setCyclistID(int cyclistID) {
        this.cyclistID = cyclistID;
    }

    /**
   
     * @return An array of scores for the race.
     */
    public int[] getScores() {
        return scores;
    }

    /**
    
     */
    public void setScores(int[] scores) {
        this.scores = scores;
    }

    /**
   
     * @return 
     */
    public int getTime() {
        return time;
    }

    /**
   
     * @param time 
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
  
      @return 
     */
    public int getPosition() {
        return position;
    }

    /**
   
     @param position 
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
 
    
      @param score 
     */
    public void addScore(int score) {
        System.out.println("Adding score: " + score);
    }

    /**
   
      @return 
     */
    public int calculateTotalScore() {
        int totalScore = 0;

        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }

    /**
  
      @return 
     */
    @Override
    public String toString() {
        return "RaceScores{" +
                "raceID=" + raceID +
                ", cyclistID=" + cyclistID +
                ", scores=" + Arrays.toString(scores) +
                ", time=" + time +
                ", position=" + position +
                '}';
    }
}
