package exception;

public class CheckPasswordEquals extends RuntimeException{
    public CheckPasswordEquals(){
        super();
    }
    public CheckPasswordEquals(String msg){
        super(msg);
    }
}
