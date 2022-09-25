package ui;

import command.*;
import util.MenuUtil;
import util.Util;

public class LoginMenu {
    private final Util util = new Util();
    private final Logout logout = new Logout();
    private final Help help = new Help();
    private final CancelBooking cancelBooking = new CancelBooking();
    private final AllTimetable allTimeTable = new AllTimetable();
    private final MyFlights myFlights = new MyFlights();
    private final SearchAndBooking searchAndBooking = new SearchAndBooking();

    public void loginMenu() {
        boolean result = true;
        while (result) {
            System.out.println(MenuUtil.loginMenu());
            String selectedMenu = Util.loginMenuText();
            switch (selectedMenu) {
                case "1" -> allTimeTable.AllTimetable();

                case "2" -> myFlights.showUserBooking();

                case "3" -> searchAndBooking.SearchAndBookFlight();

                case "4" -> cancelBooking.cancelBooking();

                case "5" -> help.InfoLogin();

                case "6" -> result = logout.logout();

                default -> System.out.println("Input is invalid");

            }
        }
    }
}
