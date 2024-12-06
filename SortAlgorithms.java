package Algorithms;
import java.util.Scanner;

public abstract class SortAlgorithms {
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
