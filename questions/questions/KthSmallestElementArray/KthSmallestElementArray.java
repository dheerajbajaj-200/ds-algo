package questions.KthSmallestElementArray;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/*
* Level : Medium for O(NlogN)
*         Hard for O(N)
*  Given an array arr[] and a number K where K is smaller than size of array,
*  the task is to find the Kth smallest element in the given array.
*  It is given that all array elements are distinct.

Expected Time Complexity: O(n)
* arr[] = {7 10 4 3 20 15} k=3; output=7;
*
* */
public class KthSmallestElementArray {

    static int KthSmallestElementArrayNlogN(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int value : arr) {
            minHeap.add(value);
        }
        for(int i=0;i<k-1;i++){
            minHeap.poll();
        }
        return minHeap.poll();
        //TC: O(n+klogk)
    }

    static int KthSmallestElementArrayMaxHeap(int[] arr,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,Comparator.reverseOrder());


        for(int i=0;i<k;i++){
            maxHeap.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){

            int top = maxHeap.peek();
            if(top>arr[i]){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }

        }
        return maxHeap.poll();

    }
    //standard partition logic which returns position of pivot in the sorted array... considering pivot is the last element
    // in the randomized partition we have swapped the random number with the last element and keep this partition method standard
    static int partition(int[] arr,int l,int r){

        int pivot = arr[r];
        int start=l;

        for(int i=l;i<r;i++){

            if(arr[i]<=pivot){
                int temp = arr[i];
                arr[i]=arr[start];
                arr[start]=temp;
                start++;
            }
        }
        //swap pivot with start
        int temp = arr[start];
        arr[start]=arr[r];
        arr[r]=temp;
        return start;  //correct position of pivot
    }

    static int quickSort(int[] arr,int l,int r,int k){

        if(k > 0 && k <= r - l + 1) {
            int pos = randomPartition(arr, l, r);
            if (pos - l == k - 1) {
                return arr[pos];
            }
            //position is more than number of elements recur for left subarray
            if (pos-l > k-1) {
                return quickSort(arr, l, pos-1, k);
            } else {
                return quickSort(arr, pos + 1, r, k +l-pos - 1);
            }
        }
        else
            return Integer.MAX_VALUE;

    }

    static int randomPartition(int[] arr,int l,int r){

        int rand = ThreadLocalRandom.current().nextInt(l,r+1);
        int temp = arr[rand];
        arr[rand]=arr[r];
        arr[r]=temp;
        return partition(arr,l,r);
    }

    static int KthSmallestElementONRandomQuickSort(int[] arr,int k){
        /*
        * idea is to use random quick sort-> where pivot is chosen randomly instead of last element
        *
        * This will lead to expected time complexity to O(N), but worst case still remains O(N^2)
        *
        * */
        return quickSort(arr,0,arr.length-1,k);


    }
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        System.out.println(KthSmallestElementArrayNlogN(arr,3));
        int[] arr1 = {7,10,4,3,20,15};
       System.out.println(KthSmallestElementArrayMaxHeap(arr1,3));
        int[] arr2 = {7,10,4,3,20,15};
        System.out.println(KthSmallestElementONRandomQuickSort(arr2,3));

    }
}
