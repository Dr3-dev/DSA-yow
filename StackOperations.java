import java.util.Scanner;
import java.util.Stack;

public class StackOperations {
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
    
    public class StackClass{
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
