package peggame;

import java.util.ArrayList;
import java.util.Collection;

import peggame.backtracker.Backtracker;
import peggame.backtracker.Configuration;
public class PeggameSolver implements Configuration{
    private PegGame board;
        public PeggameSolver(PegGame board){
        this.board = board;
    }
    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();

        Collection<Move> possibleMoves = board.getPossibleMoves();
        for(Move move : possibleMoves){
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isGoal() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
