import java.util.Arrays;

public class FloydWarshall {
    static final int INF = 10000;

    public static int[][] solve(int graph[][]) {
        int result[][] = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++)
        for (int j = 0; j < graph.length; j++)
        result[i][j] = graph[i][j];

        for (int k = 0; k < graph.length; k++)
        {
            for (int i = 0; i < graph.length; i++)
            {
                for (int j = 0; j < graph.length; j++)
                {
                    result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }

        return result;
    }

    public static void main(String args[])
    {
        int graph[][] =
            {{0, 3, INF, INF, 2},
            {INF, 0, 3, INF, 4},
            {1, INF, 0, 1, 3},
            {INF, 2, INF, 0, INF},
            {4, 5, INF, INF, 0}};

        int result[][] = solve(graph);
        System.out.println(Arrays.deepToString(result));
    }
}