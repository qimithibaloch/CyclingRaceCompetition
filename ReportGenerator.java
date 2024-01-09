import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private List<RaceScore> scores;

    public ReportGenerator() {
        this.scores = readScoresFromCSV();
    }

    public String generateAverageScoreReport(int playerID) {
        double averageScore = calculateAverageScore(playerID);
        int playerAge = getPlayerAge(playerID); 
        return "Average Score Report for Player " + playerID + " (Age: " + playerAge + "): " + averageScore;
    }

    public String generateFullReport(int playerID) {
        StringBuilder fullReport = new StringBuilder("Full Report for Player " + playerID + ":\n");
        int playerAge = getPlayerAge(playerID); 
        fullReport.append("Player Age: ").append(playerAge).append("\n");

        for (RaceScore score : scores) {
            if (score.getPlayerID() == playerID) {
                fullReport.append("FinishTime: ").append(score.getFinishTime()).append("\n");
                fullReport.append("SprintPoints: ").append(score.getSprintPoints()).append("\n");
                fullReport.append("StageRankings: ").append(score.getStageRankings()).append("\n");
                fullReport.append("Penalties: ").append(score.getPenalties()).append("\n");
            }
        }
        return fullReport.toString();
    }

    private List<RaceScore> readScoresFromCSV() {
        List<RaceScore> scoresList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("CyclistRace_data.csv"))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int playerID = Integer.parseInt(data[0]);
                int FinishTime = Integer.parseInt(data[5]);  
                int SprintPoints = Integer.parseInt(data[6]); 
                int StageRankings = Integer.parseInt(data[7]); 
                int Penalties = Integer.parseInt(data[8]); 
                scoresList.add(new RaceScore(playerID, FinishTime, SprintPoints, StageRankings, Penalties));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoresList;
    }

    private double calculateAverageScore(int playerID) {
        int totalScore = 0;
        int count = 0;
        for (RaceScore score : scores) {
            if (score.getPlayerID() == playerID) {
                totalScore += score.getFinishTime() + score.getSprintPoints() + score.getStageRankings() + score.getPenalties();
                count += 4; 
            }
        }
        return count > 0 ? (double) totalScore / count : 0;
    }

    private int getPlayerAge(int playerID) {
        Cyclist player = CSVHandler.getPlayerById(playerID);
        if (player != null) {
            return player.calculateAge();
        } else {
            System.out.println("Player not found with ID: " + playerID);
            return -1; 
        }
    }
}
