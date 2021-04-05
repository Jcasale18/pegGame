package peggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class represents a game of Peg Game
 */
public class GameBoard implements PegGame{
    public enum BoardType{
        RECTANGLE,
        TRIANGLE;
    }

    private Map<Location, Boolean> board;//Map of all locations in board {Location, HasPeg?}
    private GameState state;
    private int rows;
    private int cols;
    private int numPegs;
    private BoardType shape;
    private Collection<Move> solvingMoves;
    /**
     * Generates a rows x cols sized PegGame board with no pegs in it
     * @param rows num of rows
     * @param cols num of cols
     */
    public GameBoard(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.solvingMoves = new ArrayList<>();
        this.board = new HashMap<>();
        this.state = GameState.NOT_STARTED;
        this.numPegs = 0;
        this.shape = BoardType.RECTANGLE;
        for(int r = 0; r < rows; r++){
            for(int c=0; c <cols; c++){
                Location location = new Location(r, c);
                this.board.put(location, false);
            }
        }
    }
    public GameBoard(int height){
        this.rows = height;
        this.cols = height;
        int current_width = 1;
        this.solvingMoves = new ArrayList<>();
        this.board = new HashMap<>();
        this.state = GameState.NOT_STARTED;
        this.numPegs = 0;
        this.shape = BoardType.TRIANGLE;
        for(int r = 0; r < height; r++){
            for(int c=0; c <current_width; c++){
                Location location = new Location(r, c);
                this.board.put(location, false);
            }
            current_width++;
        }
    }      
    
    /**
     * Default board size 4x4
     */
    public GameBoard(){
        this(4, 4);
    }

    /**
     * sets number of pegs. Careful to use, will ruin game.
     * @param num
     */
    public void setNumPegs(int num){
        this.numPegs = num;
    }
    public Map<Location, Boolean> getBoard() {
        return board;
    }
    public int getCols() {
        return cols;
    }
    public int getRows(){
        return rows;
    }
    @Override
    public Collection<Move> getsolvingMoves(){
        return solvingMoves;
    }
    @Override
    public int getNumPegs() {
        return this.numPegs;
    }

    @Override
    /**
     * Find all moves on a board.
     * @return  a collection of all possible moves on a board.
     */
    public Collection<Move> getPossibleMoves() {
        
        Set<Location> locs = board.keySet();
        Collection<Move> possibleMoves = new ArrayList<>();
        for (Location loc : locs){
            if (board.get(loc)){
                possibleMoves.addAll(getMoves(loc));
            }
        }
        
        return possibleMoves;
    }

    @Override
    public GameState getGameState() {
        return this.state;
    }

    @Override
    public void makeMove(Move move) throws PegGameException {
        Location from = move.getFrom();
        Location to = move.getTo();
        Location middle = new Location((to.getRow() + from.getRow())/2 , (to.getCol() + from.getCol()) / 2);//location that's jumped over can be thought of as average row/col

        if(!board.containsKey(from) || !board.containsKey(to)){ //Checks if move is in board
            throw new PegGameException("Invalid move");
        }else if(!hasPeg(from)){
            throw new PegGameException("There is no peg to move");
        }else if(hasPeg(to)){
            throw new PegGameException("There is already a peg there");
        }else if(!hasPeg(middle)){
            throw new PegGameException("There is no peg to jump over");
        }else if((Math.abs(to.getCol()-from.getCol())!=2) && (Math.abs(to.getRow()-from.getRow())!=2)){
            throw new PegGameException("Can only jump over one peg.");
        }else{
            removePeg(from);
            addPeg(to);
            removePeg(middle);
            solvingMoves.add(move);
        }
    }
    public void analyzeState(){
        
        if(numPegs >= 1){//if theres at least one peg, the game might still be running
            if(getPossibleMoves().size() == 0){
                if(numPegs > 1){
                    state = GameState.STALEMATE;//if there's no moves, and more than one peg, it's stalemate
                }else{
                    state = GameState.WON;
                }
            }else{
                state = GameState.IN_PROGRESS;//if there's still moves to make, the game is still in progress
            }
        }
    }
    /**
     * Get possible moves that can be made at a given location
     * @param location location of type Location
     * @return returns a Collection of locations.
     */
    public Collection<Move> getMoves(Location location){
        Collection<Move> moves = new ArrayList<>();
        String[] commands = {"L","R", "B", "T", "TR", "TL", "BR", "BL"};
        for (String command : commands){
            try{
                Location neighbor = location.getNeighbor(command);
                if (board.get(location) && board.get(neighbor) && !board.get(neighbor.getNeighbor(command))){

                    moves.add(new Move(location, neighbor.getNeighbor(command)));
                }
            } catch (Exception e){
                continue;
            }
        }
        return moves;
    }

    /**
     * Adds a peg to a location, if there is not one already
     * @param to Location type
     */
    public void addPeg(Location to){

        if(board.containsKey(to)){
            if(board.get(to) == false){
                board.put(to, true);
                numPegs++;
            }
        }
    }

    /**
     * Removes a peg from a location, if one is there
     * @param from location to remove from, type Location
     */
    public void removePeg(Location from){

        if(board.containsKey(from)){
            if(board.get(from) == true){
                board.put(from, false);
                numPegs--;
                //System.out.println(numPegs);
            }
        }
    }
    /**
     * Checks for peg in a location
     * @param location Location to check
     * @return returns true if has a peg, otherwise false.
     */
    public boolean hasPeg(Location location){
        return board.get(location);
    }
    
    @Override
    public String toString(){
        Set<Location> holes= board.keySet();
        List<Location> holelist = new ArrayList<>();
        for(Location hole: holes){
            holelist.add(hole);
        }
        holelist.sort( (a,b) -> (a.hashCode() - b.hashCode()));//sorting because hash is not ordered


        int index = 0;        
        String string = "";
        //for(Location hole: holelist){
            for(int i=0; i<rows;i++){
                for(int j=0; j<cols;j++){
                    if(board.containsKey(new Location(i,j))){
                        if (board.get(new Location (i,j))){
                            string+="o";
                        } else{
                            string+="-";
                        }
                    }
                }
                string+="\n";
            }
            /*
            if(board.get(hole) == true){
                string += "o";
            }
            else{
                string += "-";
            }
            index ++;
            if(index % cols == 0){

                string += "\n";
            }
            */
        //}
        return string;
    }
    /**
     * Setter for gamestate
     * @param state GameState enum type.
     */
    public void updateGameState(GameState state){
        this.state = state;
    }


    @Override
    public PegGame deepCopy() {
        if(shape == BoardType.RECTANGLE){
            GameBoard copy = new GameBoard(rows, cols);
            this.board.forEach((loc, bool) -> copy.getBoard().put(loc,bool));//for each location in board, put it in copy board
            this.solvingMoves.forEach((move) -> copy.getsolvingMoves().add(move));//copy list, since list is also passed by reference
            copy.numPegs = this.numPegs;
            return copy;
        }
        GameBoard copy = new GameBoard(rows);
        this.board.forEach((loc, bool) -> copy.getBoard().put(loc,bool));//for each location in board, put it in copy board
        this.solvingMoves.forEach((move) -> copy.getsolvingMoves().add(move));//copy list, since list is also passed by reference
        copy.numPegs = this.numPegs;
        return copy;
    }
public static void main(String[] args) {
    PegGame board = new GameBoard(5);
    System.out.println(board);
}
    
}
