package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

public class OptionsParser {
//    public static MoveDirection[] fun(String[] args) {
//        MoveDirection[] moves = new MoveDirection[args.length];
//        int vart = 0;
//        for (int i = 0; i < args.length; i++) {
//            MoveDirection to_i = switch (args[i]){
//                case "f" -> MoveDirection.FORWARD;
//                case "b" -> MoveDirection.BACKWARD;
//                case "r" -> MoveDirection.RIGHT;
//                case "l" -> MoveDirection.LEFT;
//                default -> null;
//            };
//            if (to_i != null) {
//                moves[vart] = to_i;
//                vart++;
//            }
//        }
//        return Arrays.copyOfRange(moves, 0, vart);
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "r" -> moves.add(MoveDirection.RIGHT);
                case "l" -> moves.add(MoveDirection.LEFT);
            }
        }
        return moves;
    }
}
