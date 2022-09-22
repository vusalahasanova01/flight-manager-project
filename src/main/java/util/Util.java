package util;

import command.Register;
import model.Airport;
import ui.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    public static String callResultSt(String question){
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        return sc.next();
    }
    public static int callResultInt(String question){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(question);
            return sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please enter the correct values in the blanks.");
            return  callResultInt(question);
        }

    }
    public static String loginMenuText(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select number from menu: ");
        return sc.nextLine();

    }


}
