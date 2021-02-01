package questions.MinNumberOfJumps;

import java.util.Arrays;

/*
* Given an array of integers where each element represents the max number of steps
*  that can be made forward from that element.
*  Find the minimum number of jumps to reach the end of the array
*  (starting from the first element). If an element is 0, then you cannot move through that element.
*
* Input:
N=11
arr=1 3 5 8 9 2 6 7 6 8 9
Output: 3
Explanation:
First jump from 1st element to 2nd
element with value 3. Now, from here
we jump to 5th element with value 9,
and from here we will jump to last.
Example 2:

Input :
N= 6
arr= 1 4 3 2 6 7
Output: 2
Explanation:
First we jump from the 1st to 2nd element
and then jump to the last element.

Constraints:
1 ≤ N ≤ 107
0 <= ai <= 107
* */
public class MinNumberOfJumps {

    static int minJumpsOptimized(int[] arr, int n){
        int maxReach =arr[0];   // the max reachable position
        int stepsPossible = arr[0]; // from the current index how many steps are possible; steps keep on decreasing as we move further from the given index
        int minJumps = 1; //min number of jumps that would require to reach the maxReach Index;


        if(stepsPossible<=0){
            return -1;
        }
        for(int i=1;i<n;i++){

            if(stepsPossible<=0){
                return -1;
            }
            if(i==n-1){
                return minJumps;
            }



            maxReach = Math.max(maxReach,i+arr[i]);

            stepsPossible--;

            if(stepsPossible==0 ){
                minJumps++;
                stepsPossible= maxReach-i;
            }
        }
        return -1;
    }

    static int minJumps(int[] arr, int n){

        // jumps[k] = minJumps( for all i<k, such that i+a[i]>=k)
        int[] jumps = new int[n];
        Arrays.fill(jumps,Integer.MAX_VALUE);
        jumps[0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]!=0 && j+arr[j]>=i){
                    if(jumps[j]+1<jumps[i]){
                        jumps[i]=jumps[j]+1;
                    }
                }
            }

        }

        if(jumps[n-1]==Integer.MAX_VALUE)
            return -1;
        return jumps[n-1]>0?jumps[n-1]:-1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr,arr.length));
        System.out.println(minJumpsOptimized(arr,arr.length));

        int[] arr2 = {2,1,0,1};
        System.out.println(minJumps(arr2,arr2.length));
        System.out.println(minJumpsOptimized(arr2,arr2.length));
    }


}
