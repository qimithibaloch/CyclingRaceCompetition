import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cyclist {
    private String name;
    private String email;
    private String dob; 
    private String category;
    private int playerID;
    private RaceScore scores;

    public Cyclist(String name, String email, String dob, String category, int playerID) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.category = category;
        this.playerID = playerID;
        this.scores = new RaceScore(playerID, 0, 0, 0, 0); 
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getCategory() {
        return category;
    }

    public int getPlayerID() {
        return playerID;
    }

    public RaceScore getScores() {
        return scores;
    }

    public void setScores(RaceScore scores) {
        this.scores = scores;
    }

    public int calculateAge() {
        if (dob != null && !dob.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0; 
        }
    }
}
