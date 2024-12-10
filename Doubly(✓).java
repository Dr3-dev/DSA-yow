
package FinalProject;

public class Doubly {
    private static class Node {
        Hotel hotel;
        Node next;
        Node prev;

        Node(Hotel hotel) {
            this.hotel = hotel;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public Doubly() {
        this.head = null;
    }
        // Insert a new node at the end
        public void addRoom(int rmno, String rmdesc, String rmtype, double price, String bookst) {
        Hotel addRoom = new Hotel(rmno, rmdesc, rmtype, price, bookst);
        Node newNode = new Node(addRoom);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
            temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
}
}
        // Display the linked list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            
            Node temp = head;
        
            while (temp != null) {
                temp.hotel.hotelDisplay();
                System.out.println(" <-> ");
                temp = temp.next;
            }
        System.out.println("null");
        }
    }
    // Display the linked list in backward direction
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
       
            while (temp.next != null) {
                temp = temp.next;
        }
        
            while (temp != null) {
                temp.hotel.hotelDisplay();
                System.out.println(" <-> ");
                temp = temp.prev;
        }
            System.out.println("null");
        }
    }
    // Delete a node by value
    public boolean delete(int rmno) {
        if (head == null) {
            System.out.println("List is Empty!");
            return false;
        }
        Node temp = head;
        // If the node to be deleted is the head
        if (head.hotel.getRoomNum() == rmno) {
            head = head.next; 
            System.out.println("Room " + rmno + " has been successfully deleted.");
            return true;
        }
        
        while (temp.next != null && temp.next.hotel.getRoomNum() != rmno) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
        temp.next = temp.next.next;
        }
        return false;
    }
}
