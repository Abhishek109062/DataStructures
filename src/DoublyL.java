public class DoublyL {
    class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }
        Node head;
        public DoublyL()
        {
            head=null;
        }

        public void add(int data)
        {
            Node temp=new Node(data);
            if(head==null)
            {
                head=temp;
            }
            else
            {
                temp.next=head;
                head.previous=temp;
                head=temp;
            }
        }

        public void remove()
        {
            head=head.next;
            head.previous=null;
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

        public static void main(String args[])
        {
            DoublyL obj=new DoublyL();
            obj.add(10);
            obj.add(200);
            obj.add(100);
            obj.remove();
            obj.display();
            System.out.println();
        }


}
