import java.util.Scanner;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StackOperations operations = new StackOperations();
        int choice;
        
        while(true){
            System.out.println("\n--- Stack Data Structure ---");
            System.out.println("[1] Stack Using Array");
            System.out.println("[2] Stack Using Linked List");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            if(choice == 1){
                operations.StackArrayOperations();
            }else if(choice == 2){
                operations.StackLinkedListOperations();
            }else if(choice == 0){
                System.out.println("Exiting program. Thank you!");
                break;
            }else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
