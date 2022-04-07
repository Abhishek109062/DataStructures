class searchNode{
    int data;
    searchNode left;
    searchNode right;
    public searchNode(int data){
        this.data=data;
    }
}

class BinaryT{
    searchNode root;
    public BinaryT(){
        root=null;
    }

    public void insert(int data) {
        root=insert(root,data);
    }


    public searchNode insert(searchNode root,int data){
        if(root==null){
            root=new searchNode(data);
            return root;
        }

        if(data==root.data)
            return null;

        if(data<root.data)
            root.left=insert(root.left,data);
        else
            root.right=insert(root.right,data);

        return root;
    }


    public void inorderTraverse(){
            inorderTraverse(root);
    }

    public void inorderTraverse(searchNode root){
        if(root!=null){
            inorderTraverse(root.left);
            System.out.print(root.data+" ");
            inorderTraverse(root.right);
        }
    }
}

public class BinarySearch {

    public static void main(String[] args) {
        BinaryT obj=new BinaryT();
        obj.insert(20);
        obj.insert(100);
        obj.insert(200);
        obj.insert(30);
        obj.insert(10);
        obj.inorderTraverse();
    }
}
