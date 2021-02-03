package questions.MergeOverlappingIntervals;


import java.util.*;

/*
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*
*
*
* */
public class MergeIntervals {

    static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int k=0;
        int[][] mergedInterval = new int[n][2];
        mergedInterval[k][0]= intervals[0][0];
        mergedInterval[k][1]= intervals[0][1];

        //mergedList.add(k, Collections.singletonList(intervals[0][0]));
        for(int i=1;i<n;i++){

            if(mergedInterval[k][1]<intervals[i][0]){
                k++;
                mergedInterval[k][0]=intervals[i][0];
                mergedInterval[k][1]=intervals[i][1];
            }
            else if(mergedInterval[k][1]>=intervals[i][0] && mergedInterval[k][1]<=intervals[i][1]){
                mergedInterval[k][1] =  intervals[i][1];
            }

        }
        int[][] ans = new int[k+1][2];
        for(int i=0;i<=k;i++){
            ans[i][0] = mergedInterval[i][0];
            ans[i][1] = mergedInterval[i][1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(arr);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
