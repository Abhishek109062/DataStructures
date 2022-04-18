import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

 class Graphdemo {
    Map<Integer, LinkedList<Integer>> obj;
    Graphdemo(){
        obj=new HashMap<>();
    }
    public void addEdge(int v1,int v2,boolean isBidirectional)
    {
        LinkedList<Integer> v1neighbour = obj.getOrDefault(v1,new LinkedList<>());
        v1neighbour.add(v2);
        obj.put(v1,v1neighbour);
        if(isBidirectional){
            LinkedList<Integer> v2neighbour = obj.getOrDefault(v2,new LinkedList<>());
            v2neighbour.add(v1);
            obj.put(v2,v2neighbour);
        }
    }
    public void display(){

    }
}