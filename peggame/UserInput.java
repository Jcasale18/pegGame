package peggame;

public class UserInput{
    private GameBoard board;
    public UserInput(GameBoard board){
        this.board = board;//the board for the userinput class to manipulate
    }


    public String initiateboard(String filename){
        //use the filename to add pegs to the board corresponding to file contents.
        //maybe return a tostring of the new board.(good for testing/debugging etc)









        board.updateGameState(GameState.IN_PROGRESS);
    }
    public void interpretCommand(String command){
        //logic for playing the game
    } 
}