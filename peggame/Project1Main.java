package peggame;

import java.util.Scanner;

public class Project1Main {
    GameBoard board = new GameBoard(6);
    
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
        GameBoard board = new GameBoard(3);//create initial empty board
        UserInput inputparser = new UserInput(board);

        System.out.println("Enter FileName: ");
        String filename = scan.nextLine();
        
        inputparser.initiateboard(filename);//inputparser contains the board, knows to manipulate that board


        
        while (board.getGameState() == GameState.IN_PROGRESS){


            s = scan.nextLine();
            s.toLowerCase();
            String[] multiple = s.split(" ");
    
            if(s == "help"){
                printCommands();
            }
            else if (multiple[0] == "move"){
                int r1 = Integer.parseInt(multiple[1]);
                int c1 = Integer.parseInt(multiple[2]);
                int r2 = Integer.parseInt(multiple[3]);
                int c2 = Integer.parseInt(multiple[4]);
                Location from = new Location(r1, c1);
                Location to = new Location(r2, c2);

                Move move = new Move(from, to);
                
                makeMove(move);
               
               
            }
            else if(s == "hint"){
                getPossibleMoves();

            }
            else if(s == "quit"){
                System.out.println("quitting the program...");
                state = GameState.NOT_STARTED;
            }
            
        } 
        scan.close();
        
    }
    
}
