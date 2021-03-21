package edu.born.cool.model;

public interface Exist {

    Integer getId();

    default boolean isNew() {
        return getId() == null;
    }
}
