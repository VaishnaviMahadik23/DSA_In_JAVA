import java.util.Scanner;

class Node
{
        int key;
        Node left,right;
        public Node(int key)
    {
        this.key=key;
        left=right=null;
    }
}
class BST{
    Node root;
        public void insert(int key) {
            root =insert(root,key);
        }
        public Node insert(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            } else {
                if (key < root.key) {
                    root.left = insert(root.left, key);
                } else if (key >= root.key) {
                    root.right = insert(root.right, key);
                }
            }
            return root;
   }

    public void display() 
    {
        System.out.println("Inorder Traversal:");
        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node root)
    {
        if (root != null) 
        {
            inOrderTraversal(root.left);
            System.out.print(root.key+" ");
            inOrderTraversal(root.right);
        }
    }
    int minvalue(Node root){
        int min=root.key;
        while(root.left!=null){
            min=root.left.key;
            root=root.left;
        }
        return min;
    }
    int maxvalue(Node root){
        int max=root.key;
        while(root.right!=null){
            max=root.right.key;
            root=root.right;
        }
        return max;
    }
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key> root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minvalue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
        
    }
}
public class BSearchT
{
    public static void main(String[] args) 
    {
        int again;
        BST b=new BST();
        Scanner s=new Scanner(System.in);
        do{
            System.out.println("Operations:-\n1)Insert \n2)Display\n3)Minvalue\n4)Maxvalue\n5)Delete\nWhich operation you have to perform?:");
            int choice,key;
            choice=s.nextInt();
            switch(choice)
            {
                case 1:
                System.out.println("Enter element:");
                key=s.nextInt();
                b.insert(key);
                break;

                case 2:
                System.out.println("The display elements are:");
                b.display();
                System.out.println();
                break;

                case 3:
                System.out.println("Minimum value is:"+b.minvalue(b.root) );
                break;

                case 4:
                System.out.println("Maximum value is:"+b.maxvalue(b.root));
                break;

                case 5:
                System.out.println("Enter element to delete:");
                key=s.nextInt();
                b.delete(key);
                break;
            }
            System.out.println("do you whant to continue(1 for Yes/0 for No):");
            again=s.nextInt();
        }while(again!=0);
        s.close();
    }
}
