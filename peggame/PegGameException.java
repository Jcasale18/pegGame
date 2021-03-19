package peggame;

public class PegGameException extends Exception{

    public PegGameException(String errorMessage){
        super(errorMessage);
    }
    public PegGameException(){
        this("Default Error Message");
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
}
