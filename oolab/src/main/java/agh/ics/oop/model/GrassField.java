package agh.ics.oop.model;

import agh.ics.oop.model.util.UniqueRandomPositionsGenerator;

import java.util.*;


public class GrassField extends AbstractWorldMap{


    private final Map<Vector2d, Grass> grasses;
    private final int grassNumber;
    private final int size;

//    public GrassField(int grassNumber) {
//        this.grasses = new HashMap<>();
//        this.grassNumber = grassNumber;
//        this.size= (int) Math.sqrt(10 * this.grassNumber);
//        Random random = new Random();
//        int i=0;
//        while (i < this.grassNumber) {
//            int x = random.nextInt((int) Math.sqrt(10 * this.grassNumber));
//            int y = random.nextInt((int) Math.sqrt(10 * this.grassNumber));
//
//            boolean flag = false;
//            for (Vector2d position: grasses.keySet()) {
//                if (Objects.equals(position, new Vector2d(x, y))) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                this.grasses.put(new Vector2d(x,y), new Grass(new Vector2d(x, y)));
//                i++;
//            }
//        }
//    }
public GrassField(int grassNumber) {
    this.grasses = new HashMap<>();
    this.grassNumber = grassNumber;
    this.size = (int) Math.sqrt(10 * this.grassNumber);

    // Użyj UniqueRandomPositionsGenerator
    UniqueRandomPositionsGenerator generator = new UniqueRandomPositionsGenerator(size, grassNumber);

    for (Vector2d position : generator) {
        this.grasses.put(position, new Grass(position));
    }
}

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement object = super.objectAt(position);
        if(object != null) return object;
        return grasses.get(position);
    }

    @Override
    public String toString() {
        Vector2d bottom = new Vector2d(upperRight.getX(), upperRight.getY());
        Vector2d top = new Vector2d(lowerLeft.getX(), lowerLeft.getY());
        List<WorldElement> elements = getElements();
        for (WorldElement element: elements) {
            bottom = bottom.lowerLeft(element.getPosition());
            top = top.upperRight(element.getPosition());
        }
        return visualizer.draw(bottom, top);
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }
    public Vector2d getUpperRight() {
        return upperRight;
    }
    public Vector2d getLowerLeft() {
        return lowerLeft;
    }
}
