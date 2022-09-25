package command;

import controller.UserController;

public class Logout {
    UserController userCont = new UserController();

    public boolean logout() {
        System.out.println("Exit from login menu.");
        return userCont.logout();
    }
}
