package peggame;


import java.util.Scanner;

public class Project1Main {
    
 
    /**
     * Main Loop
     * @param args args from command line(no functionality)
     */
    public static void main(String[] args) {
        String s = new String("");

        Scanner scan = new Scanner( System.in); //opens scanner 
        UserInput inputparser = new UserInput(); //creates a new instance of UserInput

        System.out.print("Enter FileName: ");
        String filename = scan.nextLine();//Checks for filename, throws exceptions if file name does not exist
        
        inputparser.initiateboard(filename);//inputparser contains the board, knows to manipulate that board
        PegGame board = inputparser.getBoard();


        
        while (board.getGameState() == GameState.IN_PROGRESS){//continues loop until the gamestate changes
            System.out.println("\n" + board);

            System.out.print(">>");
            s = scan.nextLine().strip();

            if(s.equals("quit")){
                System.out.print("Are you sure (y/n): ");
                String sure = scan.nextLine().strip();
                if(sure.equals("n")){
                    continue;
                }
            }
            boolean success = inputparser.interpretCommand(s);
            board.analyzeState();


            if(!success){
                break;
            }
            if(board.getGameState() == GameState.STALEMATE){//checks if gamestate is a stalemate, quits if true
                System.out.println("No more moves!");

                System.out.println("Goodbye!");
                break;
            }else if(board.getGameState() == GameState.WON){//checks if user has won game, quits if true
                System.out.println("Winner Winner!");
                System.out.println(board);
                System.out.println("Goodbye!");
                break;
            }
            
        } 
        
        scan.close();
        
    }


    
}
