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

    public String initiateboard(String filename){
        //use the filename to add pegs to the board corresponding to file contents.
        //maybe return a tostring of the new board.(good for testing/debugging etc)
        try(
            FileReader file = new FileReader(filename);
            BufferedReader reader = new BufferedReader(file);
        ){
            String size = reader.readLine();
            int dimension = Integer.parseInt(size);
            this.board = new GameBoard(dimension);


            ///////////////////////////////////////////////
            //place logic for creating board here://///////
            ///////////////////////////////////////////////


        }catch(IOException e){
            System.out.println("Bad Filename");
            return ""; //errorcode
        }
        board.updateGameState(GameState.IN_PROGRESS);

        return board.toString();


    }
    public void interpretCommand(String command){
        //logic for playing the game
    } 
}