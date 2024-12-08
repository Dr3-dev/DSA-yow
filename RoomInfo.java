class Room{
    int RMNO;
    String RMDESC;
    String RMTYPE;
    double PRICE;
    String BOOKST;
    
    public Room(int RMNO, String RMDESC, String RMTYPE, double PRICE, String BOOKST){
        this.RMNO = RMNO;
        this.RMDESC = RMDESC;
        this.RMTYPE = RMTYPE;
        this.PRICE = PRICE;
        this.BOOKST = BOOKST;
    }
    
    public int getRMNO(){
        return RMNO;
    }
    
    public String getRMDESC(){
        return RMDESC;
    }
    
    public String getRMTYPE(){
        return RMTYPE;
    }
    
    public double getPRICE(){
        return PRICE;
    }
    
    public String BOOKST(){
        return BOOKST;
    }
    
    public void DisplayInfo(){
        System.out.println("Room ID: " + RMNO);
        System.out.println("Description: " + RMDESC);
        System.out.println("Room Type: " + RMTYPE);
        System.out.println("Price: " + PRICE);
        System.out.println("Book Status: " + BOOKST);
        System.out.println();
    }
}
