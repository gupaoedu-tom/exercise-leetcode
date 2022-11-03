package com.gupaoedu.exercise.leetcode;


import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * @Author Tom
 */
public class ValidParentheses {

    //输入定义 ====================================
    static ValidParentheses self = new ValidParentheses();

//    static String s = "()";
    static String s = "()[]{}";
//    static String s = "(]";

    //启动入口
    public static void main(String[] args) {
        out(self.new StackSolution(),"压栈法求解");
    }

    //输出结果
    public static void out(Solution solution, String solutionName){
        System.out.println(solutionName + "：" + solution.isValid(s));
    }

    /**
     * 压栈法求解
     */
    class StackSolution implements Solution {

        @Override
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                //左括号往栈中push
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }

                //右括号从栈中pop并检查是否为同类型的有效匹配
                if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                    return false;
                }

                //右括号从栈中pop并检查是否为同类型的有效匹配
                if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                    return false;
                }

                //右括号从栈中pop并检查是否为同类型的有效匹配
                if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                    return false;
                }
            }

            //如果所有括号都能匹配，最后看栈中有没有单身狗
            //如果有单身狗，说明是无效的，否则有效
            return stack.isEmpty();
        }
    }

    //方法结构从LeetCode复制过来
    public interface Solution {
        public boolean isValid(String s);
    }
}
