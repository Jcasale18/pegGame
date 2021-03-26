package peggame;

import java.util.Collection;

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

    int getNumPegs();
}