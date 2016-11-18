package com.odde.emersonsgame.controller;

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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new ListRacesController();

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void ListRacesMustBeEmptyIfNoRaces() throws ServletException, IOException {
        controller.doGet(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(request).getRequestDispatcher(captor.capture());

        assertThat(captor.getValue(), is("pages/races/index.jsp"));
    }
}
