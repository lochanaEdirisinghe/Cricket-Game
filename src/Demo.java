import lk.lochana.java.Controller.ControllerImpl.TeamControllerImpl;
import lk.lochana.java.Controller.TeamControllerSuper;

public class Demo {
    public static void main(String[] args) {
        TeamControllerSuper tc = new TeamControllerImpl();//loose Coupled by TeamControllerSuper interface
        tc.gameStarter();      //Game starts
        tc.toss();            //toss function is called
        tc.gamePlay();        //gameplay function is called
        tc.scoreCard();       //ScoreCard
    }
}
