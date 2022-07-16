import java.util.Scanner;

public class MarktheDustSweeper {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] ar =new int[n];
            long sum=0L;
            for(int x=0;x<n;x++)
            {
                ar[x]=sc.nextInt();
            }
            boolean flag=false;
            for(int x=0;x<n-1;x++){
                sum+=ar[x];
                if(ar[x]!=0)
                    flag=true;
                if(flag && ar[x]==0)
                    sum++;

            }
                System.out.println(sum);
        }
    }
}
