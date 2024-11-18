package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void testSimulationWithMultipleDirections() {
        // Given
        List<Vector2d> initialPositions = Arrays.asList(
                new Vector2d(2, 2),
                new Vector2d(1, 1)
        );
        List<MoveDirection> directions = Arrays.asList(
                MoveDirection.FORWARD,  // Animal 0 move to (2,3)
                MoveDirection.RIGHT,    // Animal 1 turn right to EAST
                MoveDirection.FORWARD,  // Animal 0 move to (2,4)
                MoveDirection.BACKWARD  // Animal 1 move to (0,1)
        );
        Vector2d expectedPositionAnimal1 = new Vector2d(2, 4);
        Vector2d expectedPositionAnimal2 = new Vector2d(0, 1);
        RectangularMap map = new RectangularMap(5,5) ;
        // When
        Simulation simulation = new Simulation(initialPositions, directions,map);
        simulation.run();
        // Then
        List<Animal> animals = simulation.getAnimals();
        assertEquals(expectedPositionAnimal1, animals.get(0).getPosition());
        assertEquals(expectedPositionAnimal2, animals.get(1).getPosition());
    }

    @Test
    void testSimulationWithNoDirections() {
        // Given
        List<Vector2d> initialPositions = Arrays.asList(
                new Vector2d(0, 0),
                new Vector2d(4, 4)
        );
        List<MoveDirection> directions = Arrays.asList(
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD
        );
        RectangularMap map = new RectangularMap(5,5) ;
        // When
        Simulation simulation = new Simulation(initialPositions, directions, map);
        simulation.run();
        // Then
        List<Animal> animals = simulation.getAnimals();
        assertEquals(new Vector2d(0, 0), animals.get(0).getPosition());
        assertEquals(new Vector2d(4, 4), animals.get(1).getPosition());
    }

    @Test
    void testSimulationWithStringInput() {
        // Given
        String input = "f b r l f f r r f f f f f f f f";
        String[] args = input.split(" ");
        RectangularMap map = new RectangularMap(5,5) ;
        // Expected
        List<MoveDirection> expectedDirections = Arrays.asList(
                MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD
        );

        // When
        List<MoveDirection> directions = OptionsParser.parse(args);

        assertEquals(expectedDirections, directions);


        List<Vector2d> positions = Arrays.asList(
                new Vector2d(2, 2),  //0 animal
                new Vector2d(3, 4)   //1 animal
        );

        Simulation simulation = new Simulation(positions, directions,map);

        simulation.run();

        Vector2d expectedPositionAnimal1 = new Vector2d(2, 0);
        Vector2d expectedPositionAnimal2 = new Vector2d(3, 4);


        List<Animal> animals = simulation.getAnimals();
        //then
        assertEquals(expectedPositionAnimal1, animals.get(0).getPosition());
        assertEquals(expectedPositionAnimal2, animals.get(1).getPosition());
    }




}