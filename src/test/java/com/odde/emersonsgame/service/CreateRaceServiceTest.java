package com.odde.emersonsgame.service;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.impl.CreateRaceServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class CreateRaceServiceTest {
    private CreateRaceService service;

    @Before
    public void setUp() {
        service = new CreateRaceServiceImpl();
    }

    @Test
    public void CreateRaceMustSaveNewRace() {
        Race race = new Race("New Race");

        Race savedRace = service.createRace(race);

        assertThat(savedRace, notNullValue());
    }
}
