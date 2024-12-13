package leetcode;

import java.util.HashMap;

public class SumTwo {
    public static void main(String[] args) {
        int[] nums = {2,2,11,5};
        int target = 16;
        int[] val = twoSum(nums, target);

        // If two indices were found, print them
        if (val != null) {
            System.out.println("Indices: " + val[0] + ", " + val[1]);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        int[] nums = {2, 8, 11, 5};
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
