package com.odde.emersonsgame.data;

import com.odde.emersonsgame.data.impl.RaceRepositoryImpl;
import com.odde.emersonsgame.model.Race;
import org.dbunit.IDatabaseTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static com.odde.emersonsgame.data.support.Databases.getDataSet;
import static com.odde.emersonsgame.data.support.Databases.getDatabaseTester;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RaceRepositoryTest {
    private IDatabaseTester databaseTester;
    private RaceRepository repository;

    @Before
    public void setUp() throws Exception {
        databaseTester = getDatabaseTester();
        databaseTester.setDataSet(getDataSet("RaceRepositoryTest.xml"));
        databaseTester.onSetup();

        repository = new RaceRepositoryImpl();
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void GetAllMustReturnAllRaces() {
        List<Race> result = repository.getAll();

        assertThat(result, notNullValue());
        assertThat(result.size(), is(3));
    }

    @Test
    public void CreateMustCreateNewRace() {
        Date currentTimestamp = new Date();

        Race race = new Race(null, "Race", currentTimestamp, null);

        Race savedRace = repository.create(race);

        assertThat(savedRace, notNullValue());
        assertThat(savedRace.getId(), notNullValue());
        assertThat(savedRace.getName(), is("Race"));
        assertThat(savedRace.getStartedAt(), is(currentTimestamp));
    }
}
