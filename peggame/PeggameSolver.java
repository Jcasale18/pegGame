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
    public PegGame getBoard() {
        return board;
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
    @Override
    public String toString(){
        return board.toString();
    }
    public static void main(String[] args) {
        Backtracker solver = new Backtracker(false);
        UserInput u = new UserInput();
        u.initiateboard("data/4_4.txt");
        Configuration config = new PeggameSolver(u.getBoard());
        Configuration solution = solver.solve(config);
        if(solution == null){
            System.out.println("No solution");
        }else{
            System.out.println(solution);
        }
    }
    
}
