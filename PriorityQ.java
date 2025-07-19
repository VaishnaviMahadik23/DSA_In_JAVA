import java.util.*;
class PriorityQ {
    static int[] H = new int[50]; 
    static int size = -1;         

    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int leftChild(int i) {
        return (2 * i) + 1;
    }

    static int rightChild(int i) {
        return (2 * i) + 2;
    }

    public static void swap(int i, int j) {
        int temp = H[i];
        H[i] = H[j];
        H[j] = temp;
    }

    static void shiftUp(int i) {
        while (i > 0 && H[parent(i)] > H[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    static void shiftDown(int i) {
        int minIndex = i;
        int left = leftChild(i);

        if (left <= size && H[left] < H[minIndex]) {
            minIndex = left;
        }

        int right = rightChild(i);

        if (right <= size && H[right] < H[minIndex]) {
            minIndex = right;
        }

        if (i != minIndex) {
            swap(i, minIndex);
            shiftDown(minIndex);
        }
    }

    static void insert(int p) {
        size = size + 1;
        H[size] = p;
        shiftUp(size);
    }

    static void remove(int i) {
        if (size < 0) {
            System.out.println("Priority Queue is empty.");
            return;
        }

        H[i] = H[size];
        size = size - 1;

        if (size < 0) {
            return;
        }

        if (i > 0 && H[i] < H[parent(i)]) {
            shiftUp(i);  
        } else {
            shiftDown(i); 
        }
    }

    public static void display() {
        if (size == -1) {
            System.out.println("Priority Queue is empty.");
        } else {
            System.out.print("Priority Queue: ");
            for (int i = 0; i <= size; i++) {
                System.out.print(H[i] + " ");
            }
            System.out.println();
        }
    }

    public static void changePriority(int oldKey, int newKey) {
        int index = -1;
        for (int i = 0; i <= size; i++) {
            if (H[i] == oldKey) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            H[index] = newKey; 
            if (newKey < oldKey) {
                shiftUp(index);
            } else {
                shiftDown(index);
            }
            System.out.println("Changed priority from " + oldKey + " to " + newKey);
        } else {
            System.out.println("Key " + oldKey + " not found in the queue.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Opretions:\n1)Insert\n2)Display\n3)Remove\n4)Change Priority\n5)Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter value to insert: ");
                    int value = scanner.nextInt();
                    insert(value);
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    System.out.println("Enter index to remove: ");
                    int removeIndex = scanner.nextInt();
                    if (removeIndex >= 0 && removeIndex <= size) {
                        remove(removeIndex);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the old key: ");
                    int oldKey = scanner.nextInt();
                    System.out.print("Enter the new key: ");
                    int newKey = scanner.nextInt();
                    changePriority(oldKey, newKey);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!=5);

        
    }
}