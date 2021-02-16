package Opgave3;

public class TeamApp {
    public static void main(String[] args) {
        Team<Player> generalTeam = new Team<>("general team");
        generalTeam.addPlayer(new BaseballPlayer("charly"));
        generalTeam.addPlayer(new SoccerPlayer("Hebdo"));
        System.out.println(generalTeam.numberOfPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Arizona Diamondbacks");
        Team<BaseballPlayer> baseballTeam2 = new Team<>("Baltimore Orioles");
        baseballTeam.matchResult(baseballTeam2, 6, 5);
        System.out.println(baseballTeam.getWon());
    }
}
