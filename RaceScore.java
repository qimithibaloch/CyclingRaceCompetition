public class RaceScore {
    private int playerID;
    private int FinishTime;
    private int SprintPoints;
    private int StageRankings;
    private int Penalties;

    public RaceScore(int playerID, int FinishTime, int SprintPoints, int StageRankings, int Penalties) {
        this.playerID = playerID;
        this.FinishTime= FinishTime;
        this.SprintPoints = SprintPoints;
        this.StageRankings = StageRankings;
        this.Penalties = Penalties;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getFinishTime() {
        return FinishTime;
    }

    public int getSprintPoints() {
        return SprintPoints;
    }

    public int getStageRankings() {
        return StageRankings;
    }

    public int getPenalties() {
        return Penalties;
    }


    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setFinishTime(int FinishTime) {
        this.FinishTime = FinishTime;
    }

    public void setSprintPoints(int SprintPoints) {
        this.SprintPoints = SprintPoints;
    }

    public void setStageRankings(int StageRankings) {
        this.StageRankings = StageRankings;
    }

    public void setPenalties(int Penalties) {
        this.Penalties = Penalties;
    }
}
