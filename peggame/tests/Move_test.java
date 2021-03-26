package peggame.tests;

import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


import peggame.Location;
import peggame.Move;


@Testable
public class Move_test{



    @Test
    public void move_test_get(){

        Location from = new Location(3,3);
        Location to = new Location(2,2);

        Move testing = new Move(from, to);

        assertEquals(testing.getFrom(), from);
        assertEquals(testing.getTo(), to);

    }

    @Test
    public void move_test_toString(){
        Location from = new Location(3,3);
        Location to = new Location(2,2);
        Move testing = new Move(from, to);

        assertEquals(testing.toString(), "Move from "+from+" to "+to);
    }


    @Test
    public void move_test_equals(){
        Location from_1 = new Location(3,3);
        Location to_1 = new Location(2,2);
        Location from_2 = new Location(3,3);
        Location to_2 = new Location(2,2);
        Location from_3 = new Location(3,3);
        Location to_3 = new Location(3,2);

        Move test_1 = new Move(from_1, to_1);
        Move test_2 = new Move(from_2, to_2);
        Move test_3 = new Move(from_3, to_3);


        assert(test_1.equals(test_2));
        assert(!test_1.equals(test_3));
    }

}