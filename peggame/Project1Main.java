package peggame;


import java.util.Scanner;

public class Project1Main {
    
 
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
            boolean success = inputparser.interpretCommand(s);
            if(!success){
                break;
            }
            
        } 
        
        scan.close();
        
    }


    
}
