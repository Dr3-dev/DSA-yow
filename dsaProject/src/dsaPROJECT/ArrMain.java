package dsaPROJECT;

import java.util.Scanner;
//========================================================================================================
class ArrMain {
    public static void main() {
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
//========================================================================================================
class OneDimensional {
	public static Scanner scanner = new Scanner(System.in);
    static int[] RMNO;
    static String[] RMDESC;
    static String[] RMTYPE;
    static double[] PRICE;
    static String[] BOOKST; // Booking status as a String

    public static void inputRoomDetails1D() {
        

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
//========================================================================================================
class TwoDimensional {

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
//========================================================================================================
class SampleApplication {

    public static void viewReservations() {
        System.out.println("\n===== Hotel Reservations =====");

        // Header for the table
        System.out.printf("%-10s %-15s %-15s %-10s %-15s\n",
                "RoomID", "RoomDesc", "RoomType", "Price", "Booking Status");
        System.out.println("---------------------------------------------------------------");

        // Display data from OneDimensional class
        if (OneDimensional.RMNO != null && OneDimensional.RMNO.length > 0) {
            for (int i = 0; i < OneDimensional.RMNO.length; i++) {
                System.out.printf("%-10d %-15s %-15s %-10.2f %-15s\n",
                        OneDimensional.RMNO[i],
                        OneDimensional.RMDESC[i],
                        OneDimensional.RMTYPE[i],
                        OneDimensional.PRICE[i],
                        OneDimensional.BOOKST[i]);
            }
        }

        // Display data from TwoDimensional class
        if (TwoDimensional.rooms != null && TwoDimensional.rooms.length > 0) {
            for (Object[] room : TwoDimensional.rooms) {
                System.out.printf("%-10d %-15s %-15s %-10.2f %-15s\n",
                        room[0], room[1], room[2], room[3], room[4]);
            }
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("End of reservations.\n");
    }
}