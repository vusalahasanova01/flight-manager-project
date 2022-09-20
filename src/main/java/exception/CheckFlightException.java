package exception;

public class CheckFlightException extends RuntimeException{
    public CheckFlightException(){
        super();
    }
    public CheckFlightException(String msg){
        super(msg);
    }
}
