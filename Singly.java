package FinalProject;

public class Singly {

    private static class Node {
        Hotel hotel;
        Node next;

        // Constructor
        Node(Hotel hotel) {
            this.hotel = hotel;
            this.next = null;
        }
    }

    private Node head;

    public Singly() {
        this.head = null;
    }
    public void insert(int rmno, String rmdesc, String rmtype, double price, String bookst) {
    Hotel insert = new Hotel(rmno, rmdesc, rmtype, price, bookst);
    Node newNode = new Node(insert);
    
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
        
            while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
        
            while (temp != null) {
                temp.hotel.hotelDisplay();
                System.out.println(" -> ");
                temp = temp.next;
        }
        System.out.println("null");
        }
    }
    // Delete a node by value
    public void delete(int rmno) {
        if (head == null) {
        System.out.println("List is empty");
        return;
        }
        // If the node to be deleted is the head
        if (head.hotel.RMNO == rmno) {
            head = head.next;
            return;
        }
        Node temp = head;
        
        while (temp.next != null && temp.next.hotel.RMNO != rmno) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
        temp.next = temp.next.next;
        }
        
    // If room is found and deleted    
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Room " + rmno + " has been successfully deleted.");
            return;
        }
        System.out.println("Room Not Found.");
    }    
}


   
