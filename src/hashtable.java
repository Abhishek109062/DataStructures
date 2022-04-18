import java.util.Hashtable;

public class hashtable {
    public static void main(String[] args) {
        Hashtable<Integer,String> obj=new Hashtable<>();
        obj.put(100,"Abhishek");
        obj.put(101,"Satyam");
        obj.put(101,"Rahul");
        System.out.println(obj);
    }
}
