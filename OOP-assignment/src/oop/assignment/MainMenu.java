/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JT
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class MainMenu {

    static Scanner in = new Scanner(System.in);
    static int PIN = 1234, choice = 0;
    static char answer;
    static boolean continueInput = true;

    public static void main(String[] args) {
        //Sample 01 - print toString
        /*  
        Customer c1 = new Customer("981212565427", "01123203811", new Name("Hong Jie", "Tang"));
        Beautician b1 = new Beautician("980101565227", "0112341234", new Name("Hon", "Tan"));
        Service s1 = new Service("T001", "Colouring", "Hair colouring", "Hair Care", 200.00, 3);
        Date d1 = new Date(12, 12, 13, 16);
        Appointment a1 = new Appointment(c1, b1, s1, d1);
        System.out.println(a1);
         */

        do {
            System.out.println("           Main Menu           ");
            System.out.println("-------------------------------");
            System.out.println("1. Appointment     2. Billing  ");
            System.out.println("3. Registration    4. Service  ");
            System.out.println("5. Beautician      6. Reporting");
            System.out.println("7. Exit                        ");
            //Accept input and check validation
            do {
                try {
                    System.out.print("Enter choice: ");
                    choice = in.nextInt();
                    if (choice < 1 || choice > 7)//if input is like that, then jump out do loop, jump out switch default and loop again because choice != 7
                    {
                        System.out.println("Try again. Invalid input: choice does not existed.");
                    }
                    continueInput = false;
                } catch (Exception ex) {
                    System.out.println("Try again. Incorrect input: an integer is required.");
                    in.nextLine(); //if no put will infinite loop
                }
            } while (continueInput);

            switch (choice) {
                case 1:
                    appointmentMenu();
                    break;
                case 2:
                    break;
                case 3:
                    registrationMenu();
                    break;
                case 4:
                    serviceMenu();
                    break;
                case 5:
                    beauticianMenu();
                    break;
                case 6: {
                    //Reporting
                    break;
                }
                case 7: {
                    System.out.println("End of Program");
                    break;
                }
            }
        } while (choice != 7);
    }

    public static void appointmentMenu() {
        System.out.println("                  Appointment                  ");
        System.out.println("-----------------------------------------------");
        System.out.println("1. Add Appointment        2. Cancel Appointment");
        System.out.println("3. Modify Appointment     4. Search Appointment");
        System.out.println("5. Appointment records    6. Back to Main Menu ");
        do {
            //Accept input and check validation
            do {
                try {
                    System.out.print("Enter choice: ");
                    choice = in.nextInt();
                    if (choice < 1 || choice > 6)//if input is like that, then jump out do loop, jump out switch default and loop again because choice != 7
                    {
                        System.out.println("Try again. Invalid input: choice does not existed.");
                    }
                    continueInput = false;
                } catch (Exception ex) {
                    System.out.println("Try again. Incorrect input: an integer is required.");
                    in.nextLine();//if no put will infinite loop
                }
            } while (continueInput);

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);
    }

    public static void registrationMenu() {
        System.out.println("               Member               ");
        System.out.println("-------------------------------------");
        System.out.println("1. Add Member       2. Delete Member ");
        System.out.println("3. Modify Member    4. Display Member");
        System.out.println("5. Back to Main Menu                 ");
        do {
            //Accept input and check validation
            do {
                try {
                    System.out.print("Enter choice: ");
                    choice = in.nextInt();
                    if (choice < 1 || choice > 5)//if input is like that, then jump out do loop, jump out switch default and loop again because choice != 7
                    {
                        System.out.println("Try again. Invalid input: choice does not existed.");
                    }
                    continueInput = false;
                } catch (Exception ex) {
                    System.out.println("Try again. Incorrect input: an integer is required.");
                    in.nextLine();//if no put will infinite loop
                }
            } while (continueInput);

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (choice != 5);
    }

    public static void serviceMenu() {
        do {
            System.out.println("                Service                ");
            System.out.println("---------------------------------------");
            System.out.println("1. Add Service       2. Delete Service ");
            System.out.println("3. Modify Service    4. Display Service");
            System.out.println("5. Back to Main Menu                   ");

            //Accept input and check validation
            do {
                try {
                    System.out.print("Enter choice: ");
                    choice = in.nextInt();
                    if (choice < 1 || choice > 5)//if input is like that, then jump out do loop, jump out switch default and loop again because choice != 7
                    {
                        System.out.println("Try again. Invalid input: choice does not existed.");
                    }
                    continueInput = false;
                } catch (Exception ex) {
                    System.out.println("Try again. Incorrect input: an integer is required.");
                    in.nextLine();//if no put will infinite loop
                }
            } while (continueInput);

            switch (choice) {
                case 1:
                    Service.addService();
                    break;
                case 2:
                    break;
                case 3:
                    Service.modifyService();
                    break;
                case 4:
                    break;
            }
        } while (choice != 5);
    }

    public static void beauticianMenu() {
        System.out.println("                  Beautician                  ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Add Beautician        2. Delete Beautician ");
        System.out.println("3. Modify Beautician     4. Display Beautician");
        System.out.println("5. Back to Main Menu                          ");
        do {
            //Accept input and check validation
            do {
                try {
                    System.out.print("Enter choice: ");
                    choice = in.nextInt();
                    if (choice < 1 || choice > 5)//if input is like that, then jump out do loop, jump out switch default and loop again because choice != 7
                    {
                        System.out.println("Try again. Invalid input: choice does not existed.");
                    }
                    continueInput = false;
                } catch (Exception ex) {
                    System.out.println("Try again. Incorrect input: an integer is required.");
                    in.nextLine();//if no put will infinite loop
                }
            } while (continueInput);

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (choice != 5);
    }

    public static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }
}
