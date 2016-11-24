package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.CreateRaceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateRaceController extends HttpServlet {
    static final String NAME = "name";

    private CreateRaceService createRaceService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getAttribute(NAME);

        createRaceService.createRace(new Race(name));

        resp.sendRedirect("/races");
    }

    public void setCreateRaceService(CreateRaceService createRaceService) {
        this.createRaceService = createRaceService;
    }
}
