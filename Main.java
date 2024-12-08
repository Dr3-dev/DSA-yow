/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Hotel and Tourism System =====");
            System.out.println("1. One-Dimensional Array");
            System.out.println("2. Two-Dimensional Array");
            System.out.println("3. Sample Application");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // One-Dimensional Menu
                    System.out.println("\n===== One-Dimensional Array Menu =====");
                    System.out.println("1. Add Reservation");
                    System.out.println("2. Edit Reservation");
                    System.out.println("3. Delete Reservation");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int oneDChoice = scanner.nextInt();

                    switch (oneDChoice) {
                        case 1:
                            OneDimensional.inputRoomDetails1D();
                            break;
                        case 2:
                            System.out.println("Editing functionality is not yet implemented.");
                            break;
                        case 3:
                            OneDimensional.deleteRoom1D();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    // Two-Dimensional Menu
                    System.out.println("\n===== Two-Dimensional Array Menu =====");
                    System.out.println("1. Add Reservation");
                    System.out.println("2. Edit Reservation");
                    System.out.println("3. Delete Reservation");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int twoDChoice = scanner.nextInt();

                    switch (twoDChoice) {
                        case 1:
                            TwoDimensional.inputRoomDetails2D();
                            break;
                        case 2:
                            System.out.println("Editing functionality is not yet implemented.");
                            break;
                        case 3:
                            TwoDimensional.deleteRoom2D();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    // View combined reservations
                    SampleApplication.viewReservations();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
