package com.odde.emersonsgame.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {
    private String name;
    private List<Player> players;
    private Date startedAt;
    private Date finishedAt;

    public Race() {
        players = new ArrayList<Player>();
    }

    public String getName() {
        return "This is a Race";
    }

    public List<Player> getPlayers() {
        players.add(new Player());
        players.add(new Player());

        return players;
    }

    public Date getStartedAt() {
        return new Date();
    }

    public Date getFinishedAt() {
        return new Date();
    }
}
