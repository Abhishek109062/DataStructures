import java.util.Scanner;

public class MarkHisUnfinishedEssay {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            int c= sc.nextInt();
            int q= sc.nextInt();
            sc.nextLine();
            String s= sc.nextLine();
            while(c-->0){
                s=s+s.substring(sc.nextInt()-1,sc.nextInt());
            }
            //System.out.println(s);
            while(q-->0){
                System.out.println(s.charAt(sc.nextInt()-1));
            }
        }

    }
}
