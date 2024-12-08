import java.util.Scanner;

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
    
    public static void main(String[] args){
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