package peggame;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameBoard implements PegGame{

    private static Map<Location, Boolean> board;
    
    public GameBoard(int size){
        board = new HashMap<>();


        for(int row = 0; row < size; row++){
            for(int col=0; col <size; col++){
                Location location = new Location(row, col);
                board.put(location, false);
            }
        }
    }
    public GameBoard(){
        this(4);
    }
    @Override
    public Collection<Move> getPossibleMoves() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GameState getGameState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void makeMove(Move move) throws PegGameException {
        // TODO Auto-generated method stub
        
    }
}
