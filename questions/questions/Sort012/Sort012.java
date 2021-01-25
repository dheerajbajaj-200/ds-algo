package questions.Sort012;

import java.util.Arrays;

/*
* Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
    Flag sort
    * TC - O(N)
    * SC - O(1)
int[] arr= {0,0,1,0,1,2,0,1};
 *
* */
public class Sort012 {

    static int[] sort012(int[] arr){

        int lo=0;
        int hi = arr.length-1;


        while(arr[lo]==0) {
            lo++;
        }
        int current= lo;
        while(lo<hi & current<=hi){
            if(arr[current]==0){
                int temp=arr[current];
                arr[current]=arr[lo];
                arr[lo]=temp;
                lo++;current++;
            }
            else if(arr[current]==2){
                int temp=arr[current];
                arr[current]=arr[hi];
                arr[hi]=temp;
                hi--;
            }
            else{
                current++;
            }

        }
        return arr;

    }
    public static void main(String[] args) {
        int[] arr= {0,0,1,0,1,2,0,1};
        System.out.println(Arrays.toString(sort012(arr)));
        int[] arr1= {2,2,2,0,0,0,1,1};
        System.out.println(Arrays.toString(sort012(arr1)));
        int[] arr2= {1,1,1,2,2,2,0,0,0};
        System.out.println(Arrays.toString(sort012(arr2)));
        int[] arr3= {2,1,0};
        System.out.println(Arrays.toString(sort012(arr3)));
        int[] arr4= {2,1,0,2,1,0,2,1,0,2,1,0};
        System.out.println(Arrays.toString(sort012(arr4)));

    }
}
