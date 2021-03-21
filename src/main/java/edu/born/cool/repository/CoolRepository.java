package edu.born.cool.repository;

import edu.born.cool.model.Cool;

import java.util.List;

public interface CoolRepository {
    boolean save(Cool cool);
    boolean delete(int id);
    Cool getById(int id);
    List<Cool> getAll();
}
