/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

public class TwoDimensional {

    static Object[][] rooms;

    public static void inputRoomDetails2D() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        rooms = new Object[n][5]; // 5 columns for RMNO, RMDESC, RMTYPE, PRICE, BOOKST

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for room " + (i + 1));

            System.out.print("Enter Room ID: ");
            rooms[i][0] = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Room Description: ");
            rooms[i][1] = scanner.nextLine();

            System.out.print("Enter Room Type (Single/Double/Suite): ");
            rooms[i][2] = scanner.nextLine();

            System.out.print("Enter Room Price: ");
            rooms[i][3] = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Booking Status (Booked/Available): ");
            rooms[i][4] = scanner.nextLine(); // Changed from boolean to String
        }

        System.out.println("\nRoom details successfully added!\n");
    }

    public static void viewRoomDetails2D() {
        if (rooms == null || rooms.length == 0) {
            System.out.println("No rooms to display.\n");
            return;
        }

        System.out.println("----- Room Details -----");
        for (Object[] room : rooms) {
            System.out.println("Room ID No: " + room[0]);
            System.out.println("Description: " + room[1]);
            System.out.println("Room Type: " + room[2]);
            System.out.println("Price: $" + room[3]);
            System.out.println("Booking Status: " + room[4]);
            System.out.println("-------------------------");
        }
    }

    public static void deleteRoom2D() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Room ID to delete: ");
        int rmnoToDelete = scanner.nextInt();

        int indexToDelete = -1;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i][0].equals(rmnoToDelete)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Room ID not found.\n");
            return;
        }

        for (int i = indexToDelete; i < rooms.length - 1; i++) {
            rooms[i] = rooms[i + 1];
        }

        rooms = java.util.Arrays.copyOf(rooms, rooms.length - 1);

        System.out.println("Room deleted successfully!\n");
    }
}
