/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michaela Torres
 */
public class SampleApplication {

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