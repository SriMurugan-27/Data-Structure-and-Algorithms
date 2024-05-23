package graph;

public class Graph {

    private int V;
    private int E;
    private int[][] adj;

    public Graph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new int[nodes][nodes];
    }

    public void addEdge(int u, int v){
        this.adj[u][v] = 1;
        this.adj[v][u] = 1;
        this.E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges " + "\n");
        for(int v = 0; v < V; v++){
            sb.append(v + " ");
            for(int w : adj[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        System.out.println(g);
    }
}
