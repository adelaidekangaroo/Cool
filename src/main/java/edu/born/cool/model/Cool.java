package edu.born.cool.model;

import java.util.Objects;

public class Cool implements Exist {

    private Integer id;
    private int amount;

    public Cool(int amount) {
        this.amount = amount;
    }

    public Cool(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Cool cool = (Cool) other;
        return amount == cool.amount &&
                Objects.equals(id, cool.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}