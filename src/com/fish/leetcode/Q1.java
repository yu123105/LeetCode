package com.fish.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2020/4/27
 * Stay curious, stay childlike.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Q1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> leaveNumMap = new HashMap<>();
        for(int i = 0, l = nums.length; i < l; i++){
            int num = nums[i];
            if(leaveNumMap.containsKey(target - num)){
                ret[0] = leaveNumMap.get(target - num);
                ret[1] = i;
            }
            leaveNumMap.put(num, i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}