package questions.LargestContiguousSubarray;

import java.util.Arrays;

/*
* Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
Example 1:

Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which
is a contiguous subarray.
Example 2:

Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1
of element (-1)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)



Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107
*
*
* */
public class LargestContinuousSubArray {


    static int largestContiguousSubarraySum(int[] arr){
        int curr=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            curr+= arr[i];

            if(max<curr){
                max=curr;
            }
            if(curr<0)
                curr=0;
        }
        return max;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(largestContiguousSubarraySum(arr));
        int[] arr1 = {-1,-2,-3,-4};
        System.out.println(largestContiguousSubarraySum(arr1));

    }
}
