package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private  final List<MoveDirection> listDirection;
    private final List<Animal> listAnimals= new ArrayList<>();

    public List<Animal> getAnimals() {
        return listAnimals;
    }
    public Simulation(List<Vector2d> listPosition,List<MoveDirection> listDirection) {
        this.listDirection = listDirection;
        for (int i = 0; i < listPosition.size(); i++) {
            listAnimals.add(new Animal(listPosition.get(i)));
        }
    }
    public void run(){
        for (int i = 0; i < listDirection.size(); i++) {
            Animal animal = listAnimals.get(i%listAnimals.size());
            animal.move(listDirection.get(i));
            System.out.println("Zwierze " + i%listAnimals.size() + ":" + animal.toString());

        }
    }


}
