import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }
}


class Graph {
    private int numVertices;
    private LinkedList<Integer> adj[];
    private boolean[] visited;
    private Queue<Integer> queue;

    public Graph(int vertices) {
        numVertices = vertices;
        adj = new LinkedList[vertices];
        visited = new boolean[vertices];
        queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void BFS(int vertex) {
        queue.clear();
        queue.add(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print(vertex + " ");
            Iterator ite = adj[vertex].listIterator();
            while (ite.hasNext()) {
                int adj = (int) ite.next();
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }
}
