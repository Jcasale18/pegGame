package peggame;

public class Main {
    GameBoard board = new GameBoard(6);
    
    public static void main(String[] args) {
        GameBoard board = new GameBoard(6);
        System.out.println(board);
        board.addPeg(new Location(0,1));
        
        System.out.println(board);
        board.addPeg(new Location(1,1));
        
        System.out.println(board); 
           
    }
    
}
