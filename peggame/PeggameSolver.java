package peggame;

import java.util.ArrayList;
import java.util.Collection;

import peggame.backtracker.Backtracker;
import peggame.backtracker.Configuration;
public class PeggameSolver implements Configuration{
    private PegGame board;
    private Collection<Move> moves;
        public PeggameSolver(PegGame board){
        this.board = board;
        this.moves = board.getPossibleMoves();
    }
    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();

        for(Move move : moves){
            PegGame copy = board.deepCopy();
            try{
                copy.makeMove(move);
                Configuration successor = new PeggameSolver(copy);
                successors.add(successor);
            }catch(PegGameException e){
                System.out.println("This is problem");
            }

        }
        return successors;
    }

    @Override
    public boolean isValid() {
        return (moves.size() > 0);
    }

    @Override
    public boolean isGoal() {
        return (board.getGameState().equals(GameState.WON));
    }
    
}
