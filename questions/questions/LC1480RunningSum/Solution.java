package questions.LC1480RunningSum;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] input = {3,1,2,10,1};
        System.out.println(Arrays.toString(runningSum(input)));
    }
    public static int[] runningSum(int[] nums) {

        int l = nums.length;
        int[] ans = new int[l];

        ans[0]=nums[0];
        for(int i=1;i<l;i++){
            ans[i]=ans[i-1]+nums[i];
        }

        return ans;
    }
}