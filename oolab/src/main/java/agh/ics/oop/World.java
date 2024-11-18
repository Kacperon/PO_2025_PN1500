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

        List<MoveDirection> directions = parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        WorldMap map = new GrassField(10);
        //WorldMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation( positions,directions, map);
        simulation.run();

        System.out.println("system zakonczyl dzialanie");
    }
    public static void run(MoveDirection[] args) {
        for (MoveDirection move : args) {
            switch (move) {
                case LEFT -> System.out.println("idzie w lewo");
                case RIGHT -> System.out.println("idzie w prawo");
                case FORWARD -> System.out.println("idzie do przodu");
                case BACKWARD -> System.out.println("idzie do tyłu");
            }
        }
    }
}

