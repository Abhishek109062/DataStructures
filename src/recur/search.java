package recur;

public class search {
    public static int search(int ar[],int l,int low,int d)
    {
        if(l<low)
            return -1;
        if(ar[l]==d)
            return l;
        if(ar[low]==d)
            return low;
        return search(ar,l-1,low+1,d);
    }

    public static void main(String[] args) {
        int ar[]={1,7,4,23,657,3};
        System.out.println(search(ar,5,0,3));
    }
}
