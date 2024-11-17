package agh.ics.oop.model;

public interface WorldElement {
    /**
     * Gets the position of the element on the map.
     *
     * @return the position as a Vector2d object
     */
    Vector2d getPosition();

    /**
     * Returns a string representation of the element.
     *
     * @return string representation
     */
    @Override
    String toString();
}
