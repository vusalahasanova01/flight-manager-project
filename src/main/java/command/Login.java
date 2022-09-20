package command;

import bookingManage.BookingManager;
import controller.UserController;
import ui.LoginMenu;
import util.MenuUtil;
import util.Util;

public class Login {
    private final UserController userController = new UserController();

    public void login() {
        String username = Util.callResultSt("Enter username: ");
        String password = Util.callResultSt("Enter password: ");
        if(userController.loginCheck(username,password)){
            System.out.println("login success");
         BookingManager.startLog();
        }
        else {
            System.out.println("Username or password is not correct. Please try again.");
            login();
        }

    }

}
