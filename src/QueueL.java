public class QueueL {
    class NodeQ
    {
        int data;
        NodeQ next;
        NodeQ(int data)
        {
            this.data=data;
        }
    }

    NodeQ front;
    NodeQ rear;
    QueueL()
    {
        this.front=this.rear=null;
    }

    public void enqueue(int data)
    {
        NodeQ newnode=new NodeQ(data);
        if(rear==null)
        {
            front=rear=newnode;
        }
        else
        {
            rear.next=newnode;
            rear=newnode;
        }

    }


    public void display()
    {
        NodeQ temp=front;
        if(temp==null)
            System.out.println("Empty Queue");
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static void main(String args[])
    {
        QueueL obj=new QueueL();
        obj.enqueue(100);
        obj.enqueue(20);
        obj.enqueue(2000);
        obj.display();
    }
}
