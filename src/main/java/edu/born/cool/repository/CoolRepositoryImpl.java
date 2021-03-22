package edu.born.cool.repository;

import edu.born.cool.model.Cool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.born.cool.repository.DbConfig.getConnection;
import static edu.born.cool.repository.Queries.*;
import static java.util.Objects.requireNonNull;

public class CoolRepositoryImpl implements CoolRepository {

    @Override
    public void create(Cool cool) {

        try (var connection = getConnection();
             var statement = connection.prepareStatement(INSERT)) {

            statement.setInt(1, cool.getAmount());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Cool cool) {

        try (var connection = getConnection();
             var statement = connection.prepareStatement(UPDATE)) {

            statement.setInt(1, cool.getAmount());
            statement.setInt(2, cool.getId());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {

        try (var connection = getConnection();
             var statement = connection.prepareStatement(DELETE)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cool getById(int id) {

        Cool cool = null;

        try (var connection = getConnection();
             var statement = connection.prepareStatement(GET_BY_ID)) {

            statement.setInt(1, id);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cool = new Cool(
                        id,
                        resultSet.getInt("amount")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requireNonNull(cool);
    }

    @Override
    public List<Cool> getAll() {

        var results = new ArrayList<Cool>();

        try (var connection = getConnection();
             var statement = connection.prepareStatement(GET_ALL)) {

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                results.add(new Cool(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}