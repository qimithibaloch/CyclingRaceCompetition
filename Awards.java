package main.java.model;

public class Awards {
    private int awardID;
    private String awardName;
    private int recipientID;
    private Category category;

    /**
  
      @param awardID    
      @param awardName   
      @param recipientID 
      @param category   
     */
    public Awards(int awardID, String awardName, int recipientID, Category category) {
        this.awardID = awardID;
        this.awardName = awardName;
        this.recipientID = recipientID;
        this.category = category;
    }

    public int getAwardID() {
        return awardID;
    }

    public void setAwardID(int awardID) {
        this.awardID = awardID;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     */
    public void createAward() {
        System.out.println("Creating award: " + awardName);
    }

    /**
     */
    public void viewAwardDetails() {
        System.out.println("Viewing details for award: " + awardName);
    }

    @Override
    public String toString() {
        return "Awards{" +
                "awardID=" + awardID +
                ", awardName='" + awardName + '\'' +
                ", recipientID=" + recipientID +
                ", category=" + category +
                '}';
    }
}
