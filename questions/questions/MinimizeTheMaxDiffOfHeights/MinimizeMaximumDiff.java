package questions.MinimizeTheMaxDiffOfHeights;

import java.util.Arrays;

/*
* Given heights of n towers and a value k. We need to either increase or decrease height
* of every tower by k (only once) where k > 0. The task is to minimize the difference
*  between the heights of
*  the longest and the shortest tower after modifications, and output this difference.

Examples:

Input  : arr[] = {1, 15, 10}, k = 6
Output :  Maximum difference is 5.
Explanation : We change 1 to 6, 15 to
9 and 10 to 4. Maximum difference is 5
(between 4 and 9). We can't get a lower
difference.

Input : arr[] = {1, 5, 15, 10}
        k = 3
Output : Maximum difference is 8
arr[] = {4, 8, 12, 7}

Input : arr[] = {4, 6}
        k = 10
Output : Maximum difference is 2
arr[] = {14, 16} OR {-6, -4}

*
* */
public class MinimizeMaximumDiff {

    static  int getMinDiff(int[] arr, int n, int k) {
        // code here

        Arrays.sort(arr);
        int currdif = arr[n-1]-arr[0];

        int small = arr[0]+k;
        int big = arr[n-1]-k;
        if(small>big){
            int temp = big;
            big=small;
            small=temp;
        }

        for(int i=1;i<n-1;i++){
            System.out.println("Big: "+big+ " small : "+small);
            int add = arr[i]+k;
            int sub = arr[i]-k;

            if(add<=big || sub>=small){
                continue;
            }
            if(big-sub <= add-small){
                small=sub;
            }
            else{
                big=add;
            }
        }

        return Math.min(currdif,big-small);

    }
    public static void main(String[] args) {
        int[] arr= {2 ,6, 3, 4, 7, 2, 10, 3 ,2 ,1};
        System.out.println(getMinDiff(arr,10,5));

        int[] arr1= {1, 15, 10};
        System.out.println(getMinDiff(arr1,3,6));
    }
}
