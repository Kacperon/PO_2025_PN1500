//package agh.ics.oop;
//
//public class World {
//    public static void main(String[] args) {
//        System.out.println("system wystartował");
//        run(args);
//        System.out.println("system zakończył działanie");
//    }
//    public static void run(String[] args) {
//        System.out.println("idzie");
//        for (String arg : args) {
//            switch (arg) {
//                case "f":
//                    System.out.println("Zwierzak idzie do przodu");
//                    break;
//                case "b":
//                    System.out.println("Zwierzak idzie do tyłu");
//                    break;
//                case "r":
//                    System.out.println("Zwierzak skręca w prawo");
//                    break;
//                case "l":
//                    System.out.println("Zwierzak skręca w lewo");
//                    break;
//                default:
//                    // Ignorowanie innych argumentów
//                    break;
//            }
//        }
//        System.out.println("Stop");
//    }
//}

package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartowal");
        ConsoleMapDisplay obs = new ConsoleMapDisplay();

        ConsoleMapDisplay obs2 = new ConsoleMapDisplay();
        try {
            List<MoveDirection> directions = parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            AbstractWorldMap map1 = new GrassField(10);
            AbstractWorldMap map2 = new RectangularMap(5, 5);
            map1.addObservers(obs);
            map2.addObservers(obs2);
            Simulation simulation1 = new Simulation( positions, directions,map1);
            Simulation simulation2 = new Simulation(positions, directions, map2);
            SimulationEngine engine = new SimulationEngine(List.of(simulation1, simulation2));
            //engine.runSync();
            engine.runAsync();
            //engine.runAsyncInThreadPool();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("system zakonczyl dzialanie");
    }

//    public static void main(String[] args) {
//        System.out.println("system wystartowal");
//
//        final int simulationCount = 1000;
//
//        try {
//
//            List<MoveDirection> directions = parse(args);
//            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
//            List<Simulation> simulations = new ArrayList<>();
//            for (int i = 0; i < simulationCount; i++) {
//                AbstractWorldMap map = (i % 2 == 0)
//                        ? new GrassField(10)
//                        : new RectangularMap(5, 5);
//
//                ConsoleMapDisplay observer = new ConsoleMapDisplay();
//                map.addObservers(observer);
//                Simulation simulation = new Simulation(positions, directions, map);
//                simulations.add(simulation);
//            }
//            SimulationEngine engine = new SimulationEngine(simulations);
//            engine.runAsync();
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//            return;
//        }
//        System.out.println("system zakonczyl dzialanie");
//    }




}

