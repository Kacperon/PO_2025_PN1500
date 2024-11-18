package agh.ics.oop.model;

public class Grass implements WorldElement {

    private Vector2d position;
    static final String s = "*";

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return s;
    }
}
