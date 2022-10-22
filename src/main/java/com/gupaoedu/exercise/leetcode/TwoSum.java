package com.gupaoedu.exercise.leetcode;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 * LeetCode 第2题 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @Author Tom
 */
public class TwoSum {

    //输入定义 ====================================
    static TwoSum self = new TwoSum();
    static int[] nums = new int[]{11,2,7,15};
    static int target = 9;

    public static void main(String[] args) {
        out(self.new GeneralSolution(),"暴力求解法");
        out(self.new HashTableSolution(),"哈希表求解");
    }

    public static void out(Solution solution,String solutionName){
        System.out.println(solutionName + "：" + Arrays.toString(
                solution.twoSum(nums,target)));
    }

    /**
     * 暴力求解法
     */
    class GeneralSolution implements Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int [2]; //长度为2

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    if(sum == target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }
    }

    class HashTableSolution implements Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int [2]; //长度为2

            Map<Integer,Integer> map = new Hashtable();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }
            for (int j = 0; j < nums.length; j++) {
                int diff = target - nums[j];
                if(map.containsKey(diff) && map.get(diff) != j){
                    result[0] = j;
                    result[1] = map.get(diff);
                    return result;
                }
            }
            return result;
        }
    }

    public interface Solution {
        public int[] twoSum(int[] nums, int target);

    }
}

