class BiTree {
    class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public BiTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertnode(root, data);
    }

    public Node insertnode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertnode(root.left, data);
        else
            root.right = insertnode(root.right, data);

        return root;
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null)
            return;

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder() {
        postorder(root);
    }

    public void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public void delete(int data){
        root=delete(root,data);
    }

    public Node delete(Node root,int data){
        if(root==null)
            return null;

        if(data<root.data)
            root.left=delete(root.left,data);
        else if(data>root.data)
            root.right=delete(root.right,data);
        else{
            if(root.right==null)
                return root.left;
            if(root.left==null)
                return root.right;

            root.data=min(root.right);
            root.right=delete(root.right,root.data);
        }
        return root;
    }

    public int min(){
        if(root!=null)
            return min(root);
        else
            return Integer.MIN_VALUE;
    }

    public int min(Node root){
        if(root.left==null)
            return root.data;
        else
            return min(root.left);
    }

    public int max(){
        if(root!=null)
            return max(root);
        else
            return Integer.MAX_VALUE;
    }

    public int max(Node root){
        if(root.left==null)
            return root.data;
        else
            return max(root.right);
    }

    public static void main(String[] args) {
        BiTree obj = new BiTree();
        obj.insert(50);
        obj.insert(100);
        obj.insert(40);
        obj.insert(30);
        obj.insert(20);
        obj.insert(25);
          //obj.inorder();
        System.out.println(obj.max());
        // obj.preorder();
        //obj.postorder();
        //System.out.println(obj.min());
        //obj.delete(40);
        //obj.inorder();

    }
}