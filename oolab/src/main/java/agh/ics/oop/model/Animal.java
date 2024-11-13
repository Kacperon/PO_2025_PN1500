package agh.ics.oop.model;

public class Animal {

    private MapDirection direction = MapDirection.NORTH;

    private Vector2d position;

    private final Vector2d lowerBound = new Vector2d(0, 0);
    private final Vector2d upperBound = new Vector2d(4, 4);

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    public Animal() {
        this.position = new Vector2d(2,2);
    }
    public Animal(Vector2d position){
        this.direction = direction;
        this.position = position;
    }

    @Override
    public String toString() {
        //return "Animal [direction=" + direction + ", position=" + position + "]";
        return this.direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move (MoveDirection direction, RectangularMap validator) {
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (validator.canMoveTo(newPosition)) this.position = newPosition;
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (validator.canMoveTo(newPosition)) this.position = newPosition;
            }
        }
        this.position = this.position.upperRight(lowerBound);
        this.position = this.position.lowerLeft(upperBound);
    }


    public Vector2d getCoordinates() {
        return this.position;
    }


}
