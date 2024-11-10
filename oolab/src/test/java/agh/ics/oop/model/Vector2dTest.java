package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void equalsTwoVectors() {
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        //then
        assertTrue(v1.equals(v2));
    }

    @Test
    void notEqualsTwoVectors() {
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,3);
        //then
        assertFalse(v1.equals(v2));
    }

    @Test
    void toStringCheck() {
        //when
        Vector2d v1 = new Vector2d(1,2);
        //then
        assertEquals("(1,2)", v1.toString());
    }

    @Test
    void precedenceCheck() {
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,3);
        //then
        assertTrue(v1.precedes(v2));
    }

    @Test
    void notPrecedenceCheck() {
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,3);
        //then
        assertFalse(v1.precedes(v2));
    }

    @Test
    void followsCheck(){
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,2);
        //then
        assertTrue(v1.follows(v2));
    }

    @Test
    void notFollowsCheck(){
        //when
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(0,3);
        //then
        assertFalse(v1.follows(v2));
    }

    @Test
    void upperRightCheck() {
        //given
        Vector2d v1 = new Vector2d(0,2);
        Vector2d v2 = new Vector2d(2,0);
        //when
        Vector2d v3 = v1.upperRight(v2);
        //then
        assertTrue(v3.equals(new Vector2d(2,2)));
    }

    @Test
    void lowerLeftCheck() {
        //given
        Vector2d v1 = new Vector2d(0,2);
        Vector2d v2 = new Vector2d(2,0);
        //when
        Vector2d v3 = v1.lowerLeft(v2);
        //then
        assertTrue(v3.equals(new Vector2d(0,0)));
    }

    @Test
    void addCheck() {
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        //when
        Vector2d v3 = v1.add(v2);
        //then
        assertTrue(v3.equals(new Vector2d(3,4)));
    }

    @Test
    void subtractCheck() {
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,2);
        //when
        Vector2d v3 = v1.subtract(v2);
        //then
        assertTrue(v3.equals(new Vector2d(-1,0)));
    }

    @Test
    void opositeCheck() {
        //given
        Vector2d v1 = new Vector2d(1,2);
        //when
        Vector2d v2 = v1.opposite();
        //then
        assertTrue(v2.equals(new Vector2d(-1,-2)));
    }


}