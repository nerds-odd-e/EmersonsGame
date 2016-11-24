package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.CreateRaceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateRaceControllerTest {
    private CreateRaceController controller;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private CreateRaceService createRaceService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new CreateRaceController();
        controller.setCreateRaceService(createRaceService);
    }

    @Test
    public void CreateRaceMustRedirectToListRaces() throws ServletException, IOException {
        when(request.getAttribute(CreateRaceController.NAME)).thenReturn("New Race");
        when(createRaceService.createRace(any(Race.class))).thenReturn(new Race());

        controller.doPost(request, response);

        assertThatControllerRedirectedToRacesPage();
        assertThatRaceCreatedHasAttributes("New Race");
    }

    private void assertThatControllerRedirectedToRacesPage() throws IOException {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(response).sendRedirect(captor.capture());

        assertThat(captor.getValue(), is("/races"));
    }

    private void assertThatRaceCreatedHasAttributes(String name) {
        ArgumentCaptor<Race> captor = ArgumentCaptor.forClass(Race.class);

        verify(createRaceService).createRace(captor.capture());

        assertThat(captor.getValue().getName(), is(name));
    }
}
