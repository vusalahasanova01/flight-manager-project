package command;

import controller.UserController;

public class Logout {
    UserController userCont = new UserController();

    public void logout() {
        System.out.println("Exit from login menu.");
        userCont.logout();
    }
}
