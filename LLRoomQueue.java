class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LLRoomQueue {
	private Node front;
	private Node rear;
	private int size;

	private int RMNO;
	private String RMDESC;
	private String RMTYPE;
	private double PRICE;


	public LLRoomQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	public boolean isEmpty() {
		return front == null;
	}


	public void enqueue(int RMNO, String RMDESC, String RMTYPE, double PRICE) {
		Node newNode = new Node(RMNO);
		if (rear == null) { 
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
		System.out.println("Room " + RMNO+
		                   "\n Description: " + RMDESC + "\n Type: " + RMTYPE +
		                   "\n Price: " + PRICE);
		System.out.println(" ");
	}


	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty! Cannot dequeue.");
			return -1;
		}
		int dequeuedValue = front.data;
		front = front.next;
		if (front == null) { 
			rear = null;
		}
		size--;
		System.out.println("Room " + dequeuedValue +" is already booked");
		return dequeuedValue;
	}


	public int peek() {
		if (isEmpty()) {
			System.out.println("No Available Room in the list.");
			return -1;
		}
		return front.data;
	}

	
	public void todisplay() {
		if (isEmpty()) {
			System.out.println("No Available Room in the list .");
			return;
		}

		System.out.println("Available Rooms: ");
		Node temp = front;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
