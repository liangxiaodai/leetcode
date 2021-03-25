package com.qunhe.leetcode.editor.cn;
//实现一个 MapSum 类，支持两个方法，insert 和 sum：
//
//
// MapSum() 初始化 MapSum 对象
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对将被替代成新的键值对。
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
//
//
//
//
// 示例：
//
//
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
//
//
//
//
// 提示：
//
//
// 1 <= key.length, prefix.length <= 50
// key 和 prefix 仅由小写英文字母组成
// 1 <= val <= 1000
// 最多调用 50 次 insert 和 sum
//
// Related Topics 字典树
// 👍 84 👎 0

public class P677MapSumPairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {
        private class Node {
            Node[] child = new Node[26];
            int value;
        }

        private Node node = new Node();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            insert(key, node, val);
        }

        private void insert(String key, Node node, int val) {
            if (node == null) {
                return;
            }
            if (key.length() == 0) {
                node.value = val;
                return;
            }
            int index = indexForChar(key.charAt(0));
            if (node.child[index] == null) {
                node.child[index] = new Node();
            }
            insert(key.substring(1), node.child[index], val);
        }

        public int sum(String prefix) {
            return sum(prefix, node);
        }

        private int sum(String prefix, Node node) {
            if (node == null) {
                return 0;
            }
            if (prefix.length() != 0) {
                int index = indexForChar(prefix.charAt(0));
                return sum(prefix.substring(1), node.child[index]);
            }
            int sum = node.value;
            for (Node child : node.child) {
                sum += sum(prefix, child);
            }
            return sum;
        }

        private int indexForChar(char c) {
            return c - 'a';
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
