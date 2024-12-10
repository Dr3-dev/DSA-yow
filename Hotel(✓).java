
package FinalProject;

public class Hotel {
    
   Hotel next; 
   private final int RMNO;
   private final String RMDESC;
   private final String RMTYPE;
   private final double PRICE;
   private final String BOOKST; 

  public Hotel(int RMNO,String RMDESC, String RMTYPE, double PRICE, String BOOKST) {
    this.RMNO = RMNO;
    this. RMDESC = RMDESC;
    this.RMTYPE = RMTYPE;
    this.PRICE = PRICE;
    this.BOOKST = BOOKST;
    this.next = null;
  }
  
  public int getRoomNum(){
      return RMNO;
  }
  public String getDesc(){
      return RMDESC;
  }
  public String getType(){
      return RMTYPE;
  }
  public double getPrice(){
      return PRICE;
  }
  public String getStat(){
      return BOOKST;
  }
  
  void hotelDisplay(){
      System.out.println("=========================");
      System.out.println("Room ID No.: " + getRoomNum());
      System.out.println("Room Description: " + getDesc());
      System.out.println("Room Type: " + getType());
      System.out.println("Price: " + getPrice());
      System.out.println("Book Status: " + getStat());
      System.out.println("");
  }
}
