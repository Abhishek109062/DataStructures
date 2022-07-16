import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> obj=new ArrayList<>(30000);

        for(int x=0;x<s.length()-p.length()+1;x++){
            char ch[]=s.substring(x,x+p.length()).toCharArray();
            Arrays.sort(ch);
            if(new String(ch).equals(p))
                obj.add(x);
        }

        return obj;
    }
    public  static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        System.out.println(findAnagrams(s,t));
    }
}