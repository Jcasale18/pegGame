package peggame;

import java.util.Scanner;

public class UserInput{



    public void userInput(GameState state){
        String s = new String("");

        Scanner scan = new Scanner( System.in);
        
        while (state == GameState.IN_PROGRESS){
            s = scan.nextLine();
            s.toLowerCase();
            String[] multiple = s.split(" ");
    
            if(s == "help"){
                System.out.println("Commands include:\n move r1 c1 r2 c2: provide a start position and end position of a peg to move it \n hint: displays an available move \n quit: quits program ");

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