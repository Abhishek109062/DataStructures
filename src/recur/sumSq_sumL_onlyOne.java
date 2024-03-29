package recur;

import java.util.*;
class sumSq_sumk_onlyOne{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<List<Integer>> ans=new ArrayList<>();
        subsQ(0,new int[]{1,2,1,5,6,8,9},ans, new ArrayList<>(),0,17,7);
        System.out.println(ans);
            
    }

    public static boolean subsQ(int index,int nums[],List<List<Integer>> ans, List<Integer> temp,int s,int sum,int n){
        if(index==n){
            if(sum==s)
            {
                ans.add(new ArrayList<>(temp));
                return true;
            }
            
            return false;
        }

        temp.add(nums[index]);
        s+=nums[index];
        if(subsQ(index+1,nums,ans, temp,s,sum,n))
        return true;
        temp.remove(temp.size()-1);
        s-=nums[index];
        if(subsQ(index+1,nums,ans, temp,s,sum,n))
        return true;
        return false;
    }
}