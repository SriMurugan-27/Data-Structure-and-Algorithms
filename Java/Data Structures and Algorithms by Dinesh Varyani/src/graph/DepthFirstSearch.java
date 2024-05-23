package graph;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public DepthFirstSearch(int V,int E, LinkedList<Integer>[] adj){
        this.V = V;
        this.E = E;
        this.adj = adj;
    }

    public void dfs(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");
                for(int v : adj[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }
    public void dfsRec(){
        boolean[] visited = new boolean[V];
        for(int u = 0; u < V; u++){
           if(!visited[u]){
               dfsRec(u, visited);
           }
        }
    }

    private void dfsRec(int u, boolean[] visited){
        visited[u] = true;
        System.out.print(u + " ");
        for(int v : adj[u]){
            if(!visited[v]){
                dfsRec(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        LinkedGraph g = new LinkedGraph(6);

        g.addEdge(0, 3);
        g.addEdge(3,2);
        g.addEdge(2, 4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);

/*        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2, 4);*/

//        System.out.println(g);
        DepthFirstSearch d = new DepthFirstSearch(g.getVertices(), g.getEdges(), g.getAdj());
//        d.dfs(0);
        d.dfsRec();
    }
}
