package questions.LargestSubarrayWithEqual1sAnd0;

/*
* Given an array of 0s and 1s. Find the largest subarray with equal number of 0s and 1s
* Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. The expected time complexity is O(n).
Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
*
*  1 -1 1 1 1 -1 -1 => subarray with sum 0;
Output: 1 to 6
(Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayWithEqual1And0 {

   static int[] maxSubarrayWithEqual0And1(int[] arr){
       int n = arr.length;
       int[] cum = new int[n+1];
       Map<Integer,Integer>map = new HashMap<>(); //sum and index
       int maxStart=-1;
       int maxEnd=-1;
       cum[0]=0;
       cum[1]= arr[0]==1?1:-1;
       map.put(cum[0],-1);
       map.put(cum[1],0);
       for(int i=1;i<n;i++){
           if(arr[i]==0){
               arr[i]=-1;
           }
           cum[i+1]=cum[i]+arr[i];
           System.out.println(Arrays.toString(cum));
           if(map.containsKey(cum[i+1])){
               int start= map.get(cum[i+1])+1;
               int end = i;
               if(start!=end && maxEnd-maxStart < end-start ){
                   maxStart=start;
                   maxEnd=end;
               }
           }
           else{
               map.put(cum[i+1],i);
           }
       }
       int[] ans = {maxStart,maxEnd};
       return ans;
   }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(Arrays.toString(maxSubarrayWithEqual0And1(arr)));
        int[] arr1 = {1, 1,1};
        System.out.println(Arrays.toString(maxSubarrayWithEqual0And1(arr1)));
        int[] arr2 = {0, 0,1};
        System.out.println(Arrays.toString(maxSubarrayWithEqual0And1(arr2)));
        int[] arr3 = {0, 0,0};
        System.out.println(Arrays.toString(maxSubarrayWithEqual0And1(arr3)));
    }
}
