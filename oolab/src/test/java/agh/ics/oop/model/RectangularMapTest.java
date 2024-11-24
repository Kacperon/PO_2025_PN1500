package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        try {
            map.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Failed to place animal: " + e.getMessage());
        }

        // when & then
        assertTrue(map.canMoveTo(new Vector2d(1, 1))); // unoccupied and within bounds
        assertFalse(map.canMoveTo(new Vector2d(2, 2))); // position occupied by animal
        assertFalse(map.canMoveTo(new Vector2d(-1, 2))); // out of bounds
        assertFalse(map.canMoveTo(new Vector2d(5, 5)));  // out of bounds
    }

    @Test
    void place() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        Animal anotherAnimal = new Animal(new Vector2d(2, 2)); // same position
        Animal newAnimal = new Animal(new Vector2d(3, 3));

        try {
            // when
            assertTrue(map.place(animal)); // first placement succeeds
        } catch (IncorrectPositionException e) {
            fail("Failed to place animal: " + e.getMessage());
        }

        try {
            map.place(anotherAnimal); // attempt to place at an occupied position
            fail("Exception expected for placing anotherAnimal at (2,2).");
        } catch (IncorrectPositionException e) {
            // then
            assertThrows(IncorrectPositionException.class, () -> map.place(anotherAnimal));
        }

        try {
            assertTrue(map.place(newAnimal)); // placement at a different position succeeds
        } catch (IncorrectPositionException e) {
            fail("Failed to place newAnimal: " + e.getMessage());
        }
    }

    @Test
    void move() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        try {
            map.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Failed to place animal: " + e.getMessage());
        }

        // when
        map.move(animal, MoveDirection.FORWARD); // moves north
        map.move(animal, MoveDirection.RIGHT);   // rotates east
        map.move(animal, MoveDirection.FORWARD); // moves east

        // then
        assertEquals(new Vector2d(3, 3), animal.getPosition()); // new position after moves
        assertTrue(map.isOccupied(new Vector2d(3, 3))); // animal's new position occupied
        assertFalse(map.isOccupied(new Vector2d(2, 3))); // old position unoccupied
    }

    @Test
    void isOccupied() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        try {
            map.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Failed to place animal: " + e.getMessage());
        }

        // when & then
        assertFalse(map.isOccupied(new Vector2d(1, 1))); // unoccupied position
        assertTrue(map.isOccupied(new Vector2d(2, 2)));  // occupied by animal
        assertFalse(map.isOccupied(new Vector2d(3, 3))); // unoccupied position
    }

    @Test
    void objectAt() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        try {
            map.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Failed to place animal: " + e.getMessage());
        }

        // when & then
        assertNull(map.objectAt(new Vector2d(1, 1)));       // unoccupied position
        assertEquals(animal, map.objectAt(new Vector2d(2, 2))); // animal found at (2,2)
        assertNull(map.objectAt(new Vector2d(3, 3)));       // unoccupied position
    }

    @Test
    void testToString() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        Animal anotherAnimal = new Animal(new Vector2d(1, 1));

        try {
            map.place(animal);
            map.place(anotherAnimal);
        } catch (IncorrectPositionException e) {
            fail("Failed to place animals: " + e.getMessage());
        }

        // when
        String expectedMap = new MapVisualizer(map).draw(new Vector2d(0, 0), new Vector2d(4, 4));

        // then
        assertEquals(expectedMap, map.toString());
    }
}
