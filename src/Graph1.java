import java.util.*;
import java.util.Queue;
import java.util.function.BiFunction;

public class Graph1 {
    public static void main(String[] args) {
        int v=4 ;
        ArrayList<ArrayList <Integer>> adj= new ArrayList<>();
        for(int x=0;x<v;x++)
            adj.add(new ArrayList<Integer>(v));

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);

//        addEdge(adj,4,6);
//        addEdge(adj,5,6);
//
     //printGraph(adj);
       // BFS(adj,6,0);
        //System.out.println(BFSDis(adj,7));
        //DFS(adj,v,0);
        //DFS2(adj,v);
        //shortestDis(adj,5,0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertex");
        int n= sc.nextInt();
        System.out.println("Enter the number of edges");
        int e = sc.nextInt();
        int matrix[][] = new int[n][n];
        for (int i = 0; i <e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            // creation of undirected graph
            matrix[v1][v2]= weight;
            matrix[v2][v1] = weight;
        }
        prims(matrix);
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
        boolean[] visited =new boolean[v+1];
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

    static int DFS2(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited =new boolean[v];
        int count=0;//used to count the connected graphs
        for(int i=0;i<v;i++){
            if(!visited[i])
            {
                count++;
                DFSRec2(adj,i,visited);
            }
         }
        return count;
    }

//    //shortest dis from the source
//    static void shortestDis(ArrayList<ArrayList<Integer>> adj, int v,int s){
//        int[] dis=new int[v];
//        for(int x=0;x<v;x++)
//            dis[x]=Integer.MAX_VALUE;
//
//        dis[0]=0;
//
//        boolean[] visited = new boolean[v+1];
//        Queue <Integer> q=new LinkedList<>();
//        visited[s]=true;
//        q.add(s);
//        while(!q.isEmpty()){
//            int u=q.poll();
//            System.out.print(u+" ");
//            for(int x:adj.get(u)){
//                if(!visited[x]){
//                    dis[x]=dis[u]+1;
//                    visited[x]=true;
//                    q.add(x);
//                }
//            }
//        }
//        for(int x=0;x<v;x++)
//            System.out.println(dis[x]);
//    }

    //Minimum Spanning Tree - Prism's Algorithm
    public static void prims(int matrix[][])
    {
        int n = matrix.length;
        boolean visited[] = new boolean[n];
        int parent[] = new int[n];
        int weight[] = new int[n];
        // assign the value of source vertex from where you start
        parent[0] = -1;
        weight[0] = 0;
        for (int i = 1; i <n ; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <n ; i++) {
            int minvertex = findMinimum(visited,weight);
            visited[minvertex]=true;
            // check the neighbours of the visited vertex

            for (int j = 0; j <n ; j++) {
                if(matrix[minvertex][j] !=0 && !visited[j])
                {
                    if(weight[j]>matrix[minvertex][j])
                    {
                        weight[j]= matrix[minvertex][j];
                        parent[j]= minvertex;
                    }
                }
            }
        }
        // printing the minimum spanning tree
        for (int i = 0; i <n ; i++){

            System.out.println(i+" "+parent[i]+" "+weight[i]);

        }
    }
    // method to find the minimum vertex
    private static int findMinimum(boolean[] visited, int[] weight) {
        int minvertex = -1;
        for (int i = 0; i <visited.length ; i++) {
            if(!visited[i] && (minvertex==-1 || weight[i]<weight[minvertex])){
                minvertex = i;
            }
        }
        return minvertex;
    }
}
