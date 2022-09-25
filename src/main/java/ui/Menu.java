package ui;

import command.*;
import util.MenuUtil;
import util.Util;

public class Menu {
    private final Login login = new Login();
    private final Register register = new Register();
    private final Exit exit = new Exit();
    private final FlightById flight = new FlightById();
    private final Help help = new Help();
    private final AllTimetable allTimetable = new AllTimetable();

    public void showMenu() {
        boolean result = true;
        while (result) {
            System.out.println(MenuUtil.showMenu());
            String selectedMenu = Util.loginMenuText();
            switch (selectedMenu) {
                case "1" -> login.login();

                case "2" -> register.registration();

                case "3" -> allTimetable.AllTimetable();

                case "4" -> flight.flightInformation();

                case "5" -> help.InfoMenu();

                case "6" -> result = exit.exit();
                default -> System.out.println("Input is invalid");
            }
        }
    }

}
