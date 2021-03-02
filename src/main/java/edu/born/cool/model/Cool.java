package edu.born.cool.model;

public class Cool {
    private int id;
    private float amount;

    public Cool(float amount) {
        this.amount = amount;
    }

    public Cool(int id, float amount) {
        this.id = id;
        this.amount = amount;
    }
}