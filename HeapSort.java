import java.util.Scanner;

public class HeapSort {

    static void Heapsort(int arr[], int n, boolean isMaxHeap) {
        // Build heap
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i, isMaxHeap);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0, isMaxHeap);
        }
    }

    static void heapify(int arr[], int n, int i, boolean isMaxHeap) {
        int extreme = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (isMaxHeap) {
            if (left < n && arr[left] > arr[extreme]) {
                extreme = left;
            }
            if (right < n && arr[right] > arr[extreme]) {
                extreme = right;
            }
        } else {
            if (left < n && arr[left] < arr[extreme]) {
                extreme = left;
            }
            if (right < n && arr[right] < arr[extreme]) {
                extreme = right;
            }
        }

        if (extreme != i) {
            int temp = arr[i];
            arr[i] = arr[extreme];
            arr[extreme] = temp;
            heapify(arr, n, extreme, isMaxHeap);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = s.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("Choose sorting method:");
        System.out.println("1. Max-Heap Sort");
        System.out.println("2. Min-Heap Sort");
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                Heapsort(arr, n, true);
                System.out.println("Sorted array (Max-Heap):");
                break;
            case 2:
                Heapsort(arr, n, false);
                System.out.println("Sorted array (Min-Heap):");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
