package com.fish.leetcode;

import java.util.*;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2020/4/27
 * Stay curious, stay childlike.
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Q15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0, l = nums.length - 2; i < l; i++){
            int num = nums[i];
            if(num > 0){
                break;
            }
            if(i != 0 && num == nums[i - 1]){
                continue;
            }
            twoSum(nums, i, num, ret);
        }
        return ret;
    }

    public static void twoSum(int[] nums, int startIndex, int source, List<List<Integer>> ret) {
        int i = startIndex + 1, l = nums.length - 1;
        while (i < l){
            int beforeTwoSum = source + nums[i];
            if(beforeTwoSum > 0){
                break;
            }
            int result = beforeTwoSum + nums[l];
            if(result == 0){
                ret.add(Arrays.asList(source, nums[i], nums[l]));
                while (i < l  && nums[i] == nums[i + 1]) i++;
                while (i < l  && nums[l] == nums[l - 1]) l--;
                i++;
                l--;
                continue;
            }
            if(result < 0){
                while (i < l && nums[i] == nums[i + 1]) i++;
                i++;
                continue;
            }
            if(result > 0){
                while (i < l && nums[l] == nums[l - 1]) l--;
                l--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }



}