package peggame;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Project1Main {
    
    public static void printCommands(){
        System.out.println("Available Commands: ");
        System.out.println("help - displays this message");
        System.out.println("move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board.");
        System.out.println("hint - displays an available move.");
        System.out.println("quit - quits the game.");
    }
 
    public static void main(String[] args) {
        String s = new String("");

        Scanner scan = new Scanner( System.in);
        UserInput inputparser = new UserInput();

        System.out.println("Enter FileName: ");
        String filename = scan.nextLine();
        
        inputparser.initiateboard(filename);//inputparser contains the board, knows to manipulate that board
        GameBoard board = inputparser.getBoard();
        
        while (board.getGameState() == GameState.IN_PROGRESS){
            System.out.println(board);
            System.out.print(">>");
            s = scan.nextLine();
            String[] multiple = s.split(" ");
    
            if(s.equals("help")){
                printCommands();
            }
            else if (multiple[0].equals("move")){
                int r1 = Integer.parseInt(multiple[1]);
                int c1 = Integer.parseInt(multiple[2]);
                int r2 = Integer.parseInt(multiple[3]);
                int c2 = Integer.parseInt(multiple[4]);
                Location from = new Location(r1, c1);
                Location to = new Location(r2, c2);

                Move move = new Move(from, to);
                
                try{
                    board.makeMove(move);

                }catch(PegGameException e){
                    System.out.println(e);
                    continue;
                }
               
               
            }
            else if(s.equals("hint")){
                Collection<Move> moves = board.getPossibleMoves();
                Iterator<Move> options = moves.iterator();
                System.out.println(options.next());
            }
            else if(s.equals("quit")){
                System.out.println("quitting the program...");
                board.updateGameState(GameState.NOT_STARTED);
            }
            
        } 
        
        scan.close();
        
    }


    
}
