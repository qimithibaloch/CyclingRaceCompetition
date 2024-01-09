import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    private static final String CSV_FILE = "CyclistRace_data.csv";

    public static List<Cyclist> readPlayersFromCSV() {
        List<Cyclist> playersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int playerID = Integer.parseInt(data[0]);
                String name = data[1];
                String dob = data[2];
                int age = Integer.parseInt(data[3]); 
                String category = data[4];
                int FinishTime = Integer.parseInt(data[5]);
                int SprintPoints = Integer.parseInt(data[6]);
                int StageRankings = Integer.parseInt(data[7]);
                int Penalties = Integer.parseInt(data[8]);

                Cyclist player = new Cyclist(name, null, dob, category, playerID);
                player.setScores(new RaceScore(playerID, FinishTime, SprintPoints, StageRankings, Penalties));
                playersList.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playersList;
    }

    public static void writePlayerToCSV(Cyclist player) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            writer.println(player.getPlayerID() + "," +
                    player.getName() + "," +
                    player.getDob() + "," +
                    player.calculateAge() + "," +
                    player.getCategory() + "," +
                    player.getScores().getFinishTime() + "," +
                    player.getScores().getSprintPoints() + "," +
                    player.getScores().getStageRankings() + "," +
                    player.getScores().getPenalties());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cyclist getPlayerById(int playerID) {
        List<Cyclist> players = readPlayersFromCSV();
        for (Cyclist player : players) {
            if (player.getPlayerID() == playerID) {
                return player;
            }
        }
        return null;
    }

    public static void updatePlayerScores(Cyclist player) {
        List<Cyclist> players = readPlayersFromCSV();
        boolean playerFound = false;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerID() == player.getPlayerID()) {
                players.set(i, player);
                playerFound = true;
                break;
            }
        }

        if (!playerFound) {
            players.add(player);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, false))) {
            for (Cyclist updatedPlayer : players) {
                writer.println(updatedPlayer.getPlayerID() + "," +
                        updatedPlayer.getName() + "," +
                        updatedPlayer.getDob() + "," +
                        updatedPlayer.calculateAge() + "," +
                        updatedPlayer.getCategory() + "," +
                        updatedPlayer.getScores().getFinishTime() + "," +
                        updatedPlayer.getScores().getSprintPoints() + "," +
                        updatedPlayer.getScores().getStageRankings() + "," +
                        updatedPlayer.getScores().getPenalties());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}