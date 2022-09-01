package recur;

import java.util.*;
class subSq_Sumk{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<List<Integer>> ans=new ArrayList<>();
        subsQ(0,new int[]{1,2,1,5,6,8,9},ans, new ArrayList<>(),0,17,7);
        System.out.println(ans);
            
    }

    public static void subsQ(int index,int nums[],List<List<Integer>> ans, List<Integer> temp,int s,int sum,int n){
        if(index==n){
            if(sum==s)
                ans.add(new ArrayList<>(temp));
            return;
        }
        //to find subseq with nums[index]
        temp.add(nums[index]);
        s+=nums[index];
        subsQ(index+1,nums,ans, temp,s,sum,n);
        //to find subseq without nums[index]
        temp.remove(temp.size()-1);
        s-=nums[index];
        subsQ(index+1,nums,ans, temp,s,sum,n);
    }
}
