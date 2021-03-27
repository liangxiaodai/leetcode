package com.qunhe.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2280 👎 0

import java.util.Stack;

public class P20ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Stack<Character> stack = new Stack<>();

        public boolean isValid(String s) {
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    // 防止第一位就是)}]
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char pop = stack.pop();
                    boolean c1 = c == ')' && pop != '(';
                    boolean c2 = c == '}' && pop != '{';
                    boolean c3 = c == ']' && pop != '[';
                    if (c1 || c2 || c3) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
