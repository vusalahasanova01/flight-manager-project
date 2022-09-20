package exception;

public class CheckPasswordException extends RuntimeException {
    public CheckPasswordException(){
        super();
    }
    public CheckPasswordException(String msg){
        super(msg);
    }

}
