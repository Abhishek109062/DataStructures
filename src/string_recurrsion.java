/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class hjk
{
    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                int count=0;
                int n=sc.nextInt();
                // if(n==4)
                // System.out.println(count);
                //else
                    for (int x = 1; x <= Math.sqrt(n); x++) {
                        for (int y = x; y <= Math.sqrt(n); y++) {
                            if (x == y) {
                                if (4 * x * x == n)
                                    count++;
                            } else {
                                int product=x*x+y*y;
                                if(n-product>0){
                                    int gcd=GCD(x,y);
                                    int lcm=(x*y)/gcd;
                                    if(n-product-gcd*gcd-lcm*lcm==0)
                                        count+=2;
                                }
                                else
                                    break;
//                                int gcd = GCD(x, y);
//                                int lcm = (x * y) / gcd;

                            }
                        }
                    }
                    System.out.println(count);


            }
        } catch(Exception e) {
            return;
        }
    }

    static int GCD(int a, int b){
        if(b==0)
            return a;
        return GCD(b,a%b);
    }
}
