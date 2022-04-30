import java.util.ArrayList;

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

       // printGraph(adj);
        }

    static void addEdge(ArrayList<ArrayList <Integer>> adj , int u ,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

//    static void printGraph(ArrayList<ArrayList <Integer>> adj){
//        for(int x=0;x<adj.size();x++){
//            for(int y=0;y<adj.get(x).size();y++)
//                System.out.print(adj.get(x).get(y)+" ");
//            System.out.println();
//        }
//    }
}
