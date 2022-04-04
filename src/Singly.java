import java.util.Scanner;

public class Singly {
    class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
        }
    }

    Node head;
    Node tail;
    public void addFirst(int data)
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }

        else
        {
            newnode.next=head;
            head=newnode;
        }

    }
    public void addlast(int data)
    {
        Node  newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else if(head==tail)
        {
            head.next=tail;
            tail.next=newnode;
            tail=newnode;
        }
        else
        {
            tail.next=newnode;
            }
    }

    public int size()
    {
        int size=0;
        Node temp=head;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }

        return size;
    }

    public void addbtw(int index,int data)
    {
        Node newnode=new Node(data);
        if(size()<index)
        {
            System.out.println("Invalid Index");
            }
        else
        {
           Node temp=head;
           index-=2;
           while(index!=0)
           {
               temp=temp.next;
               index--;
           }
           newnode.next=temp.next;
           temp.next=newnode;
        }

    }
    public void deletefirst()
    {
        head=head.next;

    }
    public void deletelast()
    {
        Node temp=head;
        int size=size()-2;
        while(size>0)
        {
            temp=temp.next;
            size--;
        }

        temp.next=null;

    }

    public void deletebtw(int index)
    {
        if(size()<index)
            System.out.println("Invalid Index");
        else
        {
            Node temp=head;
            index-=2;
            while(index>0)
            {
                temp=temp.next;
                index--;

            }

            temp.next=temp.next.next;
        }
    }

    public void search(int data)
    {
        Node temp=head;

        while(temp!=null)
        {
            if(temp.data == data)
            {
                System.out.println("Element found");
                return;
            }
            temp=temp.next;
        }
    }




    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static  void main(String ...args)
    {
        Scanner c=new Scanner(System.in);
        Singly obj=new Singly();
        obj.addlast(10);
        obj.addlast(20);
        obj.addlast(40);
        obj.addbtw(2,50);

        obj.deletefirst();
        obj.deletelast();
        obj.display();
        obj.deletebtw(3);
        obj.display();

        obj.search(50);
    }

}
