package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));

        try {
            grassField.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Placement failed: " + e.getMessage());
        }

        // when & then
        assertTrue(grassField.canMoveTo(new Vector2d(1, 1))); // unoccupied
        assertFalse(grassField.canMoveTo(new Vector2d(2, 2))); // occupied by animal
        assertTrue(grassField.canMoveTo(new Vector2d(5, 5))); // unoccupied and within bounds
    }

    @Test
    void placeAnimal() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 2));

        try {
            // when
            assertTrue(grassField.place(animal1)); // placement succeeds
        } catch (IncorrectPositionException e) {
            fail("Failed to place animal1: " + e.getMessage());
        }

        try {
            grassField.place(animal2); // placement should fail
            fail("Exception expected for placing animal2 at the same position as animal1.");
        } catch (IncorrectPositionException e) {
            // then
            assertThrows(IncorrectPositionException.class, () -> grassField.place(animal2));
        }
    }

    @Test
    void objectAt() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(3, 3));

        try {
            grassField.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Placement failed: " + e.getMessage());
        }

        // when & then
        assertEquals(animal, grassField.objectAt(new Vector2d(3, 3))); // animal found
        assertNull(grassField.objectAt(new Vector2d(5, 5))); // no object at position
    }

    @Test
    void isOccupied() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(4, 4));

        try {
            grassField.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Placement failed: " + e.getMessage());
        }

        // when & then
        assertTrue(grassField.isOccupied(new Vector2d(4, 4))); // occupied by animal
        assertFalse(grassField.isOccupied(new Vector2d(0, 0))); // unoccupied
    }

    @Test
    void getElements() {
        // given
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(1, 1));

        try {
            grassField.place(animal);
        } catch (IncorrectPositionException e) {
            fail("Placement failed: " + e.getMessage());
        }

        // when
        var elements = grassField.getElements();

        // then
        assertTrue(elements.contains(animal)); // animal is present
        assertTrue(elements.size() > 10); // includes animals + grass
    }
}
