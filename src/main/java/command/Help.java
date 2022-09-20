package command;

import bookingManage.BookingManager;
import util.Util;

public class Help {
    public void InfoMenu(){
       String info =  """
                Login - If you want to enter the fligth site, click log in
                Register - If you want to register, click on register.
                Online board - Click on the online board to learn about all the flights.
                ViewFlight - If you want to get information about only one flight, click view flight and enter the fligh id.
                """;
        System.out.println(info);
        exitFrom();
    }
    public void InfoLogin(){
        String info =  """
                Online board - Click on the online board to learn about all the flights.
                My flights - If you want to learn about your flights, click on my flights
                Search and bookingFlight - If you want to search and book flights,  click on the Search and bookingFlight 
                Cancel booking - If you want to cancel your tickets, click on  Cancel booking.
                """;
        System.out.println(info);
        exitFromLog();

    }
    public  void exitFrom(){
       String result = Util.callResultSt("Enter exit if u want exit from help.");
       if (result.equalsIgnoreCase("exit")){
           BookingManager.start();
       }
       else{
           System.out.println("The action you entered could not be found, please enter again:");
           exitFrom();
       }
    }
    public  void exitFromLog(){
        String result = Util.callResultSt("Enter exit if u want exit from help.");
        if (result.equalsIgnoreCase("exit")){
            BookingManager.startLog();
        }
        else{
            System.out.println("The action you entered could not be found, please enter again:");
            exitFromLog();
        }
    }
}
