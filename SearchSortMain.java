package Algorithms;
import java.util.Scanner;

public class SearchSortMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        Menu menu = new Menu("hotel","hotel123");
        
        if(menu.login(input)){
            int choice;
        do{
            choice = menu.displayMenu(input);
        switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.println("ARRAYS & POINTERS");
                    break;
                case 2:
                    System.out.println("LINKED LIST");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("STACK DATA STRUCTURE");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("QUEUE DATA STRUCTURE");
                    break;
                case 5:
                    
                    int choice1;
                    do {
                    
                        choice1 = menu.displaySearchSortMenu(input);
                        if (choice1 == 1) {
                            int searchChoice;
                        do {
                            searchChoice = menu.displaySearchMenu(input);
                            switch (searchChoice) {
                                case 1:
                                    System.out.println("\n===Performing Linear Search===");
                                    linearSearch.addRoom(input);
                                    linearSearch.findRoom(input);
                                    break;
                                case 2:
                                    System.out.println("\n===Performing Binary Search===");
                                    binarySearch.addRoom(input);
                                    binarySearch.findRoom(input);
                                    break;
                                case 3:
                                    System.out.println("\n===Performing Interpolation Search===");
                                    interpolationSearch.addRoom(input);
                                    interpolationSearch.findRoom(input);
                                    break;
                                case 0:
                                    System.out.println("Returning to Search & Sorting Menu");
                                    break;
                                default:
                                    System.out.println("Invalid Choice. Try Again.");
                                    break;
                            }
                        } while (searchChoice != 0); 
                        } else if (choice1 == 2) {
                            int sortChoice;
                        do {
                            sortChoice = menu.displaySortMenu(input);
                            switch (sortChoice) {
                                case 1:
                                    System.out.println("\n===Performing Bubble Sort===");
                                    bubbleSort.addRoom(input);
                                    bubbleSort.sortRoom();
                                    break;
                                case 2:
                                    System.out.println("\n===Performing Selection Sort===");
                                    selectionSort.addRoom(input);
                                    selectionSort.sortRoom();
                                    break;
                                case 3:
                                    System.out.println("\n===Performing Insertion Sort===");
                                    insertionSort.addRoom(input);
                                    insertionSort.sortRoom();
                                    break;
                                case 0:
                                    System.out.println("Returning to Search & Sorting Menu");
                                    break;
                                default:
                                System.out.println("Invalid Choice. Try Again.");
                                break;
                            }
                        } while (sortChoice != 0);
            
                        } else if (choice1 == 3) {
                            int sampleChoice;
                        do{
                            sampleChoice = menu.displaySampleApplicationMenu(input);
                            switch (sampleChoice) {
                                case 1:
                                    System.out.println("\n===Determining if the room exists or not===");
                                    linearSearch.addRoom(input);
                                    linearSearch.findRoomWithMessage(input);
                                    break;
                                case 2:
                                    System.out.println("\n===Sorting Room IDs by Ascending Order===");
                                    bubbleSort.addRoom(input);
                                    bubbleSort.sortRoom();
                                    System.out.println("Successfully sorted Room IDs in ascending order!");
                                    break;
                                case 3: 
                                    System.out.println("\n===Sorting Room IDs by Descending Order===");
                                    bubbleSort.addRoom(input);
                                    bubbleSort.sortRoomDescending();
                                    System.out.println("Successfully sorted Room IDs in descending order!");
                                    break;
                                case 0:
                                    System.out.println("Returning to Search & Sorting Menu");
                                    break;
                                default:
                                    System.out.println("Invalid Choice. Try Again.");
                                    break;
                            }
              
                        }while(sampleChoice != 0);
                        } else if (choice1 == 0) {
                            System.out.println("Returning to Main Menu...");
                        }
                    } while (choice1 != 0);
                    break;
                    
                case 6:
                    System.out.println("");
                    System.out.println("HASH TABLE");
                    break;
                case 7:
                    System.out.println("");
                    System.out.println("TREE DATA STRUCTURE");
                    break;
                case 8:
                    System.out.println("MEMBERS");
                    break;
                case 0:
                    System.out.println("Logging-Out...");
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again.");
                    break;
            }
        
        
        }while(choice != 0);
       }
        
    }
}
