package main.java.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Cyclist {
    private int CyclistNumber;
    private String name;
    private String email;
    private int age;
    private String category;
    private String level;
    private int[] scores;

    /**
  
      @param CyclistNumber 
      @param name             
     @param email            
     @param age              
     @param gender         
     @param country         
     @param category         
     @param level           
     @param scores           
     */
    public Cyclist (int CyclistNumber, String name, String email, int age, String gender, String country, String category, String level, int[] scores) {
        this.CyclistNumber = CyclistNumber;
        this.name = name;
        this.email = email;
        this.age = age;
        this.category = category;
        this.level = level;
        this.scores = scores;
    }

    public int getCompetitorNumber() {
        return CyclistNumber;
    }

    public void setCyclistNumber(int CyclistNumber) {
        this.CyclistNumber = CyclistNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int[] getScoreArray() {
        return scores;
    }

    public void setScoreArray(int[] scores) {
        this.scores = scores;
    }

    /**
   

      @return 
     */
    public abstract double getOverallScore();

    /**
   
      @return 
     */
    public String getFullDetails() {
        String scoresString = Arrays.stream(scores)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        return "Cyclist  number " + CyclistNumber + ", name " + name  +
                name + " is a " + level + " aged " + age + " and received these scores: " + scoresString + " and has an overall score of " + getOverallScore() + ".";
    }

    /**
   
     @param name 
      @return 
     */
    private String getInitials(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder initials = new StringBuilder();
        for (String part : name.split("\\s+")) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }

        return initials.toString().toUpperCase();
    }

    /**
   
     @return 
     */
    public String getShortDetails() {
        return "CN " + CyclistNumber + " (" + getInitials(name) + ") has overall score " + getOverallScore() + ".";
    }

    /**
     @return 
     */
    @Override
    public String toString() {
        return "Cyclist{" +
                "CyclistNumber=" + CyclistNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }

    public Object getCyclistNumber() {
        return null;
    }

	public int getCyclistsNumber() {
		return 0;
	}
}


