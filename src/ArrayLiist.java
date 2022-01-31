import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayLiist {
    public static void main(String[] args) {
        ArrayList i=new ArrayList();
        i.add(100);
        i.add("Abhishek");
        System.out.println(i);
        i.add(0,12);
        Object a=i.toArray();
        System.out.println(a);
        ListIterator JJ=i.listIterator();
        while(JJ.hasNext())
        System.out.println(JJ.next());
        List ad=new ArrayList();
        ad.add(199);
        ad.add("dfghjj");
        ad.add(10000);
        System.out.println(ad);
        LinkedList obj;
        obj = new LinkedList();
        obj.add(100);
        obj.add("Abhishek");
        System.out.println(obj);
    }
}
