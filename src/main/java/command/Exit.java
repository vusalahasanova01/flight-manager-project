package command;

import controller.UserController;

public class Exit {
    UserController userCont = new UserController();
    public boolean exit(){
        System.out.println("Exit from the menu.");
        return userCont.exit();
    }
}
