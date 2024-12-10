package dsaPROJECT;

import java.util.Scanner;

public class SearchSortMain {
    public static void main() {
        Scanner input = new Scanner(System.in);
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        int choice;
        do {
                    
        	choice = displaySearchSortMenu(input);
            if (choice == 1) {
            	int searchChoice;
                do {
                	searchChoice = displaySearchMenu(input);
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
                        } else if (choice == 2) {
                            int sortChoice;
                        do {
                            sortChoice = displaySortMenu(input);
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
            
                        } else if (choice == 3) {
                            int sampleChoice;
                        do{
                            sampleChoice = displaySampleApplicationMenu(input);
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
                        } else if (choice == 0) {
                            System.out.println("Returning to Main Menu...");
                        }
                    } while (choice != 0);
        while(choice != 0);
    }

    public static int displaySearchSortMenu(Scanner input){
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
    
    public static int displaySearchMenu(Scanner input) {
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
    public static int displaySortMenu(Scanner input) {
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
    public static int displaySampleApplicationMenu(Scanner input){
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
abstract class SearchAlgorithms {
    private int[] rmNo;
    public void addRoom(Scanner input){
        System.out.println("");
        System.out.print("Enter the number of room in the array: ");
            int num = input.nextInt();
            
            rmNo = new int[num];
            for(int i = 0; i < num; i++){
                System.out.println("");
                System.out.print("Enter Room ID No.: ");
                rmNo[i] = input.nextInt();
            }
    }
    
    public int[] getRmNo(){
        return rmNo;
    }
    
    public abstract void findRoom(Scanner input);     
}

class LinearSearch extends SearchAlgorithms{
    @Override
    public void addRoom(Scanner input){
        super.addRoom(input);
    }
    @Override
    public void findRoom(Scanner input) {
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
        
        boolean isFound = false;
        String ans = "";
        
        do{
            do{
                System.out.print("\nEnter the Room ID No. of the room you want to find:  ");
                int findID = input.nextInt();
                input.nextLine();
			
			
            for(int i = 0; i < rmNo.length; i++) {
                if(rmNo[i] == findID) {
                    System.out.println("Room ID No. " + findID + " is found at index " + i);
                    isFound = true;
                    break;
                }
            }
            if(!isFound) {
                System.out.println("Room ID No. " + findID + " is not found! Try again.");
            }
            }while(!isFound);        
            System.out.print("\nWould you like to search room again? YES or NO: ");
                ans = input.nextLine();
                        
                                         
        }while(ans.equalsIgnoreCase("yes"));     
    }
    public void findRoomWithMessage(Scanner input) {
        int[] rmNo = getRmNo();

        if (rmNo == null) {
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }

        String ans = "";
        do {
            System.out.print("\nEnter the Room ID No. of the room you want to find: ");
            int findID = input.nextInt();
            input.nextLine();

            boolean isFound = false;
            for (int i = 0; i < rmNo.length; i++) {
                if (rmNo[i] == findID) {
                    System.out.println("Room exists.");
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Room does not exist.");
            }

            System.out.print("\nWould you like to search room again? YES or NO: ");
            ans = input.nextLine();

        } while (ans.equalsIgnoreCase("yes"));
    }
}

class BinarySearch extends SearchAlgorithms{
    @Override
    public void addRoom(Scanner input){
        super.addRoom(input);
    }
    @Override
    public void findRoom(Scanner input) {
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
 
        String ans = "";
        boolean isFound = false;
        
        do{
            do{ 
            System.out.print("\nEnter the Room ID No. of the room you want to find:  ");
                int findID = input.nextInt();
                input.nextLine();
            int first = 0;
            int last = rmNo.length - 1;
                
            while(first <= last){
                int mid = (first + last) / 2;
		if(rmNo[mid] == findID)	{
                    System.out.println("Room ID No. " + findID + " is found at index " + mid);
                    isFound = true;
                    break;
                }else if(rmNo[mid] < findID){
                    first = mid + 1; 
                }else{
                    last = mid - 1;
                }
            }
            if(!isFound) {
                System.out.println("Room ID No. " + findID + " is not found! Try again.");
            }
            }while(!isFound);   
            System.out.print("\nWould you like to search room again? YES or NO: ");
                ans = input.nextLine();                                
        }while(ans.equalsIgnoreCase("yes"));     
    }
}
class InterpolationSearch extends SearchAlgorithms {
    
    @Override
    public void addRoom(Scanner input){
        super.addRoom(input);
    }
    @Override
    public void findRoom(Scanner input){
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
        
        boolean isFound = false;
        String ans = "";
        
        do{
            do{
            System.out.print("\nEnter the Room ID No. of the room you want to find:  ");
                int findID = input.nextInt();
                input.nextLine();
            int low = 0;
            int mid;
            int high = rmNo.length - 1;
                
            while (low <= high && findID >= rmNo[low] && findID <= rmNo[high]) {
                mid = low + ((findID - rmNo[low]) * (high - low)) / (rmNo[high] - rmNo[low]);

            
		if(rmNo[mid] == findID)	{
                    System.out.println("Room ID No. " + findID + " is found at index " + mid);
                    isFound = true;
                    break;
                }else if(rmNo[mid] < findID){
                    low = mid + 1; 
                }else{
                    high = mid - 1;
                }
            }
            if(!isFound) {
                System.out.println("Room ID No. " + findID + " is not found! Try again.");
            }
            }while(!isFound);  
            System.out.print("\nWould you like to search room again? YES or NO: ");
                ans = input.nextLine();                                
        }while(ans.equalsIgnoreCase("yes"));
    }
}
abstract class SortAlgorithms {
    private int[] rmNo;
    public void addRoom(Scanner input){
        System.out.println("");
        System.out.print("Enter the number of room in the array: ");
            int num = input.nextInt();
            
            rmNo = new int[num];
            for(int i = 0; i < num; i++){
                System.out.println("");
                System.out.print("Enter Room ID No.: ");
                rmNo[i] = input.nextInt();
            }
    }
    
    public int[] getRmNo(){
        return rmNo;
    }
    public void unsortedRoom(){
        System.out.println("\nUnsorted Room IDs");
        for(int num : rmNo){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public abstract void sortRoom();
}
class BubbleSort extends SortAlgorithms {
    @Override
    public void addRoom(Scanner input){
        super.addRoom(input);
    }
    @Override
    public void sortRoom(){
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
        super.unsortedRoom();
               for(int i = 0; i < rmNo.length - 1; i++){
                   for(int j = 0; j < rmNo.length - i - 1; j++){
                       if(rmNo[j] > rmNo[j + 1]){
                           int temp = rmNo[j];
                           rmNo[j]= rmNo[j + 1];
                           rmNo[j + 1] = temp;
                       }
                   }
               }
               System.out.println("\nSorted Room IDs");
               for(int num : rmNo){
                   System.out.print(num + " ");
               }   
               System.out.println();
    }
    public void sortRoomDescending(){
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
        super.unsortedRoom();
               for(int i = 0; i < rmNo.length - 1; i++){
                   for(int j = 0; j < rmNo.length - i - 1; j++){
                       if(rmNo[j] < rmNo[j + 1]){
                           int temp = rmNo[j];
                           rmNo[j]= rmNo[j + 1];
                           rmNo[j + 1] = temp;
                       }
                   }
               }
               System.out.println("\nSorted Room IDs");
               for(int num : rmNo){
                   System.out.print(num + " ");
               }   
               System.out.println();
    }
}
class SelectionSort extends SortAlgorithms{
    @Override
    public void addRoom(Scanner input){
        super.addRoom(input);
    }
    @Override
    public void sortRoom(){
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
        super.unsortedRoom();
        
           for(int i = 0; i < rmNo.length - 1; i++){
               int smallest = i;
               for(int j = i + 1; j < rmNo.length; j++){
                   if(rmNo[j] < rmNo[smallest]){
                       smallest = j;
                   }
               }
               int temp = rmNo[i];
               rmNo[i] = rmNo[smallest];
               rmNo[smallest] = temp;
            }
            System.out.println("\nSorted Room IDs");
                for(int num : rmNo){
                   System.out.print(num + " ");
                }   
                System.out.println();
    }
}
class InsertionSort extends SortAlgorithms{
    @Override
    public void addRoom(Scanner input){
        super.addRoom(input);
    }
    @Override
    public void sortRoom(){
        int[] rmNo = getRmNo();
        
        if(rmNo == null){
            System.out.println("The room list is empty! Please add rooms first.");
            return;
        }
        super.unsortedRoom();   
        
        for(int i = 1; i < rmNo.length; i++){
            int key = rmNo[i];
            int j = i - 1;
            
            while(j >= 0 && rmNo[j] > key){
                rmNo[j + 1] = rmNo[j];
                j--;
            }
            rmNo[j + 1] = key;
        }
        System.out.println("\nSorted Room IDs");
            for(int num : rmNo){
               System.out.print(num + " ");
            }   
            System.out.println();
    }
    
    
    
    
}
