package com.qunhe.leetcode.editor.cn;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Related Topics 并查集 数组
// 👍 737 👎 0

import java.util.HashMap;
import java.util.Map;

public class P128LongestConsecutiveSequence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> countForNum = new HashMap<>();
            for (int num : nums) {
                countForNum.put(num, 1);
            }
            for (int num : nums) {
                forward(countForNum, num);
            }
            return maxCount(countForNum);
        }

        public int forward(Map<Integer, Integer> countForNum, int num) {
            if (!countForNum.containsKey(num)) {
                return 0;
            }
            int cnt = countForNum.get(num);
            if (cnt > 1) {
                return cnt;
            }
            cnt = forward(countForNum, num + 1) + 1;
            countForNum.put(num, cnt);
            return cnt;
        }

        private int maxCount(Map<Integer, Integer> countForNum) {
            int max = 0;
            for (int num : countForNum.keySet()) {
                max = Math.max(max, countForNum.get(num));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
