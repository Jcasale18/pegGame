package peggame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            String colString = reader.readLine();
            int col = colString.length();
            board = new GameBoard(row, col);

            int countRow = 1;
            while (true){
                String line = reader.readLine();
                if (line == null){
                    break;
                } else{
                    String[] pegs = line.split("");
                    int countCol = 0;
                    for (String peg : pegs){
                        if (peg.equals(".")){
                            board.addPeg(new Location(countRow, countCol));
                        }
                        countCol += 1;
                    }
                }
            }



            ///////////////////////////////////////////////
            //place logic for creating board here://///////
            ///////////////////////////////////////////////


        }catch(IOException e){
            System.out.println("Bad Filename");
           //return ""; //errorcode
           //return null;
        }
        board.updateGameState(GameState.IN_PROGRESS);
        this.board = board;

        //return board;
        //return board.toString();


    }
    public void interpretCommand(String command){
        //logic for playing the game
    }
}