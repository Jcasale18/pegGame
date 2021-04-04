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
        
        //for each possible move, make that move, and save the result as a board
        for(Move move : moves){
            PegGame copy = board.deepCopy();
            //int test = copy.getNumPegs();
            try{
                copy.makeMove(move);
                //System.out.println(test+" : "+copy.getNumPegs());
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
        if (moves.size() > 0){
            return true;
        } else if (isGoal()){
            return true;
        } else{
            return false;
        }
    }
    public Collection<Move> getsolution() {
        return board.getsolvingMoves();//returns moves that have been made on board; when called on solved board, it will be solving moves.
    }
    @Override
    public boolean isGoal() {
        return (board.getNumPegs() == 1);//when there's only 1 peg left, it's solved.
    }

    @Override
    public String toString(){
        return board.toString();
    }
    public static void main(String[] args) {
        Backtracker solver = new Backtracker(false);
        UserInput u = new UserInput();
        u.initiateboard("data/7_7.txt");//manual test for this solve should result in a solution
        Configuration config = new PeggameSolver(u.getBoard());
        Configuration solution = solver.solve(config);
        if(solution == null){
            System.out.println("No solution");
        }else{
            System.out.println(solution);
            System.out.println(solution.getsolution());
        }
    }
    
}
