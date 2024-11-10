package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void OptionsParserCheck(){
        //given
        String[] args = {"b"};
        //when
        List<MoveDirection> parsed = OptionsParser.fun(args);
        List<MoveDirection> expected = new ArrayList<>();
        expected.add(MoveDirection.BACKWARD);

        //then
        assertEquals(expected, parsed);
    }
    @Test
    void OptionsParserCheck2(){
        //given
        String[] args = {"b","f","l"};
        //when
        List<MoveDirection> parsed= OptionsParser.fun(args);
        List<MoveDirection> expected = new ArrayList<>();
        expected.add(MoveDirection.BACKWARD);
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.LEFT);
        //then
        assertEquals(expected, parsed);
    }
    @Test
    void OptionsParserCheck3(){
        //given
        String[] args = {"b","a","c","l"};
        //when
        List<MoveDirection> parsed = OptionsParser.fun(args);
        List<MoveDirection> expected = new ArrayList<>();
        expected.add(MoveDirection.BACKWARD);
        expected.add(MoveDirection.LEFT);
        //then
        assertEquals(expected, parsed);
    }
    @Test
    void OptionsParserCheck4(){
        //given
        String[] args = {"a","c"};
        //when
        List<MoveDirection> parsed = OptionsParser.fun(args);
        List<MoveDirection> expected = new ArrayList<>();
        //then
        assertEquals(expected, parsed);
    }


}