package recur;

public class count_subsq_sumK {
    public static void main(String[] args) {
        System.out.println(sub(0,0,9,new int[]{1,1,2,5,8,6,9,7},8));  
    }
    public static int sub(int index,int s,int sum,int[] ar,int n){
        if(index==n){
            if(s==sum)
            return 1;
            else
            return 0;
        }

        int r=sub(index+1,s,sum,ar,n);
        s+=ar[index];
        int l=sub(index+1,s,sum,ar,n);
        return l+r;
    }
}
