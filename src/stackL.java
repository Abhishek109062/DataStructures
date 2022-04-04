public class stackL {
    class Node{
     int data;
     Node next;
     Node(int data)
     {
         this.data=data;
     }
    }

    Node top;
    stackL()
    {
        top=null;
    }
    public void push(int data)
    {
        Node temp=new Node(data);
        if(top==null)
        {
            top=temp;
        }
        else
        {
            temp.next=top;
            top=temp;
        }
    }

    public void pop()
    {
        if(top==null)
            System.out.println("EMmpty stack");
        else
        {
            top=top.next;
        }
    }

    public void display()
    {
        Node temp=top;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static void main(String args[])
    {
        stackL obj=new stackL();
        obj.push(100);
        obj.push(200);
        obj.push(500);
        obj.pop();
        obj.display();
    }
}
