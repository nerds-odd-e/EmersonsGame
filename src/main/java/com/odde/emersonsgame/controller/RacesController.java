package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.CreateRaceService;
import com.odde.emersonsgame.service.ListRacesService;
import com.odde.emersonsgame.service.impl.CreateRaceServiceImpl;
import com.odde.emersonsgame.service.impl.ListRacesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/races")
public class RacesController extends HttpServlet {
    static final String RACES = "races";
    static final String NAME = "name";

    private ListRacesService listRacesService;
    private CreateRaceService createRaceService;

    public RacesController() {
        listRacesService = new ListRacesServiceImpl();
        createRaceService = new CreateRaceServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Race> races = listRacesService.getAllRaces();

        req.setAttribute(RACES, races);

        req.getRequestDispatcher("/WEB-INF/pages/races/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME);

        createRaceService.createRace(new Race(name));

        resp.sendRedirect(req.getContextPath() + "/races");
    }

    void setListRacesService(ListRacesService listRacesService) {
        this.listRacesService = listRacesService;
    }

    void setCreateRaceService(CreateRaceService createRaceService) {
        this.createRaceService = createRaceService;
    }
}
