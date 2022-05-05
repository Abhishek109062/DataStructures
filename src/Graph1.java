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
        addEdge(adj,1,2);
        addEdge(adj,3,4);

//        addEdge(adj,4,6);
//        addEdge(adj,5,6);
//
     //printGraph(adj);
       // BFS(adj,6,0);
        //System.out.println(BFSDis(adj,7));
        //DFS(adj,v,0);
        DFS2(adj,v);
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

    //Breadth first search
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

    //Breadth First Search - This is used when no source is given and the graph is disconnected
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

    //Breadth First Search - Used for disconnected graph
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


    static void DFSRec(ArrayList<ArrayList<Integer>> adj , int s, boolean[] visited){
        visited[s]=true;
        System.out.print(s+" ");
        for(int u:adj.get(s))
            if(!visited[u])
                DFSRec(adj, u,visited);
    }

    //Depth First Search
    static void DFS(ArrayList<ArrayList<Integer>> adj,int v,int s){
        boolean[] visited= new boolean[v];
        DFSRec(adj,s,visited);
    }

    //Depth First Search - For Disconnected graphs
    static void DFSRec2(ArrayList<ArrayList<Integer>> adj,int s , boolean[] visited){
        visited[s]=true;
        System.out.print(s+" ");
        for(int u:adj.get(s))
            if(!visited[u])
                DFSRec2(adj,u,visited);
    }

    static void DFS2(ArrayList<ArrayList<Integer>> adj,int v){
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++)
            if(!visited[i])
                DFSRec2(adj,i,visited);
    }
}
