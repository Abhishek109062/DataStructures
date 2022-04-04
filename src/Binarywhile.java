class  BinaryNode{
    int data;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode(int data){
        this.data=data;
    }

    public void preorderTraverse(){
        System.out.println(data+" ");
        if(left!=null)
            left.preorderTraverse();
        if(right!=null)
            right.preorderTraverse();
    }

    public void inorderTraverse(){
        if(left!=null)
            left.inorderTraverse();
        System.out.println(data+" ");
        if(right!=null)
            right.inorderTraverse();
    }

}

public class Binarywhile {
    BinaryNode root;

    public Binarywhile() {
        root = null;
    }

    public void insert(int data) {
        BinaryNode curr = root;
        BinaryNode newnode = new BinaryNode(data);
        if (root == null) {
            root = newnode;
        } else {
            while (true) {
                if (curr.data == data) {
                    break;
                }

                if (data < curr.data) {
                    if (curr.left == null)
                        curr.left = newnode;
                    else
                        curr = curr.left;
                } else {
                    if (curr.right == null)
                        curr.right = newnode;
                    else
                        curr = curr.right;
                }
            }
        }
    }
    public void preorderTraverse(){
        if(root!=null)
            root.preorderTraverse();
    }

    public void inorderTraverse(){
        if(root!=null)
            root.inorderTraverse();
    }
}

class test{
    public static void main(String[] args) {
        Binarywhile obj=new Binarywhile();
        obj.insert(10);
        obj.insert(100);
        obj.insert(20);
        obj.insert(300);
        obj.insert(1);
        System.out.println(obj.root.right);
        obj.preorderTraverse();
        obj.inorderTraverse();
    }
}
