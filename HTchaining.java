import java.util.LinkedList;
import java.util.Scanner;

class Hashtable {
    private LinkedList<Integer>[] table;
    private int size;

    public Hashtable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
       return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        table[index].add(key);
    }

   public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (int key : table[i]) {
                System.out.print(key + " ");
            }
            System.out.println();
        }
    }

    public boolean search(int key) 
    {
        int index = hashFunction(key);
        return table[index].contains(key);
    }
}

public class HTchaining{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int b;
        System.out.println("Enter the size of the hashtable:");
        int size = s.nextInt();
        Hashtable HC = new Hashtable(size);

        do {
            System.out.println("Operations:-\n1)Insert\n2)Display\n3)Search\n4)Exit\nEnter your choice:");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the no.of keys:");
                    int n = s.nextInt();
                    System.out.println("Enter the key to insert:");
                    for (int i = 0; i < n; i++) {
                        int key = s.nextInt();
                        HC.insert(key);
                    }
                    break;
                case 2:
                    System.out.println("Displaying hashtable...");
                    HC.display();
                    break;
                case 3:
                    System.out.println("Enter the key to search element:");
                    int key = s.nextInt();
                    if(HC.search(key)){
                        System.out.println("Element "+key+" is Found");
                    }
                    else{
                        System.out.println("Element "+key+" is not Found");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("Press 1 to continue or 0 to stop:");
            b = s.nextInt();
        } while (b != 0);
    }
}