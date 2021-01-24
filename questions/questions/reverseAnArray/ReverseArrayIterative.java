package questions.reverseAnArray;

/* Level: Basic
* Given an array (or string), the task is to reverse the array/string iteratively.
Examples :


Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
* */

import java.util.Arrays;

public class ReverseArrayIterative {

    static int[] reverseArrayIterative(int[] arr){
        int start=0;
        int end = arr.length-1;
        while(start<end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] =temp;
            start++;
            end--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        System.out.println(Arrays.toString(reverseArrayIterative(arr1)));
        int[] arr2 = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverseArrayIterative(arr2)));
    }
}
