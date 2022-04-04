public class Queue {
    int capacity;
    int[] ar;
    int front,rear;
    Queue(int capacity)
    {
        this.capacity=capacity;
        ar=new int[capacity];
        front=rear=0;
    }

    public void enqueue(int data)
    {
        if(rear==capacity)
            System.out.println("Queue Overflow");
        else
        {
            ar[rear++]=data;
        }
    }

    public void dequeue()
    {
        if(front==rear)
            System.out.println("Empty queue");
        else
        {
            for(int x=0;x<rear-1;x++)
            {
                ar[x]=ar[x+1];
            }
            if(rear<capacity)
                ar[--rear]=0;


        }
    }
    public void display()
    {
        if(front==rear)
            System.out.println("Empty");
        for(int x=front;x<rear;x++)
            System.out.println(ar[x]);
    }


    public static void main(String args[])
    {
        Queue obj=new Queue(10);
        obj.enqueue(20);
        obj.enqueue(40);
        obj.enqueue(100);
        obj.dequeue();
        obj.display();

    }




}
