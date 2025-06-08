
import java.util.Scanner;

public class MinHeapSort {

    static void HeapSort(int arr[],int n){
        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }

    }

    static void heapify(int arr[] ,int n,int i){

        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left]<arr[smallest]){
            smallest=left;
        }

        if(right<n && arr[right]<arr[smallest]){
            smallest=right;
        }

        if(smallest!=i){
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
            heapify(arr,n,smallest);
        }

    }

    
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n=s.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++){
           arr[i]=s.nextInt();
        }
 
        HeapSort(arr,n);
        System.out.println("Sorted Array is:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
