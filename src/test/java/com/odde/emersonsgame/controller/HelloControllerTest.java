package com.odde.emersonsgame.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HelloControllerTest {
    private HelloController controller;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ServletOutputStream outputStream;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new HelloController();
    }

    @Test
    public void ResponseMustOutputHelloWorld() throws ServletException, IOException {
        when(response.getOutputStream()).thenReturn(outputStream);

        controller.doGet(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(outputStream).print(captor.capture());

        assertThat(captor.getValue(), is("Hello, world!"));
    }
}
