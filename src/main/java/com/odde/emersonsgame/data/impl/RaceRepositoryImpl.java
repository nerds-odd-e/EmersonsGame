package com.odde.emersonsgame.data.impl;

import com.odde.emersonsgame.data.DataException;
import com.odde.emersonsgame.data.RaceRepository;
import com.odde.emersonsgame.model.Race;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.odde.emersonsgame.data.impl.Connections.getConnection;

public class RaceRepositoryImpl implements RaceRepository {
    @Override
    public List<Race> getAll() {
        String sql = "SELECT id, name, started_at, finished_at FROM races";

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Race> races = new ArrayList<>();

        try {
            c = getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                Date startedAt = rs.getTimestamp("started_at");
                Date finishedAt = rs.getTimestamp("finished_at");

                Race race = new Race(name, startedAt, finishedAt);

                races.add(race);
            }

            return races;
        } catch (SQLException e) {
            throw new DataException(e);
        } finally {
            try {
                rs.close();
                ps.close();
                c.close();
            } catch (SQLException e) {
                throw new DataException(e);
            }
        }
    }
}
