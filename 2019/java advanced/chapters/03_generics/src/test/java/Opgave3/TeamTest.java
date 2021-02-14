package Opgave3;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TeamTest {
    @Test
    public void addPlayerIncreasesNumberOfPlayers() {
        Team<SoccerPlayer> soccerTeam = new Team<>("KRC Genk");
        assertEquals(0, soccerTeam.numberOfPlayers());
        soccerTeam.addPlayer(new SoccerPlayer("Buffel"));
        assertEquals(1, soccerTeam.numberOfPlayers());
    }

    @Test
    public void addPlayerTwiceDoesNotIncreaseNumberOfPlayers() {
        Team<SoccerPlayer> soccerTeam = new Team<>("KRC Genk");
        assertEquals(0, soccerTeam.numberOfPlayers());
        SoccerPlayer player = new SoccerPlayer("Buffel");
        soccerTeam.addPlayer(player);
        soccerTeam.addPlayer(player);
        assertEquals(1, soccerTeam.numberOfPlayers());
    }
}
