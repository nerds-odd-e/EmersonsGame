package com.odde.emersonsgame.service.impl;

import com.odde.emersonsgame.data.RaceRepository;
import com.odde.emersonsgame.data.impl.RaceRepositoryImpl;
import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.ListRacesService;

import java.util.List;

public class ListRacesServiceImpl implements ListRacesService {
    private RaceRepository raceRepository;

    public ListRacesServiceImpl() {
        raceRepository = new RaceRepositoryImpl();
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.getAll();
    }
}
