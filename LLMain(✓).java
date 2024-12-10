
package FinalProject;

import java.util.LinkedList;
import java.util.Scanner;

public class LLMain {
    
    static Scanner sc = new Scanner (System.in);
    static int rid;
    static String desc, type, status;
    static double price;
   
    public void LLMain(){
        
        Singly singly = new Singly();
        Doubly doubly = new Doubly();
        LinkedList<Hotel> llc = new LinkedList<>(); 
        int loop = 0, loop1 = 0;
        
         while(loop == 0){
            System.out.println("""
                              
                             Press: 
                             [1] Singly Linked List
                             [2] Doubly Linked List
                             [3] Linked List Class
                             [4] Back to Main Menu 
                               
                               """);
            System.out.print("Enter Choice:   ");
            int ch = sc.nextInt();
            
            switch (ch) {
                case 1: //singly LL
                    while(loop1 == 0){
                        System.out.println("""
                                           
                                            Press
                                            [1] Add Reservation
                                            [2] Display All Reservation
                                            [3] Delete Reservation
                                            [4] LinkedList Menu    
                                           
                                           """);
                        System.out.print("Enter Choice:   ");
                        int ch1 = sc.nextInt();     
                        
                        switch (ch1) {
                            case 1:
                                Hotel roomdata = RoomData();
                                System.out.println("=========================");
                                System.out.println("Room Data:");
                                singly.insert(rid, desc, type, price, status);
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
                                break;
                        }
                    }       
                case 2: //doubly LL
                    while(loop1 == 0){
                        System.out.println("""
                                           
                                            Press:
                                            [1] Add Reservation
                                            [2] Display All Reservation
                                            [3] Display All Reservation Backwards
                                            [4] Delete Reservation
                                            [5] LinkedList Menu    
                                           
                                           """);
                        System.out.print("Enter Choice:   ");
                        int ch2 = sc.nextInt();
                        
                        switch (ch2) {
                            case 1:
                                Hotel roomdata = RoomData();
                                doubly.addRoom(rid, desc, type, price, status);
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
                                break;
                        }
                    }
                    
                case 3: //LL class in java 
                    while (loop1 == 0) {
                        System.out.println("""
                                           
                                            Press
                                            [1] Add Reservation in the Beginning
                                            [2] Add Reservation in the End
                                            [3] Display All Reservations
                                            [4] LinkedList Menu 
                                           
                                           """);
                        System.out.print("Enter Choice:   ");
                        int ch3 = sc.nextInt();
                        
                        switch (ch3) {
                            case 1:
                                Hotel roomdata = RoomData();
                                llc.addFirst(roomdata);
                                roomdata.hotelDisplay();
                                System.out.println("");
                                break;
                            case 2:
                                Hotel roomData = RoomData();
                                llc.addLast(roomData);  
                                roomData.hotelDisplay();
                                System.out.println();
                                break;

                            case 3:
                                System.out.println("Reservation Information");
                                if (llc.isEmpty()) {
                                    System.out.println("No reservations available.");
                                } else {
                                    for (Hotel room : llc) {
                                        room.hotelDisplay();
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
                    loop++;
                    loop1++;
                    break;
                default:
                    System.out.println("Invalid Choice. Enter Valid Option");
                    break;      
            }
             loop1 = 0;
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
