package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {

    protected Vector2d lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    protected final List<MapChangeListener> listeners = new ArrayList<>();


    public void addObservers(MapChangeListener listener) {
        listeners.add(listener);
    }

    public void removeObservers(MapChangeListener listener) {
        listeners.remove(listener);
    }

    protected void notifyObservers(String message) {
        for (MapChangeListener observer : listeners) {
            observer.mapChanged(this, message);
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) throws IncorrectPositionException{
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            notifyObservers("Animal placed at " + animal.getPosition());
            return true;
        }
        throw new IncorrectPositionException(animal.getPosition());
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getPosition(), animal);
        notifyObservers("Animal moved from " + oldPosition + " to " + animal.getPosition());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(animals.get(position) != null) return animals.get(position);
        return null;
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public Boundary getCurrentBounds(){
        return new Boundary(lowerLeft,upperRight);
    }
    @Override
    public String toString(){
        return visualizer.draw(getCurrentBounds().lowerLeft(),getCurrentBounds().upperRight());
    }


}
