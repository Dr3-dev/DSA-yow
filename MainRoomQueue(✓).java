import java.util.Scanner;
public class MainRoomQueue {

	public static void main(String[] args) {
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
