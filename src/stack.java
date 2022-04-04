public class stack
{
    int topstack;
    int length=100;
    int [] ar=new int[length];
    public  stack()
    {
        topstack=-1;
    }

    boolean isEmpty()
    {
        return topstack<0;
    }

    public void push(int data)
    {
        if(topstack>=length-1)
        {
            System.out.println("Stack overflow");

        }
        else
        {
            ar[++topstack]=data;
            System.out.println(data+" successfully added");
        }
    }

    public void pop()
    {
        if(topstack<0)
            System.out.println("Stack underflow");
        else
        {
            System.out.println(ar[topstack]+" successfully poped");
            topstack--;
        }
    }


    public int peak()
    {
        if(topstack<0) {
            System.out.println("Stack underlfow");
            return 0;
        }
        else
        {
            return ar[topstack];
        }
    }

    public void display()
    {
        for(int i=topstack;i>-1;i--)
            System.out.println(ar[i]);
    }


    public static void main(String args[])
    {
        stack obj=new stack();
        obj.push(10);
        obj.push(20);
        obj.push(40);
        obj.pop();
        System.out.println(obj.peak());
        obj.display();
    }
}