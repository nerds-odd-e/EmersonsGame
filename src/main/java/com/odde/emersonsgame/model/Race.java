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
        this(null, null, null);
    }

    public Race(String name) {
        this(name, new Date(), null);
    }

    public Race(String name, Date startedAt, Date finishedAt) {
        this.players = new ArrayList<Player>();

        this.name = name;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        players.add(new Player());
        players.add(new Player());

        return players;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }
}
