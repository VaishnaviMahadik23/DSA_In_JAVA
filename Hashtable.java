//[Linear Probing Using Without Replacement]
import java.util.*;
import java.io.*;

class HT{
    private int currentSize,maxSize;
    private String[] key;
    private String[] val;

    public HT(int size) 
    {
        maxSize = size;
        currentSize = 0;
        key = new String[maxSize];
        val = new String[maxSize];
    }

    private int Hash(String k) 
    {
        return Integer.parseInt(k)%maxSize;
    }

    public void insert(String k,String v){

        if(currentSize>=maxSize)
        {
            System.out.println("Hash Table is Full,Connot insert new key/data.");
            return;
        }
        int temp=Hash(k);
        int i=temp;
        do{
            if(key[i]==null){
                key[i]=k;
                val[i]=v;
                currentSize++;
                return;
            }
            if(key[i].equals(v)){
                val[i]=v;
                return;
            }
            i=(i+1)%maxSize;

        }while(i!=temp);
    }

    public void display() 
    {
        System.out.println("HashTable");
        for (int i = 0; i < maxSize; i++) 
        {
            if (key[i] != null) 
            {
                System.out.println(i+" "+key[i]+" : "+val[i]);
            }
        }
    }

    public void Delete(String keyToDelete) {
        int i = Hash(keyToDelete);
        int temp = i;
        do {
            if (key[i] != null && key[i].equals(keyToDelete)) {
                key[i] = null; 
                val[i] = null; 
                currentSize--;
                return;
            }
            i = (i + 1) % maxSize;
        } while (i != temp);
    }


    public int getsize(){
        return currentSize;
    }

    public boolean isFull(){
        return currentSize==maxSize;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public void MakeEmpty(){
        currentSize=0;
        key =new String[maxSize];
        val =new String[maxSize];
    }
    public String get(String k){
        int i = Hash(k);
        while(key[i] != null){
            if(key[i].equals(k)){
                return val[i];
            }
            i = (i + 1) % maxSize;
        }
        return null;
    
    }

}
public class HashTable{
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of table:");
        int a = s.nextInt();
        HT h = new HT(a);
        int choice;

        do 
        {
            System.out.println("Operation:\n1.Insert\n2.Display\n3.Delete\n4.Size\n5.Check if Empty\n6.Check if Full\n7.Make Table Empty\n8.Get Data\n0.Exit");
            System.out.println("Enter Your choice:");
            choice = s.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Enter key and value:");
                    String k = s.next();
                    String v = s.next();
                    h.insert(k, v);
                    break;
                
                    case 2:
                    System.out.println("Element of table is:");
                    System.out.println("Index : Key : Value");
                    h.display();
                    break;

                case 3:
                    System.out.println("Enter key to delete:");
                    String keyToDelete = s.next();
                    h.Delete(keyToDelete);
                    break;

                case 4:
                    System.out.println("Current Size: " + h.getsize());
                    break;

                case 5: 
                    if (h.isEmpty()) {
                        System.out.println("Hash Table is empty.");
                    } else {
                        System.out.println("Hash Table is not empty.");
                    }
                    break;

                case 6: 
                        if (h.isFull()) {
                        System.out.println("Hash Table is full.");
                        }   
                        else {
                        System.out.println("Hash Table is not full.");
                        }
                    break;

                case 7:
                    h.MakeEmpty();
                    System.out.println("Hash Table has been emptied.");
                    break;

                case 8:
                    System.out.println("Enetr key to retrieve data:");
                    String searchKey = s.next();
                    String value = h.get(searchKey);
                    if (value != null) {
                        System.out.println("Value for key '" + searchKey + "' is: " + value);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;
                 
                default:
                    System.out.println("Enter a valid choice.");
            }
            h.display();
            System.out.println("Do you Want to continue(0 for Stop/1 for Continue):");
            int b=s.nextInt();
        } while (choice != 0);

    }
}


