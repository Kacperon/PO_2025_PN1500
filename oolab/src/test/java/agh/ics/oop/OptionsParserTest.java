package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void OptionsParserCheck(){
        //given
        String[] args = {"b"};
        //when
        MoveDirection[] parsed = OptionsParser.fun(args);
        MoveDirection[] expected = {MoveDirection.BACKWARD};

        //then
        assertArrayEquals(expected, parsed);
    }
    @Test
    void OptionsParserCheck2(){
        //given
        String[] args = {"b","f","l"};
        //when
        MoveDirection[] parsed = OptionsParser.fun(args);
        MoveDirection[] expected = {MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.LEFT};
        //then
        assertArrayEquals(expected, parsed);
    }
    @Test
    void OptionsParserCheck3(){
        //given
        String[] args = {"b","a","c","l"};
        //when
        MoveDirection[] parsed = OptionsParser.fun(args);
        MoveDirection[] expected = {MoveDirection.BACKWARD,MoveDirection.LEFT};
        //then
        assertArrayEquals(expected, parsed);
    }
    @Test
    void OptionsParserCheck4(){
        //given
        String[] args = {"a","c"};
        //when
        MoveDirection[] parsed = OptionsParser.fun(args);
        MoveDirection[] expected = {};
        //then
        assertArrayEquals(expected, parsed);
    }


}