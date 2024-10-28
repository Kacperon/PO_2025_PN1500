package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class Animal {

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
    public Animal(Vector2d position) {
        this.position = position;
    }

    public String toString() {
        //return "Animal [direction=" + direction + ", position=" + position + "]";
        return "("+ position.getX() + "," + position.getY() + ")";
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move (MoveDirection direction){
        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> this.position = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> this.position = this.position.subtract(this.direction.toUnitVector());
        }
        this.position = this.position.upperRight(new Vector2d(0,0));
        this.position = this.position.lowerLeft(new Vector2d(4,4));
    }



}
