package dsaPROJECT;

import java.util.LinkedList;
import java.util.Scanner;
//========================================================================================================
public class LLMain {
    
    static Scanner sc = new Scanner (System.in);
    static int rid;
    static String desc, type, status;
    static double price;
   
    public void LLMain(){
        
        Singly singly = new Singly();
        Doubly doubly = new Doubly();
        LinkedList<LLRooms> llc = new LinkedList<>(); 
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
                                LLRooms roomdata = RoomData();
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
                                LLRooms roomdata = RoomData();
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
                                LLRooms roomdata = RoomData();
                                llc.addFirst(roomdata);
                                roomdata.hotelDisplay();
                                System.out.println("");
                                break;
                            case 2:
                                LLRooms roomData = RoomData();
                                llc.addLast(roomData);  
                                roomData.hotelDisplay();
                                System.out.println();
                                break;

                            case 3:
                                System.out.println("Reservation Information");
                                if (llc.isEmpty()) {
                                    System.out.println("No reservations available.");
                                } else {
                                    for (LLRooms room : llc) {
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
    public static LLRooms RoomData(){
        
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
        
        return new LLRooms(rid, desc, type, price, status) ;
    }
}
//========================================================================================================
class LLRooms {
    
	   LLRooms next; 
	   private final int RMNO;
	   private final String RMDESC;
	   private final String RMTYPE;
	   private final double PRICE;
	   private final String BOOKST; 

	  public LLRooms(int RMNO,String RMDESC, String RMTYPE, double PRICE, String BOOKST) {
	    this.RMNO = RMNO;
	    this. RMDESC = RMDESC;
	    this.RMTYPE = RMTYPE;
	    this.PRICE = PRICE;
	    this.BOOKST = BOOKST;
	    this.next = null;
	  }
	  
	  public int getRoomNum(){
	      return RMNO;
	  }
	  public String getDesc(){
	      return RMDESC;
	  }
	  public String getType(){
	      return RMTYPE;
	  }
	  public double getPrice(){
	      return PRICE;
	  }
	  public String getStat(){
	      return BOOKST;
	  }
	  
	  void hotelDisplay(){
	      System.out.println("=========================");
	      System.out.println("Room ID No.: " + getRoomNum());
	      System.out.println("Room Description: " + getDesc());
	      System.out.println("Room Type: " + getType());
	      System.out.println("Price: " + getPrice());
	      System.out.println("Book Status: " + getStat());
	      System.out.println("");
	  }
	}

//========================================================================================================
class Singly {

 private static class Node {
     LLRooms hotel;
     Node next;

     // Constructor
     Node(LLRooms hotel) {
         this.hotel = hotel;
         this.next = null;
     }
 }

 private Node head;

 public Singly() {
     this.head = null;
 }
 public void insert(int rmno, String rmdesc, String rmtype, double price, String bookst) {
 LLRooms insert = new LLRooms(rmno, rmdesc, rmtype, price, bookst);
 Node newNode = new Node(insert);
 
     if (head == null) {
         head = newNode;
     } else {
         Node temp = head;
     
         while (temp.next != null) {
         temp = temp.next;
     }
     temp.next = newNode;
     }
 }
 
 public void display() {
     if (head == null) {
         System.out.println("List is empty");
     } else {
         Node temp = head;
     
         while (temp != null) {
             temp.hotel.hotelDisplay();
             System.out.println(" -> ");
             temp = temp.next;
     }
     System.out.println("null");
     }
 }
 // Delete a node by value
 public void delete(int rmno) {
     if (head == null) {
     System.out.println("List is empty");
     return;
     }
     // If the node to be deleted is the head
     if (head.hotel.getRoomNum() == rmno) {
         head = head.next;
         System.out.println("Room " + rmno + " has been successfully deleted.");
         return;
     }
     Node temp = head;
     
     while (temp.next != null && temp.next.hotel.getRoomNum() != rmno) {
         temp = temp.next;
     }
     
     if (temp.next == null) {
         System.out.println("Element not found");
     } else {
     temp.next = temp.next.next;
     }
 }    
}
//========================================================================================================
class Doubly {
 private static class Node {
     LLRooms hotel;
     Node next;
     Node prev;

     Node(LLRooms hotel) {
         this.hotel = hotel;
         this.next = null;
         this.prev = null;
     }
 }

 private Node head;

 public Doubly() {
     this.head = null;
 }
     // Insert a new node at the end
     public void addRoom(int rmno, String rmdesc, String rmtype, double price, String bookst) {
     LLRooms addRoom = new LLRooms(rmno, rmdesc, rmtype, price, bookst);
     Node newNode = new Node(addRoom);

     if (head == null) {
         head = newNode;
     } else {
         Node temp = head;
         while (temp.next != null) {
         temp = temp.next;
         }
         temp.next = newNode;
         newNode.prev = temp;
}
}
     // Display the linked list in forward direction
 public void displayForward() {
     if (head == null) {
         System.out.println("List is empty");
     } else {
         
         Node temp = head;
     
         while (temp != null) {
             temp.hotel.hotelDisplay();
             System.out.println(" <-> ");
             temp = temp.next;
         }
     System.out.println("null");
     }
 }
 // Display the linked list in backward direction
 public void displayBackward() {
     if (head == null) {
         System.out.println("List is empty");
     } else {
         Node temp = head;
    
         while (temp.next != null) {
             temp = temp.next;
     }
     
         while (temp != null) {
             temp.hotel.hotelDisplay();
             System.out.println(" <-> ");
             temp = temp.prev;
     }
         System.out.println("null");
     }
 }
 // Delete a node by value
 public boolean delete(int rmno) {
     if (head == null) {
         System.out.println("List is Empty!");
         return false;
     }
     Node temp = head;
     // If the node to be deleted is the head
     if (head.hotel.getRoomNum() == rmno) {
         head = head.next; 
         System.out.println("Room " + rmno + " has been successfully deleted.");
         return true;
     }
     
     while (temp.next != null && temp.next.hotel.getRoomNum() != rmno) {
         temp = temp.next;
     }
     
     if (temp.next == null) {
         System.out.println("Element not found");
     } else {
     temp.next = temp.next.next;
     }
     return false;
 }
}