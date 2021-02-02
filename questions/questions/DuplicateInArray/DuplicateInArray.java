package questions.DuplicateInArray;


/*
* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1


Constraints:

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.

*
* */
public class DuplicateInArray {

    // without modification // without space
    static int duplicateInArrayWithoutModification(final int[] arr){

        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        int start=arr[0];
        int end=slow;
        while(start!=end){
            start = arr[start];
            end = arr[end];
        }
        return start;
    }


    // if  modification is allowed
    static int duplicateInArray(int[] arr){

        int n= arr.length-1;

        for(int i=0;i<=n;i++){
            if(arr[i]<=n){

                if(arr[Math.abs(arr[i])]<0){
                    return Math.abs(arr[i]);
                }
                arr[Math.abs(arr[i])]= -1*arr[Math.abs(arr[i])];

            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,5};
        System.out.println(duplicateInArray(arr));
        int[] arr1 = {1,3,4,2,2};
        System.out.println(duplicateInArray(arr1));
        int[] arr2 = {5,2,3,4,5,1};
        System.out.println(duplicateInArrayWithoutModification(arr2));
        int[] arr3 = {1,3,4,2,2};
        System.out.println(duplicateInArrayWithoutModification(arr3));
    }
}
