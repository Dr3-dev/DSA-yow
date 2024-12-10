/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michaela Torres
 */
import java.util.Scanner;

public class OneDimensional {

    static int[] RMNO;
    static String[] RMDESC;
    static String[] RMTYPE;
    static double[] PRICE;
    static String[] BOOKST; // Booking status as a String

    public static void inputRoomDetails1D() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        RMNO = new int[n];
        RMDESC = new String[n];
        RMTYPE = new String[n];
        PRICE = new double[n];
        BOOKST = new String[n]; // Changed from boolean to String

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for room " + (i + 1));

            System.out.print("Enter Room ID: ");
            RMNO[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Room Description: ");
            RMDESC[i] = scanner.nextLine();

            System.out.print("Enter Room Type (Single/Double/Suite): ");
            RMTYPE[i] = scanner.nextLine();

            System.out.print("Enter Room Price: ");
            PRICE[i] = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Booking Status (Booked/Available): ");
            BOOKST[i] = scanner.nextLine();
        }

        System.out.println("\nRoom details successfully added!\n");
    }

    public static void viewRoomDetails1D() {
        if (RMNO == null || RMNO.length == 0) {
            System.out.println("No rooms to display.\n");
            return;
        }

        System.out.println("----- Room Details -----");
        for (int i = 0; i < RMNO.length; i++) {
            System.out.println("Room ID No: " + RMNO[i]);
            System.out.println("Description: " + RMDESC[i]);
            System.out.println("Room Type: " + RMTYPE[i]);
            System.out.println("Price: $" + PRICE[i]);
            System.out.println("Booking Status: " + BOOKST[i]);
            System.out.println("-------------------------");
        }
    }

    public static void deleteRoom1D() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Room ID to delete: ");
        int rmnoToDelete = scanner.nextInt();

        int indexToDelete = -1;
        for (int i = 0; i < RMNO.length; i++) {
            if (RMNO[i] == rmnoToDelete) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Room ID not found.\n");
            return;
        }

        for (int i = indexToDelete; i < RMNO.length - 1; i++) {
            RMNO[i] = RMNO[i + 1];
            RMDESC[i] = RMDESC[i + 1];
            RMTYPE[i] = RMTYPE[i + 1];
            PRICE[i] = PRICE[i + 1];
            BOOKST[i] = BOOKST[i + 1];
        }

        RMNO = java.util.Arrays.copyOf(RMNO, RMNO.length - 1);
        RMDESC = java.util.Arrays.copyOf(RMDESC, RMDESC.length - 1);
        RMTYPE = java.util.Arrays.copyOf(RMTYPE, RMTYPE.length - 1);
        PRICE = java.util.Arrays.copyOf(PRICE, PRICE.length - 1);
        BOOKST = java.util.Arrays.copyOf(BOOKST, BOOKST.length - 1);

        System.out.println("Room deleted successfully!\n");
    }
}
