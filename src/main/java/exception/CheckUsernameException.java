package exception;

public class CheckUsernameException extends RuntimeException{
     public CheckUsernameException(){
         super();
     }
     public CheckUsernameException(String msg){
         super(msg);
     }
}
