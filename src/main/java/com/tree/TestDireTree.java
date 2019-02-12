package com.tree;

/**
 * 字典树实现
 * 
 * @author qiaodongjie
 * @date 2018年12月8日 下午9:54:15
 *
 */
class TreeNode {
	final static int MAX_SIZE = 26;
	char data;
	boolean isEnd = false;
	TreeNode[] childs;

	public TreeNode() {
		childs = new TreeNode[26];
		isEnd = false;
	}
}

public class TestDireTree {
	public static void createTree(TreeNode node, String str) {
		char[] d = str.toCharArray();
		for (int i = 0; i < d.length; i++) {
			int loc = d[i] - 'a';
			if (node.childs[loc] == null) {
				node.childs[loc] = new TreeNode();
				node.childs[loc].data = d[i];
			}
			node = node.childs[loc];
		}
		node.isEnd = true;
	}

	public static boolean findTree(TreeNode node, String str) {
		char[] d = str.toCharArray();
		for (int i = 0; i < d.length; i++) {
			int loc = d[i] - 'a';
			if (node.childs[loc] != null) {
				node = node.childs[loc];
			} else {
				return false;
			}
		}
		return node.isEnd;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode();
		String[] str = { "java", "python" };
		for (int i = 0; i < str.length; i++) {
			createTree(node, str[i]);
			System.out.println("创建成功");
		}
		boolean findTree = findTree(node, "java");
		boolean findTre = findTree(node, "python");
		System.out.println(findTree);
		System.out.println(findTre);
	}
}
