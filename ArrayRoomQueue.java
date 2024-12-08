public class ArrayRoomQueue {
	private int [] queue;
	private int rear;
	private int size;
	private int capacity;

	private int RMNO;
	private String RMDESC;
	private String RMTYPE;
	private double PRICE;

	public ArrayRoomQueue(int capacity) { 
		this.capacity = capacity;
		queue = new int[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}


	public boolean isFull() {
		return size == capacity;
	}


	public boolean isEmpty() {
		return size == 0;
	}



	public void enqueue(int RMNO, String RMDESC, String RMTYPE, double PRICE) {
		if (isFull()) {
			System.out.println("Unfortunately, Room "+ RMNO +" cannot enter to the list");
			return;
		}
		rear = (rear + 1) % capacity;
		this.RMNO = RMNO;
		queue[rear] = RMNO;
		size++;
		System.out.println("Room " + RMNO+
		                   "\n Description: " + RMDESC + "\n Type: " + RMTYPE +
		                   "\n Price: " + PRICE);
		System.out.println(" ");
	}


	public int dequeue() {
		if (isEmpty()) {
			System.out.println("There are no rooms in the list; there is nothing to remove.");
		
		}
		int dequeuedRoom = queue[front];
		front = (front + 1) % capacity;
		size--;
		System.out.println("Room " + dequeuedRoom + " is removed to the list");
		return dequeuedRoom;
	}
	
    public void todisplay() {
    if (isEmpty()) { System.out.println("---|All rooms are fully booked.|---"); return;
    }
    System.out.println("Room Available: "); for (int i = 0; i < size; i++) {
    System.out.println("Room "+ queue[(front + i) % capacity] + " ");
    }
    System.out.println();
    }
    
	public void display() {
		System.out.println(" Room Number: " + RMNO +
		                   "\n Description: " + RMDESC + "\n Type: " + RMTYPE +
		                   "\n Price: " + PRICE);
		System.out.println("---------------------------------");

	}
}
