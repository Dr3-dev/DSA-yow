package Algorithms;
import java.util.Scanner;

public abstract class SearchAlgorithms {
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



