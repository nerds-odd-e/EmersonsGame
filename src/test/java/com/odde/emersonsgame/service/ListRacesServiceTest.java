package com.odde.emersonsgame.service;

import com.odde.emersonsgame.data.RaceRepository;
import com.odde.emersonsgame.service.impl.ListRacesServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ListRacesServiceTest {
    private ListRacesService service;

    @Mock
    private RaceRepository raceRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ListRacesServiceImpl service = new ListRacesServiceImpl();
        service.setRaceRepository(raceRepository);

        this.service = service;
    }

    @Test
    public void GetAllRacesMustReturnAllRaces() {
        service.getAllRaces();

        verify(raceRepository).getAll();
    }
}
