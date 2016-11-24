package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Race;
import com.odde.emersonsgame.service.ListRacesService;
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

    private ListRacesService listRacesService;

    public RacesController() {
        listRacesService = new ListRacesServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Race> races = listRacesService.getAllRaces();

        req.setAttribute(RACES, races);

        req.getRequestDispatcher("pages/races/index.jsp").forward(req, resp);
    }

    void setListRacesService(ListRacesService listRacesService) {
        this.listRacesService = listRacesService;
    }
}
