
import java.util.Scanner;
import java.util.*;

public class PrimsG{
    public void prim(int G[][], int v) 
    {
        int mincost = 0;
        int Inf = 99;
        int No_edge = 1;

        boolean[] select = new boolean[v];
        Arrays.fill(select, false); 
        select[0] = true;
        while (No_edge < v) 
        {
            int min = Inf, x = 0, y = 0;
            for (int i = 0; i < v; i++) 
            {
                if (select[i] == true) 
                {
                    for (int j = 0; j < v; j++) 
                    {
                        if (select[j] != true && G[i][j] < min)
                        {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            System.out.printf("Edge (%d, %d) with cost %d\n", x, y, min);
            select[y] = true;
            mincost += G[x][y];
            No_edge++;
        }
        System.out.println("Min Cost is: " + mincost);
    }

    public static void main(String[] args) {
        
        PrimsG g = new PrimsG();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int v = s.nextInt();

        int[][] G = new int[v][v];
        System.out.println("Enter the cost of adjacency matrix:");

        for (int i = 0; i < v; i++) 
        {
            for (int j = 0; j < v; j++) 
            {
                G[i][j] = s.nextInt();
            }
        }
        g.prim(G, v);
    }
}
