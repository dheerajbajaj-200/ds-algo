package questions.reverseAnArray;

import java.util.Arrays;

/* Level: Easy
* Given an array (or string), the task is to reverse the array/string recursively.
Examples :


Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
* */
public class ReverseArrayRecursive {

    static void reverseArrayRecursivelyUtil(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        reverseArrayRecursivelyUtil(arr,start+1,end-1);
        int temp =arr[start];
        arr[start]= arr[end];
        arr[end]=temp;

    }
    static int[] reverseArrayRecursively(int[] arr){

        reverseArrayRecursivelyUtil(arr,0,arr.length-1);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        System.out.println(Arrays.toString(reverseArrayRecursively(arr1)));
        int[] arr2 = {1,2,3,4,5};
        System.out.println(Arrays.toString(reverseArrayRecursively(arr2)));
        int[] arr3 = {1,2};
        System.out.println(Arrays.toString(reverseArrayRecursively(arr3)));
        int[] arr4 = {1};
        System.out.println(Arrays.toString(reverseArrayRecursively(arr4)));
    }
}
