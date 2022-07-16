import java.util.*;
import java.util.Queue;

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
        //int matrix[][] = new int[n][n];
        Edge[] obj=new Edge[e];
        for (int i = 0; i <e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            // creation of undirected graph
            //matrix[v1][v2]= weight;
            //matrix[v2][v1] = weight;
            obj[i]=new Edge(v1,v2,weight);

        }
        //prims(matrix);
//        for(int x:dijkstra(matrix,0))
//            System.out.print(x+" ");

        Edge[] ans=kruskal(obj,n);
        for (int i = 0; i <ans.length ; i++) {
            if(ans[i].v1<ans[i].v2)
            {
                System.out.println(ans[i].v1+" " +ans[i].v2+"  "+ans[i].weight);
            }

            else
            {
                System.out.println(ans[i].v2+" "+ans[i].v1+"  "+ans[i].weight);
            }
        }
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

    static int[] dijkstra(int[][] graph, int s){
        int v=graph.length;
        int[] dist=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        boolean fin[]=new boolean[v];
        for(int count=0;count<v-1;count++){
            int u=-1;
            for(int i=0;i<v;i++)
                if(!fin[i] && (u==-1 || dist[i]<dist[u]))
                    u=i;

            fin[u]=true;
            for(int x=0;x<v;x++)
                if(!fin[x] && graph[u][x]!=0)
                    dist[x]=Math.min(dist[x],dist[u]+graph[u][x]);

        }
        return dist;
    }

    //Kruskal algo for minimum spanning tree
    public static Edge[] kruskal(Edge edges[], int v)
    {
        Arrays.sort(edges);
        Edge[] ans = new Edge[v-1];
        int count=0;
        int i=0;
        int[] parent = new int[v];
        for (int j = 0; j <v ; j++) {
            parent[j] = j;
        }
        while(count != v-1)
        {

            Edge currentedge = edges[i++];
            int v1parent = findparent(currentedge.v1,parent);
            int v2parent = findparent(currentedge.v2, parent);
            if(v1parent != v2parent)
            {
                // including current edge
                ans[count]= currentedge;
                count++;
                parent[v1parent]= v2parent;
            }
        }
        return ans;
    }

    private static int findparent(int v1, int[] parent) {
        if(v1 == parent[v1])
        {
            return v1;
        }
        return findparent(parent[v1],parent);
    }
}

//comparable class for kruskal algorithm
class Edge implements  Comparable<Edge>
{
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
