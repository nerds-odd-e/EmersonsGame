package com.odde.emersonsgame.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {
    private Long id;
    private String name;
    private List<Player> players;
    private Date startedAt;
    private Date finishedAt;

    public Race() {
        this(null, null, null, null);
    }

    public Race(final String name) {
        this(null, name, new Date(), null);
    }

    public Race(final Long id, final String name, final Date startedAt, final Date finishedAt) {
        this.players = new ArrayList<Player>();

        this.id = id;
        this.name = name;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public Race(final Long id, final Race race) {
        this(id, race.getName(), race.getStartedAt(), race.getFinishedAt());
    }

    public Long getId() {
        return id;
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
