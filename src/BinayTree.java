import java.util.LinkedList;

class BinayNode {
    int data;
    BinayNode right;
    BinayNode left;
    BinayNode(int data) {
        this.data = data;
    }

    public void insert(int data){
        if(this.data==data)
            return;


        if(data<this.data)
        {
            if(left==null)
            left=new BinayNode(data);
            else
                left.insert(data);
        }
        else{
            if(right==null)
            right=new BinayNode(data);
            else
                right.insert(data);
        }
    }

    public void inorderTraverse(){
        if(left!=null)
            left.inorderTraverse();
        System.out.print(data+" ");
        if(right!=null)
            right.inorderTraverse();
    }

    public void preorderTraverse(){
        System.out.print(data+" ");
        if(left!=null)
            left.preorderTraverse();
        if(right!=null)
            right.preorderTraverse();
    }

    public void postorderTraverse(){
        if(left!=null)
            left.postorderTraverse();
        if(right!=null)
            right.postorderTraverse();

        System.out.print(data+" ");
    }

    public boolean search(int data) {
        if (data == this.data)
            return true;

        if (data < this.data) {
            if (left == null)
                return false;
            else
               return left.search(data);
        } else {
            if (right == null)
                return false;
            else
               return right.search(data);
        }
    }

    public int min(){
        if(left==null)
            return data;
        else
            return left.min();

    }

    public int max(){
        if(right==null)
            return data;
        else
            return right.max();
    }
    public void between(){
        if(left!=null)
            left.between();
        if(data>=15 && data<=50)
        System.out.print(data+" ");
        if(right!=null)
            right.between();
    }

    public LinkedList<Integer> searchpath(BinayNode root, int data){
        if(this.data==data){
            LinkedList<Integer> obj=new LinkedList<Integer>();
            obj.add(data);
            return obj;
        }

        if(data<this.data){
            LinkedList<Integer> leftpath=searchpath(left,data);
            if(left!=null)
                leftpath.add(data);

            return leftpath;
        }

        else{
            LinkedList<Integer> rightpath=searchpath(right,data);
            if(right!=null)
                rightpath.add(data);

            return rightpath;
        }
    }
}


class BinaryTree{
    BinayNode root;
    public void insert(int data){
        if(root==null)
            root=new BinayNode(data);

        else
            root.insert(data);
    }

    public void inorderTraverse(){
        if(root!=null)
            root.inorderTraverse();
    }

    public void preorderTraverse(){
        if(root!=null)
            root.preorderTraverse();
    }

    public void postorderTraverse(){
        if(root!=null)
            root.postorderTraverse();
    }
    public boolean search(int data){
        if(root==null)
            return false;
        return root.search(data);
    }

    public void delete(int data){
        root=delete(root,data);
    }

    public BinayNode delete(BinayNode currsubroot,int data){
        if(currsubroot==null)
            return currsubroot;

        if(data<currsubroot.data)
            currsubroot.left=delete(currsubroot.left,data);
        else if(data>currsubroot.data)
            currsubroot.right=delete(currsubroot.right,data);

        else
        {
            if(currsubroot.left==null)
                return currsubroot.right;
            else if(currsubroot.right==null)
                return currsubroot.left;

            currsubroot.data=currsubroot.right.min();
            currsubroot.right=delete(currsubroot.right,currsubroot.data);
        }

        return currsubroot;
    }

    public int min(){
        if(root==null)
            return Integer.MIN_VALUE;
        else
            return root.min();
    }

    public int max(){
        if(root==null)
            return Integer.MAX_VALUE;
        else
            return root.max();
    }

    public void between(){
    if(root!=null)
        root.between();
    }

    public LinkedList<Integer> searchpath(int data){
        if(root!=null)
            return root.searchpath(root,data);

        return null;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryTree obj=new BinaryTree();
        obj.insert(80);
        obj.insert(2);
        obj.insert(1);
        obj.insert(6);
        obj.insert(10);
//        //obj.insert(5);
//        obj.insert(7);
//        obj.insert(49);
//        obj.insert(100);
//        obj.insert(16);
//        obj.between();
//        System.out.println();
//        System.out.println("Min : "+obj.min());
//        System.out.println("Max : "+obj.max());
        System.out.println(obj.searchpath(10));
    }
}