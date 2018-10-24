package studentapplication.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        MainController mainController
                = new MainController(choice);
        mainController.result();
    }

}
