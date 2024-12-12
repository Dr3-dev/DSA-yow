package dsaPROJECT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//========================================================================================================
public class HashMap<K, V> {
    private List<MapNode<K, V>> bucket;
    private int capacity; // length of the bucket
    private int size; // number of elements in the map
    private final int initialCapacity = 5; // initial length of the bucket array
    public static Scanner sc = new Scanner(System.in);


    public HashMap() {
        bucket = new ArrayList<>();
        capacity = initialCapacity;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }


    public int customHashFunction(K key) {
        int intKey = (Integer) key;
        return Math.abs(intKey);


    }


    private int getBucketIndex(K key) {
        int hashCode = customHashFunction(key);
        return hashCode % (capacity - 1);
    }



    public int intHashFunction(int key) {
        int hashCode = key;
        return hashCode % (capacity - 1);
    }


    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }head = head.next;
        }return null;
    }


    public void printChainedNodes(int bucketIndex) {
        MapNode<K, V> head = bucket.get(bucketIndex);
        if (head == null) {
            System.out.println("Bucket " + bucketIndex + " is empty.");
        } else {
            System.out.print("Nodes in Bucket " + bucketIndex + ": ");
            while (head != null) {
                System.out.print("[" + head.key + ": " + head.value + "] -> "); head = head.next;
            } System.out.println("null");
        }
    }


    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newEntry = new MapNode<K, V>(key, value);
        head = bucket.get(bucketIndex);
        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);


        double loadFactor = (1.0*size)/capacity;


        System.out.println("inserting key " + key + " " +value);
        System.out.println("Load Factor: " + loadFactor);


        if(loadFactor > 0.7) {
            rehash();
        }


    }


    public void put2(K key, V value) {
        String key1 = (String) key;
        int bucketIndex = stringHashFunction(key1) % capacity;
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newEntry = new MapNode<K, V>(key, value);
        head = bucket.get(bucketIndex);
        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);


        double loadFactor = (1.0*size)/capacity;


        System.out.println("inserting key " + key + " " +value);
        System.out.println("Load Factor: " + loadFactor);


        if(loadFactor > 0.7) {
            rehash();
        }


    }


    private void rehash() {
        System.out.println("Rehasing buckets");
        List<MapNode<K, V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity *= 2;
        for(int i=0; i<capacity; i++) {
            bucket.add(null);
        }
        size = 0;


        for(int i=0; i<temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }


    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        MapNode<K, V> prev = null;
        while(head != null) {
            if(head.key.equals(key)) {
                if(prev == null) {
                    bucket.set(bucketIndex, head.next);
                }else {
                    prev.next = head.next;
                }
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }
    public int stringHashFunction(String key) {


        int hash = 0;
        for(int i=0; i<key.length(); i++) {
            hash = hash*31 + key.charAt(i);
        }
        return hash;
    }

    public void Hash_Function() {
        System.out.println("Choose data type to enter a key [1]String, [2]integer: ");
        String dataType = sc.nextLine();
        switch(dataType) {
            case "1":
                System.out.println("Enter a key: ");
                String key = sc.nextLine();
                int hashed = stringHashFunction(key);
                System.out.println("Hash Code for " +"'"+key+"'"+":"+hashed);
                int hashedIndex = hashed % capacity;
                System.out.println("Index in the Hash Table: " + hashedIndex);
                break;
            case "2":
                System.out.println("Enter a key: ");
                int intKey = sc.nextInt();
                int hashedIntKey = intKey % (capacity - 1);
                System.out.println("Hash Code for " +intKey+":" + hashedIntKey);
                System.out.println("Index in the Hash Table: " + hashedIntKey%capacity);
                break;
            default:
                System.out.println("Invalid Try again:");
        }
    }


    public void hashCollision() {
        HashMap<Integer, String> inthashDemo = new HashMap<>();
        HashMap<String, String> strhashDemo = new HashMap<>();
        System.out.println("Choose data type to enter a key [1]String, [2]integer: ");
        String dataType = sc.nextLine();


        switch(dataType) {
            case "1":


                System.out.println("Enter a key");
                String strKey = sc.nextLine();
                System.out.println("Enter a value");
                String value1 = sc.nextLine();
                strhashDemo.put2(strKey, value1);
                System.out.println("Enter another key");
                String strKey2 = sc.nextLine();
                System.out.println("Enter another value");
                String value2 = sc.nextLine();
                strhashDemo.put2(strKey2, value2);
                int hashedKey = stringHashFunction(strKey);
                int hashedIndex = hashedKey % capacity;
                int hashedKey2 = stringHashFunction(strKey2);
                int hashedIndex2 = hashedKey2 % capacity;
                System.out.println("Hash Code for "+"'"+strKey+"': "+hashedKey);
                System.out.println("Index in Hash Table: "+ hashedIndex);
                System.out.println("Hash Code for "+"'"+strKey2+"': "+hashedKey2);
                System.out.println("Index in Hash Table: "+ hashedIndex2);
                if(hashedIndex == hashedIndex2) {
                    System.out.println("Collision Occurred!, Using Separate Chaining..");
                    strhashDemo.printChainedNodes(hashedIndex);




                }else {
                    System.out.println("No hash collision occurred, try entering two values that will have the same index value!");
                }break;
            case "2":


                System.out.println("Enter a key");
                int intKey = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter a value");
                String val1 = sc.nextLine();
                inthashDemo.put(intKey, val1);
                System.out.println("Enter another key");
                int intKey2 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter another value");
                String val2 = sc.nextLine();
                inthashDemo.put(intKey2, val2);
                int hKey = intHashFunction(intKey);
                int hIndex = hKey % capacity;
                int hKey2 = intHashFunction(intKey2);
                int hIndex2 = hKey2 % capacity;
                System.out.println("Hash Code for "+"'"+intKey+"': "+hKey);
                System.out.println("Index in Hash Table: "+ hIndex);
                System.out.println("Hash Code for "+"'"+intKey2+"': "+hKey2);
                System.out.println("Index in Hash Table: "+ hIndex2);
                if(hIndex == hIndex2) {
                    System.out.println("Collision Occurred!, Using Separate Chaining..");
                    inthashDemo.printChainedNodes(hIndex);




                }else {
                    System.out.println("No hash collision occurred, try entering two values that will have the same index value!");
                }break;
        }
    }


    public void sampleApplication() {
        HashMap<String, Rooms> roomMap = new HashMap<>();
        while (true) {
            System.out.println("---------Sample Application---------");
            System.out.println("Add[1]\nDisplay[2]\nUpdate[3]\nDelete[4]\nDisplay all[5]\nQuit[6]");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": // Add
                    System.out.println("Enter Room ID -> ");
                    String roomId = sc.nextLine();
                    System.out.println("Enter Room Description -> ");
                    String roomDesc = sc.nextLine();
                    System.out.println("Enter Room Type -> ");
                    String roomType = sc.nextLine();
                    System.out.println("Enter Room Price -> ");
                    String roomPrice = sc.nextLine();
                    System.out.println("Enter Book Status -> ");
                    String roomBookStatus = sc.nextLine();
                    // Create a new Rooms object and save to file
                    Rooms newRoom = new Rooms(roomId, roomDesc, roomType, roomPrice, roomBookStatus);
                    newRoom.saveToFile();
                    // Add the room to the HashMap
                    roomMap.put(roomId, newRoom);
                    System.out.println("Room added successfully!");
                    break;
                case "2": // Display single room
                    System.out.print("Enter Room ID to display -> ");
                    String roomIdToDisplay = sc.nextLine();
                    Rooms room = roomMap.get(roomIdToDisplay);
                    if (room != null) {
                        System.out.println("Room Details: ");
                        System.out.println("Room ID: " + room.getRMNO());
                        System.out.println("Description: " + room.getRMDESC());
                        System.out.println("Type: " + room.getRMTYPE());
                        System.out.println("Price: " + room.getPRICE());
                        System.out.println("Book Status: " + room.getBOOKST());
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;
                case "3": // Update
                    System.out.print("Enter Room ID to update -> ");
                    String roomIdToUpdate = sc.nextLine();
                    Rooms roomToUpdate = roomMap.get(roomIdToUpdate);
                    if (roomToUpdate != null) {
                        System.out.println("Enter new details for the room.");
                        System.out.print("New Description -> ");
                        roomToUpdate.setRMDESC(sc.nextLine());
                        System.out.print("New Type -> ");
                        roomToUpdate.setRMTYPE(sc.nextLine());
                        System.out.print("New Price -> ");
                        roomToUpdate.setPRICE(sc.nextLine());
                        System.out.print("New Book Status -> ");
                        roomToUpdate.setBOOKST(sc.nextLine());
                        System.out.println("Room updated successfully!");
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;
                case "4": // Delete
                    System.out.print("Enter Room ID to delete -> ");
                    String roomIdToDelete = sc.nextLine();
                    if (roomMap.get(roomIdToDelete) != null) {
                        roomMap.remove(roomIdToDelete);
                        System.out.println("Room deleted successfully!");
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;
                case "5": // Display all
                    try {
                        Rooms.display();
                    } catch (IOException e) {
                        System.out.println("Error displaying rooms: " + e.getMessage());
                    }
                    break;
                case "6": // Quit
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

//=======================================================================================================
    private class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;


        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    
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
//========================================================================================================
class Rooms {
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