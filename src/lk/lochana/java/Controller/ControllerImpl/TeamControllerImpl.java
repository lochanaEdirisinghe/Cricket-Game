package lk.lochana.java.Controller.ControllerImpl;

import lk.lochana.java.Controller.TeamControllerSuper;
import lk.lochana.java.Model.Player;
import lk.lochana.java.Model.Team;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TeamControllerImpl implements TeamControllerSuper {
    private Random random = new Random();         //Random number object instantiated
    private Scanner scanner = new Scanner(System.in); //Scanner object instantiated
    private ArrayList<Team> teamsList = new ArrayList<>();   //ArrayList for store 2 teams


    @Override
    public void gameStarter(){
        System.out.println("Cricket Tournament");
        System.out.print("Team1 -:");
        String team1Name = scanner.nextLine();
        Team team1 = new Team(team1Name);
        System.out.print("Team2 -:");
        String team2Name = scanner.nextLine();
        Team team2 = new Team(team2Name);
        System.out.println('\n');
        teamsList.add(team1);
        teamsList.add(team2);
    }

    @Override
    public void toss(){  //Toss function
        System.out.println("Let's put the toss");//put the toss
        int toss = random.nextInt(2);
        if (toss==1){
            System.out.println(teamsList.get(0)+" won the toss");
        }else {
            System.out.println(teamsList.get(1)+" won the toss");
            Collections.swap(teamsList, 0, 1);
        }
        System.out.println('\n');

    }

    @Override
    public void gamePlay(){  //The function defines that how to play the game
        for (Team t : teamsList) {              //For each loop for trams array
            System.out.println("++++++++++ Team "+t.getTeamName()+" +++++++++++++");
            int playerRuns = 0;
            int playerNo = 1;
            for (int i = 1; i < 6; i++) {      //number of overs
                if (playerNo > 6) {   //check weather players are more than 6 or less than 6
                    System.out.println("All out !!!");
                    break;
                }else {
                    System.out.println("============================");
                    System.out.println("Over " + i);
                    System.out.println("============================");
                    for (int j = 1; j < 4; j++) {    //number of balls per over
                            System.out.println("Ball " + j);

                            while (true) {                  //validation of press p button(It will repeat untill the string=p
                                System.out.println("Press key p to play");
                                String play = scanner.next();
                                if (play.equals("p") || play.equals("P")) {
                                    break;
                                } else {
                                    System.out.println("Invalid!!!");
                                }
                            }

                            int runs = random.nextInt(8);     //random number generator
                            switch (runs){
                                case 5:                            //get out - caught
                                    System.out.println("out");
                                    System.out.println('\n');
                                    t.setPlayer(playerNo, playerRuns, "Out!! Caught!!");  //adding a player to the players array
                                    playerRuns = 0;
                                    playerNo += 1;
                                    break;

                                case 7:                         // get out - boeled
                                    System.out.println("out");
                                    System.out.println('\n');
                                    t.setPlayer(playerNo, playerRuns, "Out!! Bowled!!");   //adding a player to the players array
                                    playerRuns = 0;
                                    playerNo += 1;
                                    break;

                                default:
                                    System.out.println(runs + " marks");
                                    System.out.println('\n');
                                    playerRuns += runs;


                            }
                    }
                }
             }
            if(playerNo<7){   //adding players who didn't bat
                t.setPlayer(playerNo, playerRuns, "not out");  //adding a player to the players array
                playerNo++;
                for (int i=playerNo; i<7; i++){
                    t.setPlayer(i, 0, "not out");
                }
            }
            t.CalculateTotalRuns(); //set the total runs
        }
        System.out.println("Game Over");
        System.out.println('\n');
    }


    @Override
    public void scoreCard() {
        Team team1 = teamsList.get(0);
        Team team2 = teamsList.get(1);

        if (team1.getTotalRuns()>team2.getTotalRuns()){  //check the winning team
            System.out.println("!!!!!!!!!!!! Team "+team1.getTeamName()+" won the match !!!!!!!!!!!!!");
        }else {
            System.out.println("!!!!!!!!!!!! Team "+team2.getTeamName()+" won the match !!!!!!!!!!!!!");
        }
        System.out.println('\n');
        System.out.println("================SCORECARD====================");
        for (Team t :teamsList) {                                               //print the scorecard
            System.out.print("Team "+t.getTeamName()+" total runs -:");
            System.out.println(t.getTotalRuns());
            Player[] players = t.getPlayers();
            for (Player p : players) {
                System.out.println(p.toString());
            }
            System.out.println("///////////////////////////////////////");
        }


        scanner.close();
    }



}
