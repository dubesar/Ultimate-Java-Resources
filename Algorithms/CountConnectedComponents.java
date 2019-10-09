import java.util.Iterator;
import java.util.LinkedList;

public class CountConnectedComponents {
    public static void main(String args[])
    {
        Graph g = new Graph(9);

        // connected
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // 4 is self connected

        // connected
        g.addEdge(6, 5);
        g.addEdge(7, 5);
        g.addEdge(5, 8);

        System.out.println("Number of connected graphs: " + g.count());
    }
}


class Graph {
    private int numVertices;
    private LinkedList<Integer> adj[];
    private boolean visited[];

    public Graph(int vertices) {
        numVertices = vertices;
        adj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        // change the directed graph to undirected graph
        if (src != dest) {
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }

    int count() {
        int ret = 0;
        visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            if(!visited[i]) {
                DFS(i);
                ++ret;
            }
        }
        return ret;
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        Iterator ite = adj[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = (int) ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }
}
