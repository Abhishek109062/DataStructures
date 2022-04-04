import java.util.Scanner;

public class SatyamQues {
    public static void main(String[] args) {
        int ar[]={24,3,6,1,12};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to search");
        int original=sc.nextInt();

        for(int y=0;y<5;y++) {
            for (int x = 0; x < 5; x++) {
                if (ar[x] == original) {
                    original *= 2;

                }

            }
        }
        System.out.println(original);

    }
}
