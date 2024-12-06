package Algorithms;
import java.util.Scanner;
public class Menu {
    private String username;
    private String password;
    
    public Menu(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public boolean login(Scanner input) {
        while (true) {
            System.out.println("__________________________");
            System.out.println("\n   LOGIN   ");
            System.out.println("__________________________");
            System.out.print("\nUsername: ");
                String userName = input.nextLine();  
            System.out.print("Password: ");
                String passWord = input.nextLine();  
            System.out.println("");

            if (userName.equals(username) && passWord.equals(password)) {
                System.out.println("Log in successful!");
                return true; 
            } else {
                System.out.println("Incorrect! Please try again."); 
            }
        }
    }

    public int displayMenu(Scanner input){
        System.out.println("""
                           __________________________  
                            
                           MAIN MENU    
                           __________________________
                           
                            Press: 
                            [1] Array & Pointers
                            [2] Linked List
                            [3] Stack Data Structure
                            [4] Queue Data Structure
                            [5] Search and Sorting Algorithms
                            [6] Hash Tables
                            [7] Tree Data Structure
                            [8] Group Members
                            [0] Log-Out
                               
                               """);
                System.out.print("Enter Choice: ");
                    return input.nextInt();
    }
    
    public int displaySearchSortMenu(Scanner input){
        int choice;
        do{
            System.out.println("__________________________");
            System.out.println("\nSEARCH AND SORTING ALGORITHM");
            System.out.println("__________________________");
            System.out.println("\n[1] Search Algorithms");
            System.out.println("[2] Sorting Algorithms");
            System.out.println("[3] Sample Application");
            System.out.println("[0] Back to Main Menu");
            System.out.print("\nEnter your Choice: ");
                choice = input.nextInt();     
                input.nextLine();
                if(choice == 0){
                    return 0;
                }
        
        }while(choice < 0 || choice > 3);
        return choice;
        
    }
    
    public int displaySearchMenu(Scanner input) {
        int choice;
        do {
            System.out.println("__________________________");
            System.out.println("\nSEARCH ALGORITHMS MENU");
            System.out.println("__________________________");
            System.out.println("\n[1] Linear Search");
            System.out.println("[2] Binary Search");
            System.out.println("[3] Interpolation Search");
            System.out.println("[0] Back to Search & Sorting Menu");
            System.out.print("\nEnter your Choice: ");
            choice = input.nextInt();
            input.nextLine();
        } while (choice < 0 || choice > 3);
        return choice;
    }
    public int displaySortMenu(Scanner input) {
        int choice;
        do {
            System.out.println("__________________________");
            System.out.println("\nSORT ALGORITHMS MENU");
            System.out.println("__________________________");
            System.out.println("\n[1] Bubble Sort");
            System.out.println("[2] Selection Sort");
            System.out.println("[3] Insertion Sort");
            System.out.println("[0] Back to Search & Sorting Menu");
            System.out.print("\nEnter your Choice: ");
            choice = input.nextInt();
            input.nextLine();
        } while (choice < 0 || choice > 3);
        return choice;
    }
    public int displaySampleApplicationMenu(Scanner input){
        int choice;
        do {
            System.out.println("__________________________");
            System.out.println("\nSAMPLE APPLICATION MENU");
            System.out.println("__________________________");
            System.out.println("\n[1] Determine if the Room Exists or Not");
            System.out.println("[2] Sort Room ID by Ascending Order");
            System.out.println("[3] Sort Room ID by Descending Order");
            System.out.println("[0] Back to Search & Sorting Menu");
            System.out.print("\nEnter your Choice: ");
            choice = input.nextInt();
            input.nextLine();
        } while (choice < 0 || choice > 3);
        return choice;
    }

}
