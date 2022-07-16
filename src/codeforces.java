import java.util.Arrays;
import java.util.Scanner;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int diff=sc.nextInt();
            int ar[]=new int[2*n];
            for(int x=0;x<2*n;x++)
                ar[x]=sc.nextInt();

            Arrays.sort(ar);
            String s="YES";
            for(int x=0;x<n;x++){
                if(ar[x+n]-ar[x]>=diff);
                else{
                    s="NO";
                    break;
                }
            }
            System.out.println(s);
        }
    }
}
