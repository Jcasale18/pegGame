package peggame;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameBoard implements PegGame{
    private enum GameState {
        NOT_STARTED,
        IN_PROGRESS,
        STALEMATE,
        WON;
    }

    private static Map<Location, Boolean> board = new HashMap<>();
    

    @Override
    public Collection<Move> getPossibleMoves() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Game getGameState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void makeMove(Move move) throws PegGameException {
        // TODO Auto-generated method stub
        
    }
}
