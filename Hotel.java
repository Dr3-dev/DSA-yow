
package FinalProject;

public class Hotel {
    
   Hotel next; 
   int RMNO;
   String RMDESC;
   String RMTYPE;
   double PRICE;
   String BOOKST; 

  Hotel(int RMNO,String RMDESC, String RMTYPE, double PRICE, String BOOKST) {
    this.RMNO = RMNO;
    this. RMDESC = RMDESC;
    this.RMTYPE = RMTYPE;
    this.PRICE = PRICE;
    this.BOOKST = BOOKST;
    this.next = null;
   }
  void hotelDisplay(){
      System.out.println("=========================");
      System.out.println("Room ID No.: " + RMNO);
      System.out.println("Room Description: " + RMDESC);
      System.out.println("Room Type: " + RMTYPE);
      System.out.println("Price: " + PRICE);
      System.out.println("Book Status: " + BOOKST);
      System.out.println("");
  }
}
