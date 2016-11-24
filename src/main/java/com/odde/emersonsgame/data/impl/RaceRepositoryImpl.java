package com.odde.emersonsgame.data.impl;

import com.odde.emersonsgame.data.DataException;
import com.odde.emersonsgame.data.RaceRepository;
import com.odde.emersonsgame.model.Race;

import java.sql.*;
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
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Date startedAt = rs.getTimestamp("started_at");
                Date finishedAt = rs.getTimestamp("finished_at");

                Race race = new Race(id, name, startedAt, finishedAt);

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

    @Override
    public Race create(Race race) {
        String sql = "INSERT INTO races (name, started_at) VALUES (?, ?)";

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = getConnection();

            ps = c.prepareStatement(sql);
            ps.setString(1, race.getName());
            ps.setTimestamp(2, new Timestamp(race.getStartedAt().getTime()));

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                Long id = rs.getLong(1);

                return new Race(id, race);
            } else {
                throw new DataException();
            }
        } catch (SQLException e) {
            throw new DataException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }

                c.close();
            } catch (SQLException e) {
                throw new DataException(e);
            }
        }
    }
}
