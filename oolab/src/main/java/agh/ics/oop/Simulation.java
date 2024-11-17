package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

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
            Animal newAnimal = new Animal(position);
            if (this.map.place(newAnimal)) listAnimals.add(newAnimal);

        }
    }
    public void run(){
        System.out.println(map);
        for (int i = 0; i < listDirection.size(); i++) {
            int animal_i = i% listAnimals.size();
            map.move(listAnimals.get(animal_i),listDirection.get(i));
            System.out.println(map);

        }
    }


}
