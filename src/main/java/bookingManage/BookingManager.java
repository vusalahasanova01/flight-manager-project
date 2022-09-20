package bookingManage;

import ui.LoginMenu;
import ui.Menu;

public class BookingManager {
    private static int logged = -1;

    public static int getLogged() {
        return logged;
    }

    public static void setLogged(int loggedId) {
        logged = loggedId;
    }

    public static boolean loggedIn() {
        return logged != -1;
    }

    public static void logout() {
        logged = -1;
    }

    public static void start() {
        Menu menu = new Menu();
        menu.showMenu();
    }
    public static void startLog(){
        LoginMenu loginMenu = new  LoginMenu();
        loginMenu.loginMenu();
    }


}
