package agh.ics.oop;


import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] fun(String[] args) {
        MoveDirection[] moves = new MoveDirection[args.length];
        int vart = 0;
        for (int i = 0; i < args.length; i++) {
            MoveDirection to_i = switch (args[i]){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> null;
            };
            if (to_i != null) {
                moves[vart] = to_i;
                vart++;
            }
        }
        return Arrays.copyOfRange(moves, 0, vart);
    }
}
