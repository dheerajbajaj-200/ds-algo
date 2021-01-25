package questions.sortNegativePositive;


import java.util.Arrays;

/*
An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.
Examples :

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
Note: Order of elements is not important here.

*
 */
public class SortNegativePositive {

    static void sortNegativePositive(int[] arr){
        int lo =0;
        while(arr[lo]<0){
            lo++;
        }
        int current=lo;
        while(current<arr.length){

            if(arr[current]<0){
                int temp= arr[current];
                arr[current]=arr[lo];
                arr[lo]=temp;
                lo++;
            }
            current++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        sortNegativePositive(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {12, 11, 13, 5, -6, -7, -5, 3, 6};
        sortNegativePositive(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
