package edu.born.cool.model;

import java.util.Objects;

public class Cool {

    private Integer id;
    private final Integer amount;

    public Cool(int amount) {
        this.amount = amount;
    }

    public Cool(Integer id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Cool cool = (Cool) other;
        return Objects.equals(amount, cool.amount) && Objects.equals(id, cool.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}