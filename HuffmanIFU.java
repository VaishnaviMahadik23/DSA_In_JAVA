import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

 class Node{
    int freq;
    char data;
    Node left;
    Node right;
}
class MyComparator implements Comparator<Node>{
    public int compare(Node x, Node y)
    {
        return x.freq - y.freq;
    }
} 
public class HuffmanIFU{
    public static void printCode(Node root,String s)
    {

        if(root.left==null&&root.right==null&&Character.isLetter(root.data)){
            System.out.println(root.data+":"+s);
            return;
        }
        if(root.left!=null){
            printCode(root.left,s+ "0");
        }
        if(root.right!=null){
            printCode(root.right,s+ "1");
        }
}
public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();

        char[] chardata = new char[n];
        int[] charfreq = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            chardata[i] = sc.next().charAt(0);

            System.out.print("Enter frequency for character " + chardata[i] + ": ");
            charfreq[i] = sc.nextInt();
        }

        PriorityQueue<Node> q=new PriorityQueue<Node>(n,new MyComparator());
    
         for (int i = 0; i < n; i++){
            
            Node hn=new Node();

            hn.data=chardata[i];
            hn.freq=charfreq[i];

            hn.left=null;
            hn.right=null;

            q.add(hn);
        }
        Node root=null;
        while(q.size()>1){

            Node x=q.poll();
            Node y=q.poll();

            Node f=new Node();
            f.freq=x.freq+y.freq;
            f.data='-';

            f.left=x;
            f.right=y;

            root=f;
            q.add(f);
        }
    
        printCode(root,"");

    }
}
