import java.util.*;

public class Dijkstra{ 
    int total_ver;

    int minDist(int dist[], Boolean vis[]) {
        int m = Integer.MAX_VALUE, m_index = -1;

        for (int vx = 0; vx < total_ver; vx++) {
            if (!vis[vx] && dist[vx] <= m) {
                m = dist[vx];
                m_index = vx;
            }
        }
        return m_index;
    }

    void printSolution(int dist[], int n) {
        System.out.println("The Shortest Distance From Source 0:");
        for (int j = 0; j < n; j++) {
            System.out.println("to " + j + " is: " + dist[j]);  
        }
    }

    void dijkstra(int Graph[][], int s) {
        int dist[] = new int[total_ver];
        Boolean vis[] = new Boolean[total_ver];

        for (int j = 0; j < total_ver; j++) {
            dist[j] = Integer.MAX_VALUE;
            vis[j] = false;
        }
        
        dist[s] = 0;  // Distance from the source vertex to itself
        
        for (int count = 0; count < total_ver - 1; count++) {
            int ux = minDist(dist, vis);
            vis[ux] = true;

            for (int vx = 0; vx < total_ver; vx++) {
                if (!vis[vx] && Graph[ux][vx] != -1 && dist[ux] != Integer.MAX_VALUE && dist[ux] + Graph[ux][vx] < dist[vx]) {
                    dist[vx] = dist[ux] + Graph[ux][vx];  
                }
            }
        }
        printSolution(dist, total_ver);
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No.of Vertices:");
        d.total_ver = sc.nextInt();
        
        int Graph[][] = new int[d.total_ver][d.total_ver];
        System.out.println("Enter the Cost Adjacency matrix:");

        for (int i = 0; i < d.total_ver; i++) {
            for (int j = 0; j < d.total_ver; j++) {
                Graph[i][j] = sc.nextInt();
            }
        }
        d.dijkstra(Graph, 0);   
        sc.close();
    }
}
//0 10 3 -1 -1
//-1 0 1 2 -1
//-1 4 0 8 2
//-1 -1 -1 0 7
//-1 -1 -1 9 0
