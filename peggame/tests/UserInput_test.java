package peggame.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.annotation.Testable;

import peggame.GameBoard;
import peggame.UserInput;;

@Testable
public class UserInput_test {
    
    @Test
    public void userinput_test_0(){
        GameBoard board = new GameBoard();
        UserInput test = new UserInput(board);
        assertEquals(test.getBoard(), board);
    }
}
