package com.odde.emersonsgame.service.impl;

import com.odde.emersonsgame.data.RaceRepository;
import com.odde.emersonsgame.data.impl.RaceRepositoryImpl;
import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.CreateRaceService;

public class CreateRaceServiceImpl implements CreateRaceService {
    private RaceRepository raceRepository;

    public CreateRaceServiceImpl() {
        this(new RaceRepositoryImpl());
    }

    public CreateRaceServiceImpl(final RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Race createRace(final Race race) {
        return raceRepository.create(race);
    }
}
