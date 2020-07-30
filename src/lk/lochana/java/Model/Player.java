package lk.lochana.java.Model;

public class Player {                 //player Model
    private int playerNo;
    private int runs;
    private String wicket;

    public Player(int playerNo, int runs, String wicket) {
        this.playerNo = playerNo;
        this.runs = runs;
        this.wicket = wicket;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getWicket() {
        return wicket;
    }

    public void setWicket(String wicket) {
        this.wicket = wicket;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    @Override
    public String toString() {
        return "Player "+ playerNo +
                ", runs= " + runs +
                ", wicket= " + wicket ;
    }
}
