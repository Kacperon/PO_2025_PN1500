package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private  final List<MoveDirection> listDirection;
    private final List<Animal> listAnimals= new ArrayList<>();
    private WorldMap map;

    public List<Animal> getAnimals() {
        return listAnimals;
    }
    public Simulation(List<Vector2d> listPosition,List<MoveDirection> listDirection,WorldMap map) {

        this.listDirection = listDirection;
        this.map = map;
        for (Vector2d position : listPosition) {
            try {
                Animal newAnimal = new Animal(position);
                if (this.map.place(newAnimal)) listAnimals.add(newAnimal);
            }
            catch (IncorrectPositionException e) {
                System.out.println("Invalid position"+ e.getMessage());
            }
        }
    }
    public void run(){
        System.out.println(map);
        for (int i = 0; i < listDirection.size(); i++) {
            int animal_i = i% listAnimals.size();
            map.move(listAnimals.get(animal_i),listDirection.get(i));
        }
    }


}
