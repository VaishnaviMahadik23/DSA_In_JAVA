
import java.util.Scanner;

class Node
{
        int data;
        Node left,right;
        public Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}

class BT
{
    Node root ,Current;
    public void insert(int data)
    {
        Node newNode= new Node(data);
        if(root==null)
        {
            root=newNode;
        }
        else
        {
            whereToInsert(root,newNode);
        }
    }
    private void whereToInsert(Node current, Node newNode)
    {
        Scanner s=new Scanner(System.in);
        int choice;
        do{
            System.out.println("Element" + current.data + "found.\nWhere do you want to insert?\n left(1) or right(2):" );
       
            choice=s.nextInt();
            if(choice==1)
            {
                if(current.left==null)
                {
                current.left=newNode;
                break;    
                }
                current=current.left;
            }
                else if(choice==2)
            {   
                if(current.right==null)
                {
                    current.right=newNode;
                    break;
                }
                    current=current.right;
            }
                else{
                    System.out.println("Invalid choice\n Enter 1 for left and 2 for right");
                    }

            }while(true);
    }

    public void display() 
    {
        System.out.println("Inorder Traversal:");
        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node Current)
    {
        if (Current != null) 
        {
            inOrderTraversal(Current.left);
            System.out.println(Current.data+ " ");
            inOrderTraversal(Current.right);
        }
    }

    public int countN()
    {
        return countN(root);
    }

    public int countN(Node Current)
    {
        if(Current==null)
        {
            return 0;
        }
        else
        {
            int count=1;
            count += countN(Current.left);
            count += countN(Current.right);
            return count;
        }
    }
    
    public void LeafN()
    {
        LeafN(root);
    }
    public void LeafN(Node Current)
    {
        if(Current==null)
        {
            return;
        }
        if(Current.left==null && Current.right==null)
        {
            System.out.println(Current.data+"");
            return;
        }
        if(Current.left!=null)
        {
            LeafN(Current.left);
        }
        if(Current.right!=null)
        {
            LeafN(Current.right);
        }    
    }

    public int countleaf()
    {
        return countleaf(root);
    }

    public int countleaf(Node Current)
    {
        if(Current==null)
        {
            return 0;
        }
        else if(Current.left==null && Current.right==null){
            return 1;
        }
        else
        {
            return countleaf(Current.left)+countleaf(Current.right);
        }
    }
    
    public int Height()
    {
        return Height(root);
    }
    public int Height(Node Current)
    {
        if(Current==null)
        {
            return 0;
        }
        int leftHeight=Height(Current.left);
        int rightHeight=Height(Current.right);
        int max=Math.max(leftHeight,rightHeight);
        return max+1;
        //return Math.max(leftHeight,rightHeight)+1;
    }
}

public class BinaryT 
{
    public static void main(String[] args) 
    {
        int again;
        BT b=new BT();
        Scanner s=new Scanner(System.in);
        do{
            System.out.println("Operations:-\n1)Insert\n2)Display\n3)Count of Nodes\n4)Leaf Nodes\n5)Count of Leaf \n6)Height of tree\nWhich operation you have to perform?:");
            int choice,data;
            choice=s.nextInt();
            switch(choice)
            {
                case 1:
                System.out.println("Enter element:"); 
                data=s.nextInt();
                b.insert(data);
                break;

                case 2:
                System.out.println("The display elements are:");
                b.display();
                break;

                case 3:
                System.out.println("The Count of nodes is:" +b.countN());
                break;

                case 4:
                System.out.println("The leaf nodes are:" );
                b.LeafN();
                break;

                case 5:
                System.out.println("The Count of leaf is:" +b.countleaf());
                break;

                case 6:
                System.out.println("Height of Tree is:"+b.Height());
                break;
            }
            System.out.println("do you whant to continue(1 for Yes/0 for No):");
            again=s.nextInt();
        }while(again!=0);
    }
}

