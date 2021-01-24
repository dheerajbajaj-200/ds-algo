package questions.MaxMinInArray;
/*
* Maximum and minimum of an array using minimum number of comparisons.
* int arr[] = { 1000, 11, 445,1, 330, 3000 };
* min= 1, max= 3000
* Level: Medium
* */
public class MaxMinInArray {

    static class Pair{
        int min;
        int max;

        @Override
        public String toString() {
            return "Pair{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
    //Divide n conquer
    //divide array in two parts -> find max/min of left -> find max/min of right -> Collectively find max/min of both using 2 comparisons
    static Pair maxMinInArray(int[] arr,int start,int end){
        Pair globalMinMax = new Pair();
        Pair leftMinMax = new Pair();
        Pair rightMinMax = new Pair();

        //array size=1
        if(start==end){
            globalMinMax.max=arr[start];
            globalMinMax.min=arr[end];
            return globalMinMax;
        }
        //array size=2; 1 comparison
        if(end==start+1){
            if(arr[start]>arr[end]){
                globalMinMax.min=arr[end];
                globalMinMax.max=arr[start];
            }
            else{
                globalMinMax.min=arr[start];
                globalMinMax.max=arr[end];
            }
            return globalMinMax;
        }
        int mid = (start+end)/2;
        leftMinMax= maxMinInArray(arr,start,mid);
        rightMinMax= maxMinInArray(arr,mid+1,end);

        // 2 comparisons to find global min/max
        globalMinMax.max = Math.max(leftMinMax.max, rightMinMax.max);
        globalMinMax.min = Math.min(leftMinMax.min,rightMinMax.min);
        return globalMinMax;

    }
    public static void main(String[] args) {
        int[] arr = { 1000, 11, 445,1, 330, 3000 };
        System.out.println(maxMinInArray(arr,0,arr.length-1));

        int[] arr1 = { 1000 };
        System.out.println(maxMinInArray(arr1,0,arr1.length-1));

    }
    /*
    *   T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2
        T(2) = 1
        T(1) = 0
        * if n is a power of 2
        *  it becomes : T(n) = 2T(n/2) +2;
        *  T(n) = 3n/2 -2;
        *
    * */
}
