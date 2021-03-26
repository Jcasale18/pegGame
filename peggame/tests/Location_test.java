package peggame.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import peggame.Location;

@Testable
public class Location_test {

    @Test
    public void location_test_getters(){
        Location loc = new Location(3,4);
        assertEquals(loc.getRow(), 3);
        assertEquals(loc.getCol(), 4);
    }

    @Test
    public void location_test_equals(){
        Location loc1 = new Location(3,3);
        Location loc2 = new Location(3,3);
        Location loc3 = new Location(3,4);
        assert(loc1.equals(loc2));
        assert(!loc1.equals(loc3));
    }

    @Test
    public void location_test_toString(){
        Location loc1 = new Location(3, 3);
        assertEquals(loc1.toString(), "3, 3");
    }

    @Test
    public void location_test_hashCode(){
        Location loc1 = new Location(3,3);
        assertEquals(loc1.hashCode(), 30003);
    }

    @Test
    public void location_test_getNeighbor(){
        Location loc1 = new Location(3,3);
        assertEquals(loc1.getNeighbor("L"), new Location(3, 2));
        assertEquals(loc1.getNeighbor("R"), new Location(3, 4));
        assertEquals(loc1.getNeighbor("T"), new Location(4, 3));
        assertEquals(loc1.getNeighbor("B"), new Location(2, 3));
        assertEquals(loc1.getNeighbor("TR"), new Location(4, 4));
        assertEquals(loc1.getNeighbor("TL"), new Location(4, 2));
        assertEquals(loc1.getNeighbor("BR"), new Location(2, 4));
        assertEquals(loc1.getNeighbor("BL"), new Location(2, 2));
    }
}
