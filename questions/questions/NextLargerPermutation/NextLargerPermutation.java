package questions.NextLargerPermutation;


import java.util.Arrays;

/*
*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*
*
* */
public class NextLargerPermutation {

    public static int[] nextPermutation(int[] nums) {

        int n = nums.length;
        int i=n-1;
        for(;i>0;i--){
            if(nums[i]>nums[i-1]){
                break;
            }
        }

        if(i==0){
            Arrays.sort(nums);
            return nums;
        }

        int j=n-1;
        while(j>=i&&nums[j]<=nums[i-1]){
            j--;
        }

        int temp = nums[j];
        nums[j]=nums[i-1];
        nums[i-1]=temp;
        Arrays.sort(nums,i,n);
        return nums;

    }

    public static void main(String[] args) {
        int[] arr1= {1,2,3};
        int[] arr2= {3,2,1};
        int[] arr3= {1,1,5};
        int[] arr4= {1,5,1};

        System.out.println(Arrays.toString(nextPermutation(arr1)));
      System.out.println(Arrays.toString(nextPermutation(arr2)));
      System.out.println(Arrays.toString(nextPermutation(arr3)));
        System.out.println(Arrays.toString(nextPermutation(arr4)));

    }

}
