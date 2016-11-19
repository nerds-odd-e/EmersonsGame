package com.odde.emersonsgame.service.impl;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.ListRacesService;

import java.util.ArrayList;
import java.util.List;

public class ListRacesServiceImpl implements ListRacesService {
    @Override
    public List<Race> getAllRaces() {
        List<Race> races = new ArrayList<>();
        races.add(new Race());
        races.add(new Race());

        return races;
    }
}
