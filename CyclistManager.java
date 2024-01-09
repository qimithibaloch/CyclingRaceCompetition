import java.util.ArrayList;
import java.util.List;

public class CyclistManager {
    private List<Cyclist> players;

    public CyclistManager() {
        this.players = new ArrayList<>();
    }

    public void registerPlayer(String name, String email, String dateOfBirth, String category) {
        int playerID = generateRandomPlayerID();
        Cyclist newPlayer = new Cyclist(name, email, dateOfBirth, category, playerID);
        players.add(newPlayer);
        CSVHandler.writePlayerToCSV(newPlayer); 
    }

    private int generateRandomPlayerID() {
        return 100 + (int) (Math.random() * 900); 
    }

    public List<Cyclist> getPlayers() {
        return players;
    }

    public Cyclist findPlayerById(int playerID) {
        for (Cyclist player : players) {
            if (player.getPlayerID() == playerID) {
                return player;
            }
        }
        return null; 
    }
}
