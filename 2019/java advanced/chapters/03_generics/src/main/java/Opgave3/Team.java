package Opgave3;

import java.util.ArrayList;

public class Team<T extends Player> {
    String name;
    int played;
    int won;
    int lost;
    int tied ;
    ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    public ArrayList<T> getMembers() {
        return members;
    }

    //methods
    public void addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println("already contains this player");
        } else {
            members.add(player);
        }
    }

    public int numberOfPlayers() {
        return members.size();
    }

    // dit otherTeam moet nu steeds hetzelfde soort team zijn als van het huidige object
    public void matchResult(Team<T> otherTeam, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            this.won++;
            otherTeam.lost++;
        } else if (ourScore == theirScore) {
            this.tied++;
            otherTeam.tied++;
        } else {
            this.lost++;
            otherTeam.won++;
        }
        this.played++;
        otherTeam.played++;
    }

    public int ranking() {
        return won * 3 + tied;
    }
}