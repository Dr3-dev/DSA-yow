
package FinalProject;

import java.util.LinkedList;
import java.util.Scanner;

public class LLMain {
    static Scanner sc = new Scanner (System.in);
    static int rid;
    static String desc, type, status;
    static double price;
    static Singly singly = new Singly();
    static Doubly doubly = new Doubly();
    static LinkedList<Hotel> llc = new LinkedList<>(); 
    
    public static void main(String[] args) {
        
        int loop = 0, loop1 = 0;
        
        System.out.println("LINKED LIST");
        
         while(loop == 0){
            System.out.println("""
                             Press: 
                             [1] Singly Linked List
                             [2] Doubly Linked List
                             [3] Linked List Class
                             [4] Back to Main Menu """);
            System.out.print("Enter Choice:   ");
            int ch = sc.nextInt();
            System.out.println("");
            
            switch (ch) {
                case 1:
                    while(loop1 == 0){
                        System.out.println("""
                                            Press
                                            [1] Add Reservation
                                            [2] Display All Reservation
                                            [3] Delete Reservation
                                            [4] LinkedList Menu    """);
                        System.out.print("Enter Choice:   ");
                        int ch1 = sc.nextInt();
                        
                        
                        switch (ch1) {
                            case 1:
                                Hotel roomdata = RoomData();
                                System.out.println("=========================");
                                System.out.println("Room Data:");
                                singly.insert(rid, desc, type, price, desc);
                                roomdata.hotelDisplay();
                                break;
                            case 2:
                                System.out.println("Reservation Information:");
                                singly.display();
                                break;
                            case 3:
                                System.out.print("Enter a RoomID to Delete:   ");
                                int roomid = sc.nextInt();
                                singly.delete(roomid);
                                break;
                            case 4:
                                loop1++;
                                break;
                            default:
                                System.out.println("Invalid Choice. Enter Valid Option.");
                        }
                    }       break;
                case 2:
                    while(loop1 == 0){
                        System.out.println("""
                                            Press:
                                            [1] to Add Reservation
                                            [2] Display All Reservation
                                            [3] Display All Reservation Backwards
                                            [4] Delete Reservation
                                            [5] LinkedList Menu    """);
                        System.out.print("Enter Choice:   ");
                        int ch2 = sc.nextInt();
                        
                        switch (ch2) {
                            case 1:
                                Hotel roomdata = RoomData();
                                doubly.addRoom(rid, desc, type, price, desc);
                                roomdata.hotelDisplay();
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Reservation Information:");
                                doubly.displayForward();
                                break;
                            case 3:
                                System.out.println("Reservation Information:");
                                doubly.displayBackward();
                                break;
                            case 4:
                                System.out.print("Enter a RoomID to Delete:   ");
                                int roomid = sc.nextInt();
                                doubly.delete(roomid);
                                break;
                            case 5:
                                loop1++;
                                break;
                            default:
                                System.out.println("Invalid Choice. Enter Valid Option");
                        }
                    }       break;
                case 3:
                    while (loop1 == 0) {
                        System.out.println("""
                                            Press
                                            [1] Add Reservation in the Beginning
                                            [2] Add Reservation in the End
                                            [3] Display All Reservations
                                            [4] LinkedList Menu """);
                        System.out.print("Enter Choice:   ");
                        int ch3 = sc.nextInt();
                        
                        Hotel roomdata = RoomData();
                        
                        switch (ch3) {
                            case 1:
                                
                                llc.addFirst(roomdata);
                                roomdata.hotelDisplay();
                                System.out.println("");
                                break;
                            case 2:
                                llc.addLast(roomdata);
                                roomdata.hotelDisplay();
                                System.out.println("");
                            case 3:
                                System.out.println("Reservation Information");
                                if (llc.isEmpty()) {
                                    System.out.println("No reservations available.");
                                } else {
                                    for (Hotel hotel : llc) {
                                        hotel.hotelDisplay();
                                    }
                                }
                                break;
                            case 4:
                                loop1++;
                                break;
                            default:
                                System.out.println("Invalid Choice. Enter Valid Option");
                        }
                    }       break;
            //main menu
                case 4:
                    break;
                default:
                    System.out.println("Invalid Choice. Enter Valid Option");
                    break;      
            }
        }
    }
    public static Hotel RoomData(){
        
        System.out.println("");
        System.out.print("Enter Room ID: ");
        rid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Room Description: ");
        desc = sc.nextLine();
        System.out.print("Enter Room Type:    ");
        type = sc.nextLine();
        System.out.print("Enter Price: ");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Book Status:    ");
        status = sc.nextLine();
        
        return new Hotel(rid, desc, type, price, status) ;
    }
}
