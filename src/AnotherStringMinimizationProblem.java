import java.util.Scanner;

public class AnotherStringMinimizationProblem {
    public static void main(String args[]){
        String s ="jakdfapijsdkjpi";

        System.out.println( s.replaceAll("pi","3.14"));
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int ar[]=new int[n];
            char ch[]=new char[m];

            while(n-->0){
                int temp=sc.nextInt();
                if(ch[temp-1]=='A')
                    ch[m+1-temp]='A';
                else
                    ch[temp]='A';
            }
            for(int x=0;x<m;x++){
                if(ch[x]!='A')
                    ch[x]='B';
            }
            System.out.println(String.copyValueOf(ch));
        }

    }
}
