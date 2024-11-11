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

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {
    public static void main(String[] args) {

        RectangularMap map = new RectangularMap(5,5) ;
        List<MoveDirection> directions = OptionsParser.fun(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions,map);
        simulation.run();

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

