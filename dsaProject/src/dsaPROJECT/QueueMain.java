package dsaPROJECT;

import java.util.Scanner;
public class QueueMain {

	public static void main() {
		Scanner sc = new Scanner (System.in);

		System.out.println("Queue in Data Structure in Java");
		System.out.println("Choose Mode \n [1] Queue using Array \n [2] Queue using Linklist \n [0] Back to Main Menu");
		System.out.print("Enter Mode: ");
		int ans = sc.nextInt();

		if (ans==1) {

			System.out.println("|Welcome to Queue using Array|");
			ArrayRoomQueue aq = new ArrayRoomQueue(10); //capacity

			System.out.println ("--------------|ROOM LIST|----------------- "); //sample room list
			aq.enqueue (101, "Standard room with a queen bed and a city view.", "Standard", 1000.00);
			aq.enqueue (102, "Deluxe room with two double beds and a balcony.", "Deluxe", 1500.00);
			aq.enqueue (201, "Luxurious suite with a king bed, living area, and kitchenette.", "Suite", 2500.00);
			aq.enqueue (202, "Standard room with a single bed and en-suite bathroom.", "Standard", 800.00);
			aq.enqueue (301, "Family suite with two bedrooms and a shared bathroom.", "Family", 30000.00);
			aq.enqueue (302, "Deluxe room with a king bed, ocean view, and complimentary breakfast.", "Deluxe", 2000.00);
			aq.enqueue (401, "Economy room with a queen bed and basic amenities.", "Standard", 700.00);
			aq.enqueue (402, "Executive suite with a king bed, office space, and luxury bath.", "Suite", 3000.00);
			aq.enqueue (501, "Penthouse suite with panoramic views and a private terrace.", "Suite", 5000.00);

			int arract;

			do {
				System.out.println("Choose Action: \n [1] To See Available Room \n [2] To Remove the first Room in the List \n [3] To Add a Room \n [0] Exit \n");
				System.out.print("Choice: ");
				arract =  sc.nextInt();
				System.out.println(" ");

				if (arract==1) {
					aq.todisplay();
					System.out.println(" ");
				}
				else if (arract==2) {
					aq.dequeue();
					System.out.println(" ");
				}
				else if (arract==3) {
					System.out.println("Add Room");
					System.out.println("Room No.: ");
					int RMNO = sc.nextInt();
					System.out.println("Description: ");
					String RMDESC = sc.nextLine();
					System.out.println("Room Type: ");
					String RMTYPE = sc.nextLine();
					System.out.println("Price: ");
					double PRICE = sc.nextDouble();

					aq.enqueue(RMNO,RMDESC,RMTYPE,PRICE);

					System.out.println(" ");
				}
				else if (arract==0) {
					System.out.println("Exit from Array Queue Usage");
				}

			} while (arract != 0 && arract <= 3);

		}

		else if (ans==2) {

			System.out.println("|Welcome to Queue using Linked List|");
			LLRoomQueue lq = new LLRoomQueue();

			System.out.println ("--------------|ROOM LIST|----------------- ");
			lq.enqueue (101, "Standard room with a queen bed and a city view.", "Standard", 1000.00);
			lq.enqueue (102, "Deluxe room with two double beds and a balcony.", "Deluxe", 1500.00);
			lq.enqueue (201, "Luxurious suite with a king bed, living area, and kitchenette.", "Suite", 2500.00);
			lq.enqueue (202, "Standard room with a single bed and en-suite bathroom.", "Standard", 800.00);
			lq.enqueue (301, "Family suite with two bedrooms and a shared bathroom.", "Family", 30000.00);
			lq.enqueue (302, "Deluxe room with a king bed, ocean view, and complimentary breakfast.", "Deluxe", 2000.00);
			lq.enqueue (401, "Economy room with a queen bed and basic amenities.", "Standard", 700.00);
			lq.enqueue (402, "Executive suite with a king bed, office space, and luxury bath.", "Suite", 3000.00);
			lq.enqueue (501, "Penthouse suite with panoramic views and a private terrace.", "Suite", 5000.00);
			lq.enqueue (502, "Two-bedroom family room with kitchen facilities.", "Family", 3500.00);

			int arract;

			do {
				System.out.println("Choose Action: \n [1] To See Available Room \n [2] To Remove the first Room in the List \n [3] To Add a Room \n [0] Exit ");
				System.out.print("Choice: ");
				arract =  sc.nextInt();
				System.out.println(" ");

				if (arract==1) {
					lq.todisplay();
					System.out.println(" ");
				}
				else if (arract==2) {
					lq.dequeue();
					System.out.println(" ");
				}
				else if (arract==3) {
					System.out.println("Add Room");
					System.out.println("Room No.: ");
					int RMNO = sc.nextInt();
					System.out.println("Description: ");
					String RMDESC = sc.nextLine();
					System.out.println("Room Type: ");
					String RMTYPE = sc.nextLine();
					System.out.println("Price: ");
					double PRICE = sc.nextDouble();

					lq.enqueue(RMNO,RMDESC,RMTYPE,PRICE);
					System.out.println(" ");
				}
				else if (arract==0) {
					System.out.println("Exit from LinkList Queue Usage");
				}

			} while (arract != 0 && arract <= 3);

		}

		else if (ans==0) {
			System.out.print("Going Back to Main Menu...");
		}

	}

}

class ArrayRoomQueue {
	private int [] queue;
	private int front;
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
    
}
class Node2 {
	int data;
	Node2 next;

	Node2(int data) {
		this.data = data;
		this.next = null;
	}
}

class LLRoomQueue {
	private Node2 front;
	private Node2 rear;
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
		Node2 newNode = new Node2(RMNO);
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
		Node2 temp = front;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}