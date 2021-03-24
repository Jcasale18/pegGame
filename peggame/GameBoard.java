package peggame;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameBoard implements PegGame{

    private Map<Location, Boolean> board;
    
    public GameBoard(int size){
        this.board = new HashMap<>();


        for(int row = 0; row < size; row++){
            for(int col=0; col <size; col++){
                Location location = new Location(row, col);
                this.board.put(location, false);
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
        Location from = move.getFrom();
        Location to = move.getTo();

        Location middle = new Location((to.getRow() + from.getRow())/2 , (to.getCol() + from.getCol()) / 2);

        if(!hasPeg(move.getFrom())){
            throw new PegGameException("There is no peg to move");
        }else if(hasPeg(move.getTo())){
            throw new PegGameException("There is already a peg there");
        }else if(!hasPeg(middle)){
            throw new PegGameException("There is no peg to jump over");
        }

        else{
            removePeg(move.getFrom());
            addPeg(move.getTo());
        }
        
    }

    public void addPeg(Location to){

        if(board.containsKey(to)){
            board.put(to, true);
        }
    }

    public void removePeg(Location from){

        if(board.containsKey(from)){
            board.put(from, false);
        }
    }
    public boolean hasPeg(Location location){
        return board.get(location);
    }
}
