package graph;

import java.util.LinkedList;

public class ConnectedComponents {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public ConnectedComponents(int V, int E, LinkedList<Integer>[] adj){
        this.V = V;
        this.E = E;
        this.adj = adj;
    }

    public int dfs(){
        boolean[] visited = new boolean[V];
        int[] compId = new int[V];
        int count = 0;
        for(int u = 0; u < V; u++){
            if(!visited[u]){
                dfs(u, visited, compId, count);
                count++;
            }
        }
        return count;
    }

    private void dfs(int u, boolean[] visited, int[] compId, int count){
        visited[u] = true;
        compId[u] = count;
        for(int v : adj[u]){
            if(!visited[v]){
                dfs(v, visited, compId, count);
            }
        }
    }

    public static void main(String[] args) {
        LinkedGraph g = new LinkedGraph(6);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(2,4);

        ConnectedComponents c = new ConnectedComponents(g.getVertices(), g.getEdges(), g.getAdj());
        System.out.println(c.dfs());
    }
}
