package edu.born.cool.repository;

import edu.born.cool.model.Cool;

import java.util.List;

public interface CoolRepository {
    void create(Cool cool);

    boolean update(Cool cool);

    boolean delete(int id);

    Cool getById(int id);

    List<Cool> getAll();
}
