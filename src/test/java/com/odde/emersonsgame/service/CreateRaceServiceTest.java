package com.odde.emersonsgame.service;

import com.odde.emersonsgame.data.RaceRepository;
import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.impl.CreateRaceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateRaceServiceTest {
    private CreateRaceService service;

    @Mock
    private RaceRepository raceRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        service = new CreateRaceServiceImpl(raceRepository);
    }

    @Test
    public void CreateRaceMustSaveNewRace() {
        when(raceRepository.create(any(Race.class))).thenReturn(new Race());

        Race race = new Race("New Race");

        Race savedRace = service.createRace(race);

        assertThat(savedRace, notNullValue());
        assertThatRaceCreatedHasAttributes("New Race");
    }

    private void assertThatRaceCreatedHasAttributes(String name) {
        ArgumentCaptor<Race> captor = ArgumentCaptor.forClass(Race.class);

        verify(raceRepository).create(captor.capture());

        assertThat(captor.getValue().getName(), is(name));
    }
}
