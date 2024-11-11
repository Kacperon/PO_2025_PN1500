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
        map.place(animal);

        // when & then
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));  // occupied by animal
        assertFalse(map.canMoveTo(new Vector2d(-1, 2))); // out of bounds
        assertFalse(map.canMoveTo(new Vector2d(5, 5)));  // out of bounds
    }

    @Test
    void place() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        Animal anotherAnimal = new Animal(new Vector2d(2, 2));  // same position
        Animal newAnimal = new Animal(new Vector2d(3, 3));

        // when & then
        assertTrue(map.place(animal));
        assertFalse(map.place(anotherAnimal));  // already occupied
        assertTrue(map.place(newAnimal));       // different position
    }

    @Test
    void move() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        map.place(animal);

        // when
        map.move(animal, MoveDirection.FORWARD);  // moves north
        map.move(animal, MoveDirection.RIGHT);
        map.move(animal, MoveDirection.FORWARD);  // moves east

        // then
        assertEquals(new Vector2d(3, 3), animal.getPosition());
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
        assertFalse(map.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    void isOccupied() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        map.place(animal);

        // when & then
        assertFalse(map.isOccupied(new Vector2d(1, 1))); // empty position
        assertTrue(map.isOccupied(new Vector2d(2, 2)));  // occupied by animal
        assertFalse(map.isOccupied(new Vector2d(3, 3))); // empty position
    }

    @Test
    void objectAt() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        map.place(animal);

        // when & then
        assertNull(map.objectAt(new Vector2d(1, 1)));       // empty position
        assertEquals(animal, map.objectAt(new Vector2d(2, 2))); // animal at (2,2)
        assertNull(map.objectAt(new Vector2d(3, 3)));       // empty position
    }

    @Test
    void testToString() {
        // given
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        Animal anotherAnimal = new Animal(new Vector2d(1, 1));
        map.place(animal);
        map.place(anotherAnimal);

        // when
        String expectedMap = new MapVisualizer(map).draw(new Vector2d(0, 0), new Vector2d(4, 4));

        // then
        assertEquals(expectedMap, map.toString());
    }
}
