package com.fish.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2020/4/28
 * Stay curious, stay childlike.
 */
public class Q18 {
    // 可添加数组合数的最大值和最小值判断目标数值是否在范围内
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0, l = nums.length - 3; i < l; i++){
            int num = nums[i];
            if(num > target && num > 0){
                break;
            }
            if(i != 0 && num == nums[i - 1]){
                continue;
            }
            threeSum(nums, i, target, ret, num);
        }

        return ret;

    }

    public static void threeSum(int[] nums, int startIndex,  int target, List<List<Integer>> ret, int firstNum) {
        for(int i = startIndex + 1, l = nums.length - 2; i < l; i++){
            int num = nums[i];
            if(num + firstNum > target && num > 0){
                break;
            }
            if(i != startIndex + 1 && num == nums[i - 1]){
                continue;
            }
            twoSum(nums, i, target, ret, firstNum, num);
        }
    }

    public static void twoSum(int[] nums, int startIndex, int target, List<List<Integer>> ret, int firstNum, int secondNum) {
        int i = startIndex + 1, l = nums.length - 1;
        while (i < l){
            /*if(firstNum + secondNum + nums[i] > target){
                break;
            }*/
            int result = firstNum + secondNum + nums[i] + nums[l];
            if(result == target){
                ret.add(Arrays.asList(firstNum, secondNum, nums[i], nums[l]));
                while (i < l  && nums[i] == nums[i + 1]) i++;
                while (i < l  && nums[l] == nums[l - 1]) l--;
                i++;
                l--;
                continue;
            }
            if(result < target){
                while (i < l && nums[i] == nums[i + 1]) i++;
                i++;
                continue;
            }
            if(result > target){
                while (i < l && nums[l] == nums[l - 1]) l--;
                l--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }


}