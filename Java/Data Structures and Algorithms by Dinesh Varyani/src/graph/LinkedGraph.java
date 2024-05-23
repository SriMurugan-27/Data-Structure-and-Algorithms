package graph;

import java.util.LinkedList;

public class LinkedGraph {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public LinkedGraph(int nodes){
        this.adj = new LinkedList[nodes];
        this.V = nodes;
        this.E = 0;
        for(int i = 0; i < nodes; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
        this.E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges " + "\n");
        for(int i = 0; i < V; i++){
            sb.append(i + " ");
            for(int v : adj[i]){
                sb.append(v + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getVertices(){
        return V;
    }

    public LinkedList<Integer>[] getAdj(){
        return adj;
    }

    public int getEdges(){
        return E;
    }
/*    public static void main(String[] args) {
        LinkedGraph g = new LinkedGraph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        System.out.println(g);
    }*/
}
