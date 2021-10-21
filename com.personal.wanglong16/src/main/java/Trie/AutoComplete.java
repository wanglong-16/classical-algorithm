package Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 使用前缀树 实现根据历史输入自动补全
 * @version: 1.0
 * @date: 2021-10-19 18:18:09
 * @author: wanglong16@meicai.cn
 */
public class AutoComplete {

    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        System.out.println("please input five line words");
        for (int i = 0; i < 5; i++) {
            trie.build(sc.nextLine());
        }
        System.out.println("please input prefix words");
        String prefix = sc.nextLine();
        System.out.println(trie.allPrefWith(prefix));
    }
    /**
     * abc
     * acdfg
     * aee
     * abcddea
     * abs
     *
     * ab
     */
}


class Trie {

    private Node head;

    public Trie() {
        this.head = new Node(false);
    }

    public void build(String str) {
        Node nd = head;
        for (char c : str.toCharArray()) {
            if (nd.children[c - 'a'] == null) {
                nd.children[c - 'a'] = new Node(false);
            }
            nd = nd.children[c - 'a'];
        }
        nd.isEnd = true;
    }

    public List<String> allPrefWith(String pref) {
        Node nd = head;
        List<String> ans = new ArrayList<>();
        for (char c : pref.toCharArray()) {
            if (nd.children[c - 'a'] != null) {
                nd = nd.children[c - 'a'];
            } else {
                return ans;
            }
        }
        backTrackIngNode(nd, new StringBuilder(pref));
        return btBuff;
    }

    List<String> btBuff = new ArrayList<>();

    private void backTrackIngNode(Node node, StringBuilder pref) {
        if (node != null) {
            if (node.isEnd) {
                btBuff.add(pref.toString());
            }
            for (int i = 0; i < node.children.length; i++) {
                pref.append((char) ('a' + i));
                backTrackIngNode(node.children[i], pref);
                pref.deleteCharAt(pref.length() - 1);
            }
        }
    }

    class Node {
        private boolean isEnd;
        private final Node[] children;

        public Node(boolean isEnd) {
            this.isEnd = isEnd;
            this.children = new Node[26];
        }
    }
}

