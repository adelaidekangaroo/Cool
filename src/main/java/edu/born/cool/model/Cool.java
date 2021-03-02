package edu.born.cool.model;

public class Cool {
    private int id;
    private int amount;

    public Cool(int amount) {
        this.amount = amount;
    }

    public Cool(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}