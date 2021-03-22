package edu.born.cool.repository;

public class Queries {

    public static final String INSERT = "INSERT INTO cool (amount) VALUES (?)";
    public static final String UPDATE = "UPDATE cool SET amount = ? WHERE id = ?";
    public static final String GET_BY_ID = "SELECT id, amount FROM cool WHERE id = ?";
    public static final String GET_ALL = "SELECT * FROM cool ORDER BY amount ASC";
    public static final String DELETE = "DELETE FROM cool WHERE id = ?";

    private Queries() {
    }
}
