package command;

import controller.UserController;
import exception.CheckPasswordEquals;
import exception.CheckPasswordException;
import exception.CheckUsernameException;
import ui.Menu;
import util.Util;

public class Register {
    private final UserController userController = new UserController();
    public boolean register(){
        String name = Util.callResultSt("Enter name: ");
        String surname = Util.callResultSt("Enter surname: ");
        return registerPart(name,surname);
    }

    private boolean registerPart(String name, String surname){
        try {
            String username = Util.callResultSt("Enter username: ");
            String password = Util.callResultSt("Enter strong password: ");
            String againPassword = Util.callResultSt("Enter password again: ");
            if(username.equalsIgnoreCase("exit")){
                System.out.println("exit from register... ");
                return false;
            }
            else if(checkPassword(password,againPassword)){
                userController.register(name,surname,username,password);
                return true;
            }
            else {
                throw new CheckPasswordEquals();
            }
        }
        catch (CheckPasswordException ce){
            System.out.println("Password isn't strong, enter new password: ");
            return registerPart(name,surname);
        }
        catch (CheckUsernameException ue){
            System.out.println("this username has been used by someone else");
            return  registerPart(name,surname);
        }
        catch (CheckPasswordEquals ee){
            System.out.println("Passwords are not equals, enter again: ");
            return  registerPart(name,surname);
        }
    }
    public void registration(){
        Register register = new Register();
        Menu menu = new Menu();
        boolean result = register.register();
        if (result){
            System.out.println("Registration completed successfully.");
        }
        else {
            menu.showMenu();
        }

    }
    private boolean checkPassword(String password, String againPassword){

        return password.equals(againPassword);
    }
}
