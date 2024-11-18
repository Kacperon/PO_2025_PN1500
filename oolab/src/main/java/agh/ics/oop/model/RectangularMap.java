package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    public RectangularMap(int width, int height){
        lowerLeft = new Vector2d(0,0);
        upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.follows(lowerLeft) && position.precedes(upperRight);
    }

    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }
    public Vector2d getLowerLeft() {
        return lowerLeft;
    }
    public Vector2d getUpperRight() {
        return upperRight;
    }
}