package peggame;

public class PegGameException extends Exception{

    public PegGameException(String errorMessage){
        super(errorMessage);
    }
    public PegGameException(){
        this("Invalid Move");
    }

    /**
     * Added by vscode
     */
    private static final long serialVersionUID = 1L;

    
}
