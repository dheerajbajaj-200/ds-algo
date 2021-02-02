package questions.MergeTwoArrays;


import java.util.Arrays;

/*
* Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.


Example 1:

Input:
N = 4, M = 5
arr1[] = {1, 3, 5, 7}
arr2[] = {0, 2, 6, 8, 9}
Output: 0 1 2 3 5 6 7 8 9
Explanation: Since you can't use any
extra space, modify the given arrays
to form
arr1[] = {0, 1, 2, 3}
arr2[] = {5, 6, 7, 8, 9}

Example 2:

Input:
N = 2, M = 3
arr1[] = {10, 12}
arr2[] = {5, 18, 20}
Output: 5 10 12 18 20
Explanation: Since you can't use any
extra space, modify the given arrays
to form
arr1[] = {5, 10}
arr2[] = {12, 18, 20}


Your Task:
You don't need to read input or print anything. Complete the function merge() which takes the two arrays arr1[], arr2[] and their sizes n and m, as input parameters. The function does not return anything. Use the given arrays to sort and merge arr1[] and arr2[] in-place.
Note: The generated output will print all the elements of arr1[] followed by all the elements of arr[2].


Expected Time Complexity: O((n+m)*log(n+m))
Expected Auxiliary Space: O(1)


Constraints:
1 <= N, M <= 5*104
0 <= arr1i, arr2i <= 106
*
* */
public class MergeTwoSortedArrays {

    public static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(arr1[i]<=arr2[j]){
                i++;
            }
            else if(arr1[i]>arr2[j]){
                int temp = arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i++;

                int index = Arrays.binarySearch(arr2,1,m,arr2[0]);
                //element to be inserted at last
                if(Math.abs(index)>m){
                    index=m;
                }
                Arrays.sort(arr2,0,Math.abs(index));
            }

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 12};
        int[] arr2 = {5, 18, 20};
        merge(arr1,arr2,arr1.length,arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 3, 5, 7};
        int[] arr4 = {0, 2, 6, 8, 9};
        merge(arr3,arr4,arr3.length,arr4.length);
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }
}
