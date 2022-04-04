class ListNode {
    class Node {


        int data;
        Node next;

        public Node(int data) {
            this.data = data;

        }
    }
    Node front;
    public void add(int data)
    {
        Node temp=new Node(data);
            temp.next=front;
            front=temp;

    }

    public void add(int index,int data)
    {
        Node temp=front;
        if(index<size())
        {
            for(int x=1;x<index-1;x++)
                temp=temp.next;
            Node newnode=new Node(data);
            newnode.next=temp.next;
            temp=newnode;
        }
        else if(index==size())
            add(data);
        else
            System.out.println("IndexOutOfBound");
    }

    public int size()
    {
        int size=0;
        Node temp=front;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }

        return size;

    }

    public void display()
    {
        Node temp=front;
        while(temp!=null)
        {
            System.out.print(temp.data+"\t");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode obj=new ListNode();
        obj.add(10);
        obj.add(20);
        obj.add(30);
        obj.add(1,50);
        obj.display();
    }
}