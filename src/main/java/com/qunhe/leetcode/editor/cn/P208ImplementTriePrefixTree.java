package com.qunhe.leetcode.editor.cn;
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
// 👍 566 👎 0

public class P208ImplementTriePrefixTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private class Node {
            Node[] childs = new Node[26];
            boolean isLeaf;
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        private Node root = new Node();

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            insert(word, root);
        }

        private void insert(String word, Node node) {
            if (node == null) {
                return;
            }
            if (word.length() == 0) {
                node.isLeaf = true;
                return;
            }
            int index = indexForChar(word.charAt(0));
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
            }
            insert(word.substring(1), node.childs[index]);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(word, root);
        }

        private boolean search(String word, Node node) {
            if (node == null) {
                return false;
            }
            if (word.length() == 0) {
                return node.isLeaf;
            }
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1), node.childs[index]);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }

        private boolean startsWith(String prefix, Node node) {
            if (node == null) {
                return false;
            }
            if (prefix.length() == 0) {
                return true;
            }
            int index = indexForChar(prefix.charAt(0));
            return startsWith(prefix.substring(1), node.childs[index]);
        }

        private int indexForChar(char c) {
            return c - 'a';
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
