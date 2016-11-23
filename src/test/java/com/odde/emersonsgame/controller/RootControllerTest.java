package com.odde.emersonsgame.controller;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RootControllerTest {
    private RootController controller;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new RootController();
    }

    @Test
    public void ResponseMustOutputHelloWorld() throws ServletException, IOException {
        when(request.getContextPath()).thenReturn("http://localhost:8080/EmersonsGame");

        controller.doGet(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(response).sendRedirect(captor.capture());

        assertThat(captor.getValue(), is("http://localhost:8080/EmersonsGame/races"));
    }
}
