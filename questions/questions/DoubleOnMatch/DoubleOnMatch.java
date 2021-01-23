package questions.DoubleOnMatch;


import java.util.Arrays;
import java.util.Collection;

/*
* Given an array of long integers and a number n, iterate through the array and double the value of n wherever an element equals n,
*  arr can be reordered before the iteration to maximize the value of n. Find max value of n
* e.g: arr [1,2,4,11,12,8]
*  n =2;
*  Max Value of n =>  16
* */
public class DoubleOnMatch {

    static long doubleOnMatch(long[] arr,long n){

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                n=n*2;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        long[] arr = {1,2,4,11,12,8};
        System.out.println(doubleOnMatch(arr,2L));
    }

}
