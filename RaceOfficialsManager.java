import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RaceOfficialsManager {
    private List<RaceOfficials> moderators;

    public RaceOfficialsManager() {
        this.moderators = new ArrayList<>();
        moderators.add(new RaceOfficials("admin", "root"));
    }

    public boolean login(String username, String password) {
        for (RaceOfficials moderator : moderators) {
            if (moderator.login(username, password)) {
                return true;
            }
        }
        return false; 
    }

    public void inputScores(int playerID, int FinishTime, int SprintPoints, int StageRankings, int Penalties) {
        RaceScore newScore = new RaceScore(playerID, FinishTime, SprintPoints, StageRankings, Penalties);
        saveScoreToCSV(newScore);
    }

    private void saveScoreToCSV(RaceScore score) {
        Cyclist player = CSVHandler.getPlayerById(score.getPlayerID());

        if (player != null) {
            player.setScores(score);
            CSVHandler.updatePlayerScores(player);
        } else {
            System.out.println("Player not found with ID: " + score.getPlayerID());
        }
    }
}
