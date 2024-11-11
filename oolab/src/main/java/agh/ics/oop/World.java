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

public class World {
    public static void main(String[] args) {

        // TextMap
        List<String> texts = List.of("Ala", "ma", "sowoniedzwiedzia");
        WorldMap<String, Integer> textMap = new TextMap();
        List<MoveDirection> directions = List.of(
                MoveDirection.FORWARD,MoveDirection.FORWARD, MoveDirection.BACKWARD
        );
        Simulation<String,Integer> simulation = new Simulation<>(texts,directions,textMap);
        simulation.run();

    }
}

