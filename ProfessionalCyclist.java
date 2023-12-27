package main.java.model;

import java.util.Arrays;

import main.java.model.Cyclist;

public class ProfessionalCyclist extends Cyclist {
    private int[] scores;

    /**
   
     * @param cyclistNumber 
     * @param name             
     * @param email            
     * @param age              
     * @param gender           
     * @param country        
     * @param category         
     * @param level            
     * @param scores           
     */
    public ProfessionalCyclist(int cyclistNumber, String name, String email, int age, String gender, String country, String category, String level, int[] scores) {
        super(cyclistNumber, name, email, age, gender, country, category, level, scores);
        this.scores = scores;
    }

    /**
   
     @return 
     */
    @Override
    public double getOverallScore() {
        if (scores.length < 2) return 0;
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);
        return (double) (sortedScores[sortedScores.length - 1] + sortedScores[sortedScores.length - 2]) / 2;
    }

    /**

     @return 
     */
    public String getEncouragement() {
        double averageScore = getOverallScore();
        if (averageScore >= 4.5) {
            return "Outstanding performance!";
        } else if (averageScore >= 3.5) {
            return "Great job, keep improving!";
        } else {
            return "Good effort! Practice more for better results.";
        }
    }
}

