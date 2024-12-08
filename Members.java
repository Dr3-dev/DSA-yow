
package FinalProject;

import java.util.Scanner;
public class Members {
    
    public void Members(){
        Scanner sc = new Scanner (System.in);
        
        int loop1 = 0;
        
        while(loop1 == 0){
        System.out.println("""
                           
                            Press: 
                            [1] Austria, Rhyanne Madeline B. 
                            [2] Cedron, Ysabella Mae G. 
                            [3] Delfin, Andre Lean T. 
                            [4] Galvez, Gleizel B. 
                            [5] Mangulabnan, Lean Jeric D.R. 
                            [6] Paraiso, Adrienne Jhoi R. 
                            [7] Torres, Michaella Grace C.
                            [8] Back to Main Menu 
                               
                           """);
            System.out.print("Enter Choice:   ");
        int mem = sc.nextInt();
        
        
        switch (mem) {
            case 1:
                System.out.println("""
                                        Rhyanne Madelinne Austria contributed
                                   to the development of the Queue Data Structures.""");
                break;
            case 2:
                System.out.println("""
                                            Ysabella Mae Cedron contributed 
                                   to the development of the Stack Data Structures.""");
                break;
            case 3:
                System.out.println("""
                                        Andre Lean Delfin contributed 
                                   to the development of the Hash Table.""");
                break;
            case 4:
                System.out.println("""
                                                Gleizel Galvez contributed 
                                   to the development of the Search and Sorting Algorithms.""");
                break;
            case 5:
                System.out.println("""
                                            Lean Jeric Mangulabnan contributed
                                    to the development of the Trees Data Structure.""");
                break;
            case 6:
                System.out.println("""
                                     Adrienne Jhoi Paraiso contributed 
                                   to the development of the Linked List.""");
                break;
            case 7:
                System.out.println("""
                                          Michaella Grace Torres contributed 
                                   to the development of the Arrays and Pointers.""");
                break;
            case 8: 
                loop1 ++;
                break;
            default:
                System.out.println("Invalid Choice. Try Again.");
                break;
        }
        }  
}
}
