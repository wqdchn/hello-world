package geektime;

/**
 * @program:
 * 极客时间专栏 《程序员的数学基础课》11 | 树的深度优先搜索（上）：如何才能高效率地查字典？
 * https://time.geekbang.org/column/article/76481
 *
 * @description
 * 前缀树：现在给你一个字典，请尝试实现其前缀树，包括树的构建和查询两个过程。
 * 这里，字典可以用字符串数组来表示，每个字符串代表一个单词。
 *
 * @author: wqdong
 * @create: 2019-02-28 10:46
 **/
public class PrefixTreeTest {

    private static final int WORD_SIZE = 26;

    private PrefixTreeNode root;//根结点

    private static class PrefixTreeNode {//结点
        private PrefixTreeNode[] child;
        private boolean isWordEnd;

        public PrefixTreeNode() {
            isWordEnd = false;

            child = new PrefixTreeNode[WORD_SIZE];
            for (int index = 0; index < WORD_SIZE; index++) {
                child[index] = null;
            }
        }
    }

    public void build(String key) {
        PrefixTreeNode newNode = root;

        int index;

        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';

            if (newNode.child[index] == null) {
                newNode.child[index] = new PrefixTreeNode();
            }

            newNode = newNode.child[index];
        }

        newNode.isWordEnd = true;
    }

    public boolean search(String key) {
        PrefixTreeNode searchNode = root;

        int index;

        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';

            System.out.println(index);

            if (searchNode.child[index] == null) {
                return false;
            }

            searchNode = searchNode.child[index];
        }

        return (searchNode != null && searchNode.isWordEnd);
    }

    public static void main(String args[]) {
        String[] keys = {"here","is","geek", "time", "zhuan", "lan", "the","math","of","coder"};

        PrefixTreeTest trieTest = new PrefixTreeTest();
        trieTest.root = new PrefixTreeNode();

        for (int index = 0; index < keys.length ; index++) {
            trieTest.build(keys[index]);
        }

        System.out.println("math result : " + trieTest.search("math"));
        System.out.println("coder result : " + trieTest.search("coder"));
        System.out.println("test result : " + trieTest.search("test"));
    }

}
