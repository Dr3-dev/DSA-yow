package FinalProject;

import java.util.Scanner;

public class MainMenu {
    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        

    int lp = 0, lp1 = 0;
    String uname = "admin";
    String pword = "admin123";
    
    while(lp == 0){
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        if (username.equals(uname)&& password.equals(pword)) {
        while(lp1 == 0){
            System.out.println("""
                               
                            MAIN MENU                      
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
            System.out.print("Enter Choice:   ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("ARRAYS & POINTERS");
                    break;
                case 2:
                    LLMain linkedlist = new LLMain();
                    System.out.println("LINKED LIST");
                    linkedlist.LLMain();
                    break;
                case 3:
                    System.out.println("STACK DATA STRUCTURE");
                    break;
                case 4:
                    System.out.println("QUEUE DATA STRUCTURE");
                    break;
                case 5:
                    System.out.println("SEARCH AND SORTING ALGORITHM");
                    break;
                case 6:
                    System.out.println("HASH TABLE");
                    break;
                case 7:
                    System.out.println("TREE DATA STRUCTURE");
                    break;
                case 8:
                    Members members = new Members();
                    System.out.println("MEMBERS");
                    members.Members();
                    break;
                case 0:
                    System.out.println("Logging-Out...");
                    lp1++;
                    lp++;
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again.");
                    break;
            }
        }    
        }else{
            System.out.println("Invalid Username or Password. Try Again");    
        }
    }
}   
}
