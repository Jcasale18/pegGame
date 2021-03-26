package peggame;


import java.util.Scanner;

public class Project1Main {
    
 
    public static void main(String[] args) {
        String s = new String("");

        Scanner scan = new Scanner( System.in);
        UserInput inputparser = new UserInput();

        System.out.print("Enter FileName: ");
        String filename = scan.nextLine();
        
        inputparser.initiateboard(filename);//inputparser contains the board, knows to manipulate that board
        GameBoard board = inputparser.getBoard();


        
        while (board.getGameState() == GameState.IN_PROGRESS){
            System.out.println("\n" + board);

            System.out.print(">>");
            s = scan.nextLine();
            boolean success = inputparser.interpretCommand(s);
            if(!success){
                break;
            }
            if(board.getGameState() == GameState.STALEMATE){
                System.out.println("No more moves!");

                System.out.println("Goodbye!");
                break;
            }else if(board.getGameState() == GameState.WON){
                System.out.println("Winner Winner!");
                System.out.println("Goodbye!");
                break;
            }
            
        } 
        
        scan.close();
        
    }


    
}
