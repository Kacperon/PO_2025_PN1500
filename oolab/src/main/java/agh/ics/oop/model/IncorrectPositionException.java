package agh.ics.oop.model;

public class IncorrectPositionException extends Exception {

    private final Vector2d vector;

    public IncorrectPositionException(Vector2d vector) {
        super("position " + vector.toString() + " is not correct");
        this.vector = vector;
    }

    public Vector2d getPosition() {
        return this.vector;
    }


}
