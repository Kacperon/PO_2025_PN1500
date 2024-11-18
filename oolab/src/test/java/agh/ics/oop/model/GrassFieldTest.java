package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));
        grassField.place(animal);

        // when & then
        assertTrue(grassField.canMoveTo(new Vector2d(1, 1)));
        assertFalse(grassField.canMoveTo(new Vector2d(2, 2)));  // occupied by animal
        assertTrue(grassField.canMoveTo(new Vector2d(5, 5)));   // empty and within bounds
    }

    @Test
    void placeAnimal() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 2));

        // when & then
        assertTrue(grassField.place(animal1)); // placement succeeds
        assertFalse(grassField.place(animal2)); // placement fails (position occupied)
    }

    @Test
    void objectAt() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(3, 3));
        grassField.place(animal);

        // when & then
        assertEquals(animal, grassField.objectAt(new Vector2d(3, 3))); // animal found
        assertNull(grassField.objectAt(new Vector2d(5, 5))); // no object at position
    }

    @Test
    void isOccupied() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(4, 4));
        grassField.place(animal);

        // when & then
        assertTrue(grassField.isOccupied(new Vector2d(4, 4))); // occupied by animal
        assertFalse(grassField.isOccupied(new Vector2d(0, 0))); // empty
    }

    @Test
    void getElements() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(1, 1));
        grassField.place(animal);

        // when
        var elements = grassField.getElements();

        // then
        assertTrue(elements.contains(animal));
        assertTrue(elements.size() > 10); // animals + grass elements
    }
}