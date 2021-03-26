package peggame;

public class PegGameException extends Exception{

    /**
     * Custom error message constructor
     * @param errorMessage Custom error message
     */
    public PegGameException(String errorMessage){
        super(errorMessage);
    }
    /**
     * Default error message constructor
     */
    public PegGameException(){
        this("Invalid Move");
    }

    /**
     * Added by vscode
     */
    private static final long serialVersionUID = 1L;

    
}
