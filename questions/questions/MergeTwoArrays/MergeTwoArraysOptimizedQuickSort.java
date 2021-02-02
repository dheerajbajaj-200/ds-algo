package questions.MergeTwoArrays;

import java.util.Arrays;

public class MergeTwoArraysOptimizedQuickSort {

    static void partition(int[] arr, int N,
                          int[] brr, int M,
                          int Pivot)
    {
        int l = N - 1;

        // Stores index of each element
        // of the array, brr[]
        int r = 0;

        // Traverse both the array
        while (l >= 0 && r < M)
        {
            // If pivot is
            // smaller than arr[l]
            if (arr[l] < Pivot)
                l--;

                // If Pivot is
                // greater than brr[r]
            else if (brr[r] > Pivot)
                r++;

                // If either arr[l] > Pivot
                // or brr[r] < Pivot
            else
            {
                int t = arr[l];
                arr[l] = brr[r];
                brr[r] = t;
                l--;
                r++;
            }
        }
    }

    static void Merge(int[] arr, int N,
                      int[] brr, int M)
    {
        // Stores index of each element
        // of the array arr[]
        int l = 0;

        // Stores index of each element
        // of the array brr[]
        int r = 0;

        // Stores index of each element
        // the final sorted array
        int index = -1;

        // Stores the pivot element
        int Pivot = 0;

        // Traverse both the array
        while (index < N && l < N &&
                r < M)
        {
            if (arr[l] < brr[r])
            {
                Pivot = arr[l++];
            }
            else
            {
                Pivot = brr[r++];
            }
            index++;
        }
        System.out.println("Pivot : "+Pivot + " Index : "+index + " l: "+ l + " r : "+r);
        // If pivot element is not found
        // or index < N
        while (index < N && l < N)
        {
            Pivot = arr[l++];
            index++;
        }

        // If pivot element is not
        // found or index < N
        while (index < N && r < M)
        {
            Pivot = brr[r++];
            index++;
        }

        // Place the first N elements of
        // the sorted array into arr[]
        // and the last M elements of
        // the sorted array into brr[]
        System.out.println("Pivot1 : "+Pivot + " Index : "+index + " l: "+ l + " r : "+r);
        partition(arr, N, brr,
                M, Pivot);

        System.out.println("arr : "+Arrays.toString(arr));
        System.out.println("brr : "+Arrays.toString(brr));
        // Sort both the arrays
        Arrays.sort(arr);

        Arrays.sort(brr);

        // Print the first N elements
        // in sorted order
        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " ");

        // Print the last M elements
        // in sorted order
        for (int i = 0; i < M; i++)
            System.out.print(brr[i] + " ");
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 5, 9};
        int[] brr = {2, 4, 7, 10};
        int N = arr.length;
        int M = brr.length;
        Merge(arr, N, brr, M);
    }
}
