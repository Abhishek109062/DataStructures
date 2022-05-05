import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class Graph1 {
    public static void main(String[] args) {
        int v=7;
        ArrayList<ArrayList <Integer>> adj= new ArrayList<>();
        for(int x=0;x<v;x++)
            adj.add(new ArrayList<Integer>(v));

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,4,5);
        addEdge(adj,4,6);
        addEdge(adj,5,6);
//
     //printGraph(adj);
       // BFS(adj,6,0);
        System.out.println(BFSDis(adj,7));
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
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
    }

    //This is used when no source is given and the graph is disconnected
    static void BFS(ArrayList<ArrayList<Integer>> adj, int v,int s,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int x:adj.get(u)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
    }

    static int BFSDis(ArrayList<ArrayList<Integer>> adj,int v){
        boolean visited[]=new boolean[v+1];
        int count=0; //this is used to count the connected components
        for(int i=0;i<v;i++)
            if(!visited[i]){
                BFS(adj,i,i,visited);
                count++;
            }

        return count;
    }
}
