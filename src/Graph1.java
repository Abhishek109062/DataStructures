import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class Graph1 {
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList <Integer>> adj= new ArrayList<>();
        for(int x=0;x<v;x++)
            adj.add(new ArrayList<Integer>(v));

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,1);
        addEdge(adj,1,3);
//
//        printGraph(adj);
        BFS(adj,4,0);
    }

    static void addEdge(ArrayList<ArrayList <Integer>> adj , int u ,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList <Integer>> adj){
        for(int x=0;x<adj.size();x++){
            for(int y=0;y<adj.get(x).size();y++)
                System.out.print(adj.get(x).get(y)+" ");
            System.out.println();
        }
    }

    static void BFS(ArrayList<ArrayList <Integer>> adj, int v, int s){
        boolean[] visited = new boolean[v+1];
        Queue <Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int x:adj.get(u)){
                if(!visited[v]){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }
}
