import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class vector {
    public static void main(String[] args) {
        List<Employee> obj=new ArrayList<>();
        List obj2=new ArrayList();
        obj2.add("Abhishek");
        obj2.add(123);
        System.out.println(obj2);
        List obj4=new ArrayList();
        obj2.forEach(System.out::println);

    }
}
