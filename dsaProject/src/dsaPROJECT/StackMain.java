package dsaPROJECT;

import java.util.Scanner;
import java.util.Stack;
//========================================================================================================
class Room{
    int RMNO;
    String RMDESC;
    String RMTYPE;
    double PRICE;
    String BOOKST;
    
    public Room(int RMNO, String RMDESC, String RMTYPE, double PRICE, String BOOKST){
        this.RMNO = RMNO;
        this.RMDESC = RMDESC;
        this.RMTYPE = RMTYPE;
        this.PRICE = PRICE;
        this.BOOKST = BOOKST;
    }
    
    public int getRMNO(){
        return RMNO;
    }
    
    public String getRMDESC(){
        return RMDESC;
    }
    
    public String getRMTYPE(){
        return RMTYPE;
    }
    
    public double getPRICE(){
        return PRICE;
    }
    
    public String BOOKST(){
        return BOOKST;
    }
    
    public void DisplayInfo(){
        System.out.println("Room ID: " + RMNO);
        System.out.println("Description: " + RMDESC);
        System.out.println("Room Type: " + RMTYPE);
        System.out.println("Price: " + PRICE);
        System.out.println("Book Status: " + BOOKST);
        System.out.println();
    }
}
//========================================================================================================
public class StackMain {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        StackOperations operations = new StackOperations();
        StackOperations.StackClass stackClass = operations.new StackClass();
        int choice;
        
