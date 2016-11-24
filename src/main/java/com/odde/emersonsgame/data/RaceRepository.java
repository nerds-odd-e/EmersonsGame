package com.odde.emersonsgame.data;

import com.odde.emersonsgame.model.Race;

import java.util.List;

public interface RaceRepository {
    List<Race> getAll();
    Race create(Race race);
}
