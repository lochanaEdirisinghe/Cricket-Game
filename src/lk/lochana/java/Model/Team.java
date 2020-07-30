package lk.lochana.java.Model;

public class Team {                     //Teams model
    private String teamName;
    private Player[] players = new Player[6];
    private int totalRuns;
    public Team(String teamName){
        this.setTeamName(teamName);
    }

    @Override
    public String toString() {
        return getTeamName();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPlayer(int playerNo, int runs, String wicket){
        Player player=new Player(playerNo, runs, wicket);
        this.players[playerNo-1]=player;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }


    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void CalculateTotalRuns() {
        int total=0;
        for (Player p :this.players) {
            total+=p.getRuns();

        }
        this.totalRuns=total;

    }

}
