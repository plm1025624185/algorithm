package main.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 哈夫曼树
 * 
 * 概述：这里使用array数组简单实现哈夫曼树，这里暂时只存储字符
 * 
 * @author pankarl
 *
 */
public class HuffmanArrayTree {
	private HuffmanNode[] nodes;
	
	/**
	 * 
	 * @param data 所要编码的字符集合
	 * @param weights 对应的权重集合
	 */
	public HuffmanArrayTree(char[] data, int[] weights) {
		// 哈夫曼树的总结点数为2n-1，n为所要编码的数量
		nodes = new HuffmanNode[2 * data.length - 1];
		for(int i = 0; i < data.length; i++) {
			nodes[i] = new HuffmanNode(data[i], weights[i]);
		}
		createHuffmanTree();
	}
	
	/**
	 * 构建哈夫曼树
	 */
	private void createHuffmanTree() {
		if(nodes[nodes.length - 1] != null) {
			return;
		}
		int left = -1;
		int right = -1;
		int tmp = nodes.length;
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i] == null) {
				tmp = i;
				break;
			}
			if(nodes[i].parent == -1) {
				if(left == -1) {
					left = i;
				}else if(right == -1) {
					if(compareWith(nodes[left], nodes[i])) {
						right = i;
					}else {
						right = left;
						left = i;
					}
				}else {
					if(compareWith(nodes[i], nodes[right])) {
						right = i;
						if(compareWith(nodes[i], nodes[left])) {
							right = left;
							left = i;
						}
					}
				}
			}
		}
		if(tmp != nodes.length) {
			nodes[tmp] = new HuffmanNode('#', nodes[left].weight + nodes[right].weight);
			nodes[tmp].lchild = left;
			nodes[tmp].rchild = right;
			nodes[left].parent = tmp;
			nodes[right].parent = tmp;
			createHuffmanTree();
		}
	}
	
	/**
	 * 比较左边是否小于右边
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean compareWith(HuffmanNode left, HuffmanNode right) {
		if(left.weight < right.weight) {
			return true;
		}
		return false;
	}
	
	/**
	 * 对哈夫曼树进行层次遍历输出
	 * @return
	 */
	public String levelTraversal() {
		StringBuffer sb = new StringBuffer();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(nodes.length - 1);
		levelTraversal(sb, queue);
		return sb.toString();
	}
	
	private void levelTraversal(StringBuffer sb, Queue<Integer> queue) {
		if(queue.isEmpty()) {
			return;
		}
		HuffmanNode node = nodes[queue.poll()];
		sb.append(String.format("值为%c权值为%d-", node.value, node.weight));
		if(node.lchild != -1) {
			queue.add(node.lchild);
		}
		if(node.rchild != -1) {
			queue.add(node.rchild);
		}
		levelTraversal(sb, queue);
	}
	
	/**
	 * 生成哈夫曼编码
	 * @return
	 */
	public String huffmanCode() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i].lchild == -1 && nodes[i].rchild == -1) {
				sb.append(huffmanCode(i));
			}
		}
		return sb.toString();
	}
	
	private String huffmanCode(int index) {
		Stack<Integer> stack = new Stack<>();
		int cur = index;
		int par = nodes[cur].parent;
		while(par != -1) {
			if(nodes[par].lchild == cur) {
				stack.push(0);
			}else {
				stack.push(1);
			}
			cur = par;
			par = nodes[cur].parent;
		}
		StringBuilder sb = new StringBuilder(String.format("%c的哈夫曼编码为：", nodes[index].value));
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	private class HuffmanNode implements Comparable<HuffmanNode> {
		private char value; //节点值
		private int weight; //权重
		private int parent; //父节点
		private int lchild; //左孩子节点
		private int rchild; //右孩子节点
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof HuffmanNode) {
				HuffmanNode tmp = (HuffmanNode)obj;
				if(this.value == tmp.value && this.weight == tmp.weight) {
					return true;
				}
			}
			return false;
		}

		private HuffmanNode(char value, int weight) {
			this.weight = weight;
			this.parent = -1;
			this.value = value;
			this.lchild = -1;
			this.rchild = -1;
		}

		@Override
		public int compareTo(HuffmanNode o) {
			if(this.weight < o.weight) {
				return -1;
			}else if(this.weight < o.weight) {
				return 2;
			}
			return 0;
		}
	}
}
