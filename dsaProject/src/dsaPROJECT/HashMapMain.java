import java.util.Scanner;

public class HashMapMain {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> rooms = new HashMap<>();
        HashMap<String, String> hashMapDemo = new HashMap<>();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("-----Hash Function Menu-----");
            System.out.println("[1] Hash Function");
            System.out.println("[2] Hash Collision");
            System.out.println("[3] Sample Applications");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": // Hash Function
                    System.out.println("---- Hash Function ----");
                    hashMapDemo.Hash_Function();
                    break;

                case "2": // Hash Collision
                    System.out.println("---- Hash Collision ----");
                    hashMapDemo.hashCollision();
                    break;

                case "3": // Sample Applications
                    System.out.println("---- Sample Applications ----");
                    hashMapDemo.sampleApplication();
                    break;

                case "0": // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    isRunning = false;
                    break;

                default: // Invalid input
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
        }

        sc.close();
    }
}
