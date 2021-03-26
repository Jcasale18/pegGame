package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;


public class UserInput{
    private GameBoard board;
    public UserInput(GameBoard board){
        this.board = board;//the board for the userinput class to manipulate
    }
    public UserInput(){
        
    }
    public GameBoard getBoard() {
        return board;
    }

    public void initiateboard(String filename){
        //use the filename to add pegs to the board corresponding to file contents.
        //maybe return a tostring of the new board.(good for testing/debugging etc)
        GameBoard board = null;
        try(
            FileReader file = new FileReader(filename);
            BufferedReader reader = new BufferedReader(file);
        ){
            String rowString = reader.readLine();
            int row = Integer.parseInt(rowString);
            String line = reader.readLine();
            int col = line.length();
            board = new GameBoard(row, col);

            int countRow = 0;
            while (true){
                if (line == null){
                    break;
                } else{
                    System.out.println(line);
                    String[] pegs = line.split("");
                    for (int i=0; i<pegs.length; i++){
                        if(pegs[i].equals(".")){
                            board.addPeg(new Location (countRow, i));
                        }
                    }
                }
                line = reader.readLine();
                countRow += 1;
                board.analyzeState();
            }


        }catch(IOException e){
            System.out.println("Bad Filename");
        }
        board.updateGameState(GameState.IN_PROGRESS);
        this.board = board;
    }
    public boolean interpretCommand(String s){
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
            return false;
        }
        return true;
    }
    public static void printCommands(){
        System.out.println("Available Commands: ");
        System.out.println("help - displays this message");
        System.out.println("move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board.");
        System.out.println("hint - displays an available move.");
        System.out.println("quit - quits the game.");
    }
}