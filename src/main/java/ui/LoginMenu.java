package ui;

import command.*;
import util.MenuUtil;
import util.Util;

public class LoginMenu {
    private final Util util = new Util();
    private final Logout logout = new Logout();
    private final Help help =new Help();
    private final CancelBooking cancelBooking = new CancelBooking();
    private final AllTimetable allTimeTable = new AllTimetable();
    private final MyFlights myFlights = new MyFlights();
    private final SearchAndBooking searchAndBooking = new SearchAndBooking();

    public void loginMenu() {
        boolean result = true;
        while (result) {
            System.out.println(MenuUtil.loginMenu());
            String selectedMenu = util.loginMenuText();
            switch (selectedMenu) {
                case "1":
                    allTimeTable.AllTimetable();
                    break;
                case "2":
                    myFlights.showUserBooking();
                    break;
                case "3":
                    searchAndBooking.SearchAndBookFlight();
                    break;
                case "4":
                     cancelBooking.cancelBooking();
                    break;
                case "5":
                    help.InfoLogin();
                    break;
                case "6":
                    logout.logout();
                    result = false;
                    break;
                default:
                    System.out.println("Input is invalid");

            }
        }
    }
}
