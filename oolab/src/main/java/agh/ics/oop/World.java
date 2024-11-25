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

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartowal");
        ConsoleMapDisplay obs = new ConsoleMapDisplay();
        try {
            List<MoveDirection> directions = parse(args);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            AbstractWorldMap map = new GrassField(10);
            // AbstractWorldMap map = new RectangularMap(5, 5);
            map.addObservers(obs);
            Simulation simulation = new Simulation( positions,directions, map);
            simulation.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("system zakonczyl dzialanie");
    }

}

