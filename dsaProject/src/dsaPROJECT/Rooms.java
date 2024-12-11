import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rooms {
    public static Scanner i = new Scanner(System.in);
    private String RMNO;
    private String RMDESC;
    private String RMTYPE;
    private String PRICE;
    private String BOOKST;

    public Rooms (String RMNO, String RMDESC, String RMTYPE, String PRICE, String BOOKST) {
        this.RMNO = RMNO;
        this.RMDESC = RMDESC;
        this.RMTYPE = RMTYPE;
        this.PRICE = PRICE;
        this.BOOKST = BOOKST;
    }
    public Rooms () {

    }

    public void setRMNO(String RMNO) {
        this.RMNO = RMNO;
    }
    public void setRMDESC(String RMDESC) {
        this.RMDESC = RMDESC;
    }
    public void setRMTYPE(String RMTYPE) {
        this.RMTYPE = RMTYPE;
    }
    public void setPRICE (String PRICE) {
        this.PRICE = PRICE;
    }
    public void setBOOKST(String BOOKST) {
        this.BOOKST = BOOKST;
    }
    public String getRMNO () {
        return RMNO;
    }
    public String getRMDESC () {
        return RMDESC;
    }
    public String getRMTYPE () {
        return RMTYPE;
    }
    public String getPRICE () {
        return PRICE;
    }
    public String getBOOKST () {
        return BOOKST;
    }

    public void saveToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Rooms.txt", true))) {
            writer.write(RMNO + "*" + RMDESC + "*" + RMTYPE + "*" + PRICE + "*" + BOOKST + "*");
            writer.newLine();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Rooms> getFromFile() throws IOException{
        List<Rooms> h = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Rooms.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\*");
                String RMNO = data[0];
                String RMDESC = data[1];
                String RMTYPE = data[2];
                String PRICE = data[3];
                String BOOKST = data[4];
                h.add(new Rooms(RMNO,RMDESC,RMTYPE,PRICE,BOOKST));
            }
        }
        return h;
    }

    public static void add() {
        System.out.println("Enter Room ID -> ");
        String RMNO = i.nextLine();
        System.out.println("Enter Room Description -> ");
        String RMDESC = i.nextLine();
        System.out.println("Enter Room Type -> ");
        String RMTYPE = i.nextLine();
        System.out.println("Enter Room Price -> ");
        String PRICE = i.nextLine();
        System.out.println("Enter Book Status?? -> ");
        String BOOKST = i.nextLine();
        Rooms h = new Rooms(RMNO,RMDESC,RMTYPE,PRICE,BOOKST);
        h.saveToFile();
    }
    public static void display() throws IOException {
        List <Rooms> hotel = (List<Rooms>) Rooms.getFromFile();
        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------"));
        System.out.println(String.format("%9s %3s %5s %9s %5s %14s %5s %11s %10s","Room ID", "|","Room Description" ,"|","Room Type", "|", "Price","|", "Book Status"));
        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------"));
        for(Rooms hh: hotel) {
            System.out.println(String.format("%9s %3s %15s %10s %15s %8s %11s %5s %10s", hh.getRMNO(),"|",hh.getRMDESC() ,"|", hh.getRMTYPE(),"|",hh.getPRICE(),"|",hh.getBOOKST()));
        }
        System.out.println(String.format("%s", "---------------------------------------------------------------------------------------------------"));
    }

}
