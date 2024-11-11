package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation<T,P> {

    private  final List<MoveDirection> listDirection;
    private final List<T> listAnimals;
    private WorldMap<T,P> map;


    public Simulation(List<T> listAnimals,List<MoveDirection> listDirection,WorldMap<T,P> map) {
        this.listDirection = listDirection;
        this.map = map;
        for (int i = 0; i < listDirection.size(); i++) {
            map.place(listAnimals.get(i));
        }
        this.listAnimals= listAnimals;
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