        while(true){
            System.out.println("\n--- Stack Data Structure ---");
            System.out.println("[1] Stack Using Array");
            System.out.println("[2] Stack Using Linked List");
            System.out.println("[3] Stack Class");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            if(choice == 1){
                operations.StackArrayOperations();
            }else if(choice == 2){
                operations.StackLinkedListOperations();
            }else if(choice == 3){
                operations.stackClassOperations(sc, stackClass);
            }else if(choice == 0){
                System.out.println("Exiting program. Thank you!");
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
//========================================================================================================
class StackOperations {
    public static void StackArrayOperations(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum size of stack: ");
        int maxSize = sc.nextInt();
        StackArray stackArray = new StackArray(maxSize);
        boolean isActive = true;
        
        while(true){
            System.out.println("\n--- Stack Using Array ---");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. View Top Room");
            System.out.println("4. Display All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 1){
                System.out.print("Enter Room ID: ");
                int RMNO = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Description: ");
                String RMDESC = sc.nextLine();
                System.out.print("Enter Room Type: ");
                String RMTYPE = sc.nextLine();
                System.out.print("Enter Price: ");
                double PRICE = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Booking Status: ");
                String BOOKST = sc.nextLine();
                
                Room room = new Room(RMNO, RMDESC, RMTYPE, PRICE, BOOKST);
                stackArray.push(room);
                
            }else if(choice == 2){
                stackArray.pop();
            }else if(choice == 3){
                Room topRoom = stackArray.peek();
                if(topRoom != null){
                    System.out.println("Top Room: ");
                    topRoom.DisplayInfo();
                }
            }else if(choice == 4){
                stackArray.Display();
            }else if(choice == 5){
                System.out.println("Exiting...");
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void StackLinkedListOperations(){
        Scanner sc = new Scanner(System.in);
        StackLinkedList stackLinkedList = new StackLinkedList();
        boolean isActive = true;
        
        while(true){
            System.out.println("\n--- Stack Using Linked List ---");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. View Top Room");
            System.out.println("4. Display All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 1){
                System.out.print("Enter Room ID: ");
                int RMNO = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Description: ");
                String RMDESC = sc.nextLine();
                System.out.print("Enter Room Type: ");
                String RMTYPE = sc.nextLine();
                System.out.print("Enter Price: ");
                double PRICE = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Booking Status: ");
                String BOOKST = sc.nextLine();
                
                Room room = new Room(RMNO, RMDESC, RMTYPE, PRICE, BOOKST);
                stackLinkedList.push(room);
                
            }else if(choice == 2){
                stackLinkedList.pop();
            }else if(choice == 3){
                Room topRoom = stackLinkedList.peek();
                if(topRoom != null){
                    System.out.println("Top Room: ");
                    topRoom.DisplayInfo();
                }
            }else if(choice == 4){
                stackLinkedList.Display();
            }else if(choice == 5){
                System.out.println("Exiting...");
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
//========================================================================================================
class StackClass{
        private Stack<Room> stack;
        
        public StackClass(){
            stack = new Stack<>();
        }
        
        public void push(Room room){
            stack.push(room);
            System.out.println("Room added: " + room.getRMNO());
        }
        
        public Room pop(){
            if(!stack.isEmpty()){
                Room removedRoom = stack.pop();
                System.out.println("Room removed: ");
                removedRoom.DisplayInfo();
                return removedRoom;
            }else{
                System.out.println("Stack is empty, no rooms to remove.");
                return null;
            }
        }
        
        public void viewTop(){
            if(!stack.isEmpty()){
                System.out.println("Top room: ");
                stack.peek().DisplayInfo();
            }else{
                System.out.println("No rooms in stack");
            }
        }
        
        public void DisplayAll(){
            if(stack.isEmpty()){
                System.out.println("Stack is empty, no rooms to display");
            }else{
                System.out.println("Rooms in stack: ");
                for(Room room : stack){
                    room.DisplayInfo();
                }
            }
        }
    }
    
    public void stackClassOperations(Scanner sc, StackClass stackClass){
        while(true){
            System.out.println("\n--- Stack Using Stack Class ---");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. View Top Room");
            System.out.println("4. Display All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 1){
                System.out.print("Enter Room ID: ");
                int RMNO = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Description: ");
                String RMDESC = sc.nextLine();
                System.out.print("Enter Room Type: ");
                String RMTYPE = sc.nextLine();
                System.out.print("Enter Price: ");
                double PRICE = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter Booking Status: ");
                String BOOKST = sc.nextLine();
                
                Room room = new Room(RMNO, RMDESC, RMTYPE, PRICE, BOOKST);
                stackClass.push(room);
            }else if(choice == 2){
                stackClass.pop();
            }else if(choice == 3){
                stackClass.viewTop();
            }else if(choice == 4){
                stackClass.DisplayAll();
            }else if(choice == 0){
                System.out.println("Exiting program. Thank you!");
                break;
            }else{
                System.out.println("Invalid Choice, please try again.");
            }
        }
            
    }
}
//========================================================================================================
class Node{
    Room room;
    Node next;
    
    Node(Room room){
        this.room = room;
        next = null;
    }
}
//========================================================================================================
class StackLinkedList{
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
//========================================================================================================
class StackArray {
    private Room[] stack;
    private int top;
    private int maxSize;
    
    public StackArray(int size){
        maxSize = size;
        stack = new Room[maxSize];
        top = - 1;
    }
    
    public void push(Room room){ // adds
        if(top == maxSize - 1){
            System.out.println("Stack is full, cannot add more rooms.");
            return;
        }
        stack[++top] = room;
        System.out.println("Room added: " + room.RMNO);
    }
    
    public Room pop(){ //removes
        if(isEmpty()){
           System.out.println("Stack underflow, no rooms to remove.");
           return null;
        }
        Room removedRoom = stack[top];
        stack[top] = null;
        top--;
        System.out.println("Room removed: " + removedRoom.RMNO);
        return removedRoom;
    }
    
    public Room peek(){ //shows obj w/o removing
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top];
    }
    
    public boolean isEmpty(){ //para malaman if me laman o wala
        return top == - 1;
    }
    
    public int size(){ //current size ng stack
        return top + 1;
    }
    
    public void Display(){ //pang display laman ng stack >:(
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println("Rooms in stack: ");
        for(int i = 0; i <= top; i++){
            stack[i].DisplayInfo();
        }
    }
    
    public static void main(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum size of the stack: ");
        int maxSize = sc.nextInt();
        StackArray stack = new StackArray(maxSize);
        
        boolean isActive = true; //forda loop
        
    while(isActive){
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
        
        if(choice == 1){ //ADD
            System.out.print("Enter Room ID: ");
            int RMNO = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Description: ");
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
        }else if(choice ==2){ //REMOVE
            stack.pop();
        }else if(choice == 3){ //VIEW
            Room topRoom = stack.peek();
            if(topRoom != null){
                System.out.println("Top room: ");
                topRoom.DisplayInfo();
            }
        }else if(choice == 4){ //DISPLAY ALL
            stack.Display();
        }else if(choice == 5){ //EXIT
            System.out.println("Exiting program. Thank you for using");
            isActive = false;
        }else{
            System.out.println("Invalid choice. Please try again.");
        }
      }
    }
}