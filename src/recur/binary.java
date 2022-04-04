package recur;

public class binary {
    public static int find(int d)
    {
        if(d==0)
            return 0;
        return d%2+10*(find(d/2));
    }

    public static void main(String args[])
    {
        System.out.println(find(10));
    }
}
