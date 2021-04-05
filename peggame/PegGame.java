package peggame;

import java.util.Collection;
import java.util.Map;

import peggame.GameBoard.BoardType;

public interface PegGame {
    /**
     * Find all moves on a board.
     * @return  a collection of all possible moves on a board.
     */
    Collection<Move> getPossibleMoves();
    /**
     * Get the state of the game; may have to call analyzeGameState.
     * @return returns gamestate
     */
    GameState getGameState();
    /**
     * Make a move
     * @param move Move object 
     * @throws PegGameException
     */
    void makeMove(Move move) throws PegGameException;

    /**
     * Creates a deep copy of a PegGame
     * @param original original board
     * @return returns a copy that is separate from original
     */
    PegGame deepCopy();
    
    /**
     * Make a deep copy of a PegGame
     * @return PegGame
     */
    int getNumPegs();
    /**
     * Return list of moves that led to current configuration
     * @return Collection of moves
     */
    Collection<Move> getsolvingMoves();

    void addPeg(Location to);

    void removePeg(Location from);

    boolean hasPeg(Location location);

    void updateGameState(GameState state);

    void analyzeState();

    int getCols();

    int getRows();

    Map<Location, Boolean> getBoard();

    BoardType getShape();
}