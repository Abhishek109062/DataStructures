class node {
    int data;
    node next;
    node(int data){
        this.data=data;
    }
}

public class browndog {
    node head;
    browndog(){
        head=null;
    }
    public void insert(int val){
        node newnode = new node(val);
        if(head==null){
            head = newnode;
        }
        else {
            node temp = head;
            while (temp.next!= null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    public void lastFirst(){
        node previous = head;
        node temp = head.next;
        while (temp.next!=null){
            previous=previous.next;
            temp=temp.next;
        }
        previous.next=null;
        temp.next=head;
        head=temp;
    }

    public void display(){
        node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        browndog obj = new browndog();
        obj.insert(1);
        obj.insert(3);
        obj.insert(5);
        obj.insert(4);
        obj.display();
        System.out.println();
        obj.lastFirst();
        obj.display();
    }
}