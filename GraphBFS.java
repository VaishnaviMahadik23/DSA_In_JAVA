import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphBFS {
    int v;
    LinkedList<Integer> adj[];
    Queue<Integer> q;

    GraphBFS(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        q = new LinkedList<>();
    }

    void edge(int v, int w) {
        adj[v].add(w);
    }

    void Bfs(int a) {
        boolean nodes[] = new boolean[v];
        int x;
        nodes[a] = true;
        q.add(a);

        while (!q.isEmpty()) {
            x = q.poll();
            System.out.print(x + " ");

            for (int i = 0; i < adj[x].size(); i++) {
                int visit = adj[x].get(i);

                if (!nodes[visit]) {
                    nodes[visit] = true;
                    q.add(visit);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        GraphBFS graph = new GraphBFS(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format:- start end):");
        for (int i = 0; i < edges; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph.edge(start, end);
        }

        System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("BFS traversal starting from vertex " + startVertex + ":");
        graph.Bfs(startVertex);

        scanner.close();
    }
}
