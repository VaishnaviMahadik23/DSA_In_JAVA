
import java.util.*;

public class DFSGraph {
    int v;
    Stack<Integer>[] adj;


    DFSGraph(int v)
    {
        this.v=v;
        adj=new Stack[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new Stack<>();
        }
    }

    public void pushEdge(int v,int w)
    {
        adj[v].push(w);
    }
    
    public void DFS(int a)
    {
        boolean[] vis=new boolean[v];
        Stack<Integer> s=new Stack<>();
        vis[a]=true;
        s.push(a);

        while(!s.isEmpty())
        {
            int c=s.pop();
            System.out.println(" "+c);

            for(int i=0;i<adj[c].size();i++)
            {
                int next=adj[c].get(i);
                if(!vis[next])
                {
                    vis[next]=true;
                    s.push(next);
                }
            
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the No.of vertices:");
        int v=sc.nextInt();

        DFSGraph g=new DFSGraph(v);

        System.out.println("Enter the No.of edges:");
        int e=sc.nextInt();

        System.out.println("Enter the edges (format:- start end):");
        //while(e!=0)
        for (int i = 0; i < e; i++){
            //System.out.println("Enter the source vertex:");
            int s=sc.nextInt();
            //System.out.println("Enter the destination vertex:");
            int d=sc.nextInt();
            g.pushEdge(s,d);
            //e--;
        }
        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = sc.nextInt();

        System.out.println("DFS traversal starting from vertex " + startVertex + ":");
        g.DFS(startVertex);
        
    }
}














     
