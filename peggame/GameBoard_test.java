package peggame;

import java.util.Collection;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class GameBoard_test {
    @Test
    public void test_game_board_default(){
        GameBoard board = new GameBoard();

        assert(board.toString().equals("{o}{o}{o}{o}\n{o}{o}{o}{o}\n{o}{o}{o}{o}\n{o}{o}{o}{o}\n"));
        assert(board.getGameState() == GameState.NOT_STARTED);
        assert(board.getPossibleMoves().size() == 0);
    }
    @Test
    public void test_addPeg(){
        GameBoard board = new GameBoard(2);
        assert("{o}{o}\n{o}{o}\n".equals(board.toString()));
        board.addPeg(new Location(0, 0));
        assert("{.}{o}\n{o}{o}\n".equals(board.toString()));
        board.addPeg(new Location(1, 1));
        assert("{.}{o}\n{o}{.}\n".equals(board.toString()));
        assert(board.getPossibleMoves().size() == 0);

    }
    @Test
    public void test_possibleMoves(){
        //setup
        GameBoard board = new GameBoard(3);
        board.addPeg(new Location(0, 0));
        board.addPeg(new Location(1, 0));

        //invoke
        Collection<Move> moves = board.getPossibleMoves();

        //analyze
        assert(moves.size() == 1);
        assert(moves.contains(new Move(new Location(0,0), new Location(2, 0))));//should be only possible move
    }
    @Test
    public void test_getMoves(){
        //setup
        GameBoard board = new GameBoard(3);
        board.addPeg(new Location(0, 0));
        board.addPeg(new Location(1, 0));

        //invoke
        Collection<Move> moves = board.getMoves(new Location(0,0));

        //analyze
        assert(moves.size() == 1);
        assert(moves.contains(new Move(new Location(0,0), new Location(2, 0))));//should be only possible move
    }
    public void test_removePeg(){
        GameBoard board = new GameBoard(2);
        board.addPeg(new Location(0, 0));
        board.addPeg(new Location(1, 1));
        assert("{.}{o}\n{o}{.}\n".equals(board.toString()));
        board.removePeg(new Location(1, 1));
        assert("{.}{o}\n{o}{o}\n".equals(board.toString()));

        assert(board.getPossibleMoves().size() == 0);
    }
}
