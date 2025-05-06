
import java.util.Scanner;

public class Kruskal{
    static int[] parent;
    static int INF = 99;

    static int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    static void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    static void kruskalmst(int[][] cost, int v) {
        int mincost = 0;
        parent = new int[v];

        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        int edgeCount = 1;
        while (edgeCount < v ) {
            int min = INF, x = 0, y = 0;

            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
                union(x, y);
                System.out.printf("Edge (%d, %d) with cost %d\n", x, y, min);
                mincost += min;
                edgeCount++;
            
        }

        System.out.println("Minimum cost = " + mincost);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = s.nextInt();

        int[][] cost = new int[v][v];
        System.out.println("Enter the cost adjacency matrix:");

        for (int i = 0; i < v; i++) 
        {
            for (int j = 0; j < v; j++) 
            {
                cost[i][j] = s.nextInt();
            }
        }

        kruskalmst(cost, v);
    }
}