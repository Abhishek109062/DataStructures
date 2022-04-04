public class PriorQueue {
    class Node{
        int data;
        int prior;
        Node next;
        public Node(int data, int prior)
        {
            this.data=data;
            this.prior=prior;
        }
    }

    Node front;
    Node rear;
    PriorQueue()
    {
        front=null;
        rear=null;

    }

    public void enqueue(int data,int prior)
    {
        Node newnode=new Node(data,prior);

        if(front==null || newnode.prior<front.prior)
        {
            newnode.next=front;
            front=newnode;
        }

        else
        {
            Node temp=front;
            while(temp.next!=null && temp.next.prior<=newnode.prior)
                temp=temp.next;

            newnode.next=temp.next;
            temp.next=newnode;

        }


    }
    public void display()
    {
        Node temp=front;
        while(temp!=null)
        {
            System.out.println("Data = "+temp.data+"\tPrior = "+temp.prior);
            temp= temp.next;
        }
    }

    public  static void main(String ...args)
    {
        PriorQueue obj=new PriorQueue();
        obj.enqueue(10,4);
        obj.enqueue(5,3);
        obj.enqueue(4,1);
        obj.enqueue(1,1);
        obj.display();
    }
}
