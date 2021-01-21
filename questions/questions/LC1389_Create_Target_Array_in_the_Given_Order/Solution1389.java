package questions.LC1389_Create_Target_Array_in_the_Given_Order;

import java.util.ArrayList;

class Solution1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        int l = nums.length;
        int[] target = new int[l];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<l;i++){

            list.add(index[i],nums[i]);

        }
        for(int i=0;i<l;i++){

            target[i]=list.get(i);

        }
        return target;
    }
}