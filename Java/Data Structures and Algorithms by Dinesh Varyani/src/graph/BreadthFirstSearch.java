package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void bfs(int s,int V,LinkedList<Integer>[] adj){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedGraph g = new LinkedGraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2, 4);

        bfs(0, g.getVertices(), g.getAdj());
    }
}
