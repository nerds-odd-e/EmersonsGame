package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Race;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListRacesControllerTest {
    private ListRacesController controller;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private ListRacesService listRacesService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new ListRacesController();
        controller.setListRacesService(listRacesService);

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
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

    private void assertThatControllerForwardedToIndexPage() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(request).getRequestDispatcher(captor.capture());

        assertThat(captor.getValue(), is("pages/races/index.jsp"));
    }

    private void assertThatRacesAttributeContains(List<Race> races) {
        ArgumentCaptor<String> keyCaptor = ArgumentCaptor.forClass(String.class);

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<Race>> valueCaptor = ArgumentCaptor.forClass((Class) List.class);

        verify(request).setAttribute(keyCaptor.capture(), valueCaptor.capture());

        assertThat(keyCaptor.getValue(), is(ListRacesController.RACES));
        assertThat(valueCaptor.getValue(), is(races));
    }
}
