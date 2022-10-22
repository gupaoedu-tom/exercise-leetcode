package com.gupaoedu.exercise.leetcode;

/**
 * LeetCode 第1题 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @Author Tom
 */
public class AddTwoNumbers {

    //输入定义 ====================================
    static AddTwoNumbers self = new AddTwoNumbers();
    static ListNode l1 = buildChain(new int[]{2,4,3});
    static ListNode l2 = buildChain(new int[]{5,6,4});

    public static ListNode buildChain(int[] nums){
        int i = 0;
        ListNode result = self.new ListNode(nums[i]);
        ListNode curr = result;
        do {
            curr.next = self.new ListNode(nums[++i]);
            curr = curr.next;
        }while (i < nums.length - 1);
        return result;
    }

    public static void main(String[] args) {

        //迭代法求解
        out(self.new IterationSolution(),"迭代法求解");

        //递归法求解
        out(self.new RecursionSolution(),"递归法求解");
    }

    public static void out(Solution solution, String solutionName){

        ListNode result = solution.addTwoNumbers(l1,l2);

        if(result == null) {return;}

        System.out.print(solutionName + ":");

        ListNode curr = result;
        do{
            System.out.print(curr.val);
            curr = curr.next;
        }while (curr != null);

        System.out.println();

    }


    /*
    迭代法求解
     */
    class IterationSolution implements Solution{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int calcVal = 0;    //保存两数之和
            int nextCarry  = 0;     //保存下一个进位
            ListNode result = new ListNode();   //返回的链表
            ListNode curr = result; //记录下一个节点位置

            //这里
            while (l1 != null && l2 != null){
                calcVal = l1.val + l2.val + nextCarry;
                curr.next = new ListNode(calcVal % 10);
                nextCarry = calcVal /10;
                l1 = l1.next;
                l2 = l2.next;
                curr = curr.next;
            }

            while (l1 != null){
                calcVal = l1.val + nextCarry;
                curr.next = new ListNode(calcVal % 10);
                nextCarry = calcVal /10;
                l1 = l1.next;
                curr = curr.next;
            }

            while (l2 != null){
                calcVal = l2.val + nextCarry;
                curr.next = new ListNode(calcVal % 10);
                nextCarry = calcVal /10;
                l2 = l2.next;
                curr = curr.next;
            }
            if (nextCarry != 0){
                curr.next = new ListNode(nextCarry);
            }
            return result.next;
        }
    }

    /**
     * 递归法求解
     */
    class RecursionSolution implements Solution{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int calcVal = l1.val + l2.val;
            int nextCarry = calcVal / 10;
            ListNode result = new ListNode(calcVal % 10);
            if(l1.next != null || l2.next != null || nextCarry != 0){
                if(l1.next != null){
                    l1 = l1.next;
                }else {
                    l1 = new ListNode(0);
                }

                if(l2.next != null){
                    l2 = l2.next;
                }else {
                    l2 = new ListNode(0);
                }

                l1.val = l1.val + nextCarry;
                result.next = addTwoNumbers(l1,l2);
            }
            return result;
        }
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public interface Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2);
    }

}
