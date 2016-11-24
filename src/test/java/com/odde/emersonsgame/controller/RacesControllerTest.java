package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.CreateRaceService;
import com.odde.emersonsgame.service.ListRacesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.odde.emersonsgame.controller.RacesController.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RacesControllerTest {
    private RacesController controller;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private ListRacesService listRacesService;

    @Mock
    private CreateRaceService createRaceService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new RacesController();
        controller.setListRacesService(listRacesService);
        controller.setCreateRaceService(createRaceService);

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        when(request.getContextPath()).thenReturn("http://localhost:8080/EmersonsGame");
    }

    @Test
    public void ListRacesMustBeEmptyIfNoRaces() throws ServletException, IOException {
        controller.doGet(request, response);

        assertThatControllerForwardedToIndexPage();
        assertThatRacesAttributeContains(Collections.emptyList());
    }

    @Test
    public void ListRacesMustShowAllRaces() throws ServletException, IOException {
        List<Race> races = new ArrayList<>();
        races.add(new Race());
        races.add(new Race());

        when(listRacesService.getAllRaces()).thenReturn(races);

        controller.doGet(request, response);

        assertThatControllerForwardedToIndexPage();
        assertThatRacesAttributeContains(races);
    }

    @Test
    public void CreateRaceMustRedirectToListRaces() throws ServletException, IOException {
        when(request.getParameter(NAME)).thenReturn("New Race");
        when(createRaceService.createRace(any(Race.class))).thenReturn(new Race());

        controller.doPost(request, response);

        assertThatControllerRedirectedToRacesPage();
        assertThatRaceCreatedHasAttributes("New Race");
    }

    private void assertThatControllerForwardedToIndexPage() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(request).getRequestDispatcher(captor.capture());

        assertThat(captor.getValue(), is("/WEB-INF/pages/races/index.jsp"));
    }

    private void assertThatRacesAttributeContains(final List<Race> races) {
        ArgumentCaptor<String> keyCaptor = ArgumentCaptor.forClass(String.class);

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<Race>> valueCaptor = ArgumentCaptor.forClass((Class) List.class);

        verify(request).setAttribute(keyCaptor.capture(), valueCaptor.capture());

        assertThat(keyCaptor.getValue(), is(RACES));
        assertThat(valueCaptor.getValue(), is(races));
    }

    private void assertThatControllerRedirectedToRacesPage() throws IOException {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(response).sendRedirect(captor.capture());

        assertThat(captor.getValue(), is("http://localhost:8080/EmersonsGame/races"));
    }

    private void assertThatRaceCreatedHasAttributes(final String name) {
        ArgumentCaptor<Race> captor = ArgumentCaptor.forClass(Race.class);

        verify(createRaceService).createRace(captor.capture());

        assertThat(captor.getValue().getName(), is(name));
    }
}
