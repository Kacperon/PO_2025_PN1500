package agh.ics.oop.model;

public class Animal implements WorldElement {

    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;


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
        return this.direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move (MoveDirection direction, AbstractWorldMap map) {
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (map.canMoveTo(newPosition)) this.position = newPosition;
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (map.canMoveTo(newPosition)) this.position = newPosition;
            }
        }
    }


    public Vector2d getCoordinates() {
        return this.position;
    }


}
