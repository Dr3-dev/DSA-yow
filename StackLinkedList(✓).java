import java.util.Scanner;
        
class Node{
    Room room;
    Node next;
    
    Node(Room room){
        this.room = room;
        next = null;
    }
}

public class StackLinkedList{
    private Node top;
    private int size;
    
    public StackLinkedList(){
        top = null;
        size = 0;
    }
    
    public void push(Room room){ //ADD
        Node newNode = new Node(room);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Room Added: " + room.RMNO);
    }
    
    public Room pop(){
        if(isEmpty()){
            System.out.println("Stack underflow, no rooms to remove.");
            return null;
        }
        Room removedRoom = top.room;
        top = top.next;
        size--;
        System.out.println("Room removed" + removedRoom.RMNO);
        return removedRoom;           
    }
    
    public Room peek(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }
        return top.room;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public int size(){
        return size;
    }
    
    public void Display(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return;
        }
        
        System.out.println("Rooms in stack: ");
        Node temp = top;
        while(temp != null){
            temp.room.DisplayInfo();
            temp = temp.next;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();
        boolean isActive = true;
        
        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. View Top Room");
            System.out.println("4. Display All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");
            
            if(choice == 1){
                System.out.print("Enter Room Number: ");
                int RMNO = sc.nextInt();
                sc.nextLine();
                System.out.print("Room Description: ");
                String RMDESC = sc.nextLine();
                System.out.print("Enter Room Type: ");
                String RMTYPE = sc.nextLine();
                System.out.print("Enter Price: ");
                double PRICE = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Booking Status: ");
                String BOOKST = sc.nextLine();
                
                Room room = new Room(RMNO, RMDESC, RMTYPE, PRICE, BOOKST);
                stack.push(room);
            }else if(choice == 2){
                stack.pop();
            }else if(choice == 3){
                Room topRoom = stack.peek();
                if(topRoom != null){
                    System.out.println("Top Room: ");
                    topRoom.DisplayInfo();
                }
            }else if(choice == 4){
                stack.Display();
            }else if(choice == 5){
                System.out.println("Exiting Program. Thank you for using");
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
