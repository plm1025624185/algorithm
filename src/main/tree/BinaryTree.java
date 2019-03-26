package main.tree;

import java.util.LinkedList;
import java.util.Queue;

import main.exception.IllegalTypeException;

/**
 * 二叉树
 *     这里先简单的用char字符串进行存储，这里通过补空法完成对二叉树的创建
 *     
 * 补空法
 *     补空法是指如果左子树或右子树为空时，则用特殊字符补空，如“#”。
 *     然后按照先序遍历的顺序，得到先序遍历序列，根据该序列递归创建二叉树。
 *     
 * @author pankarl
 *
 */
public class BinaryTree {
	private BinaryNode root; //二叉树的根节点
	private final char DEFAULT_PLACEHOLDER = '#'; //默认占位符
	
	private char placeHolder; //占位符
	private String data; //需要存储的数据
	
	private int preIndex; //由于先序排序节点必定比左右子树先出现，为了减少比较次数，故设为全局变量，进行累加
	
	public BinaryTree() {
		this.placeHolder = DEFAULT_PLACEHOLDER;
		this.data = null;
	}
	
	/**
	 * 补空法创建二叉树
	 * @param value
	 * @param placeHolder
	 */
	public BinaryTree(String value, char placeHolder) {
		this.placeHolder = placeHolder;
		this.data = value;
		this.root = new BinaryNode();
		createBinaryTree(root); //创建二叉树
	}
	
	/**
	 * 根据先序中序还是中序后序，生成二叉树
	 * @param pre
	 * @param middle
	 * @param order PM为先序中序生成，MP为中序后序生成
	 * @throws IllegalTypeException 
	 */
	public BinaryTree(char[] a, char[] b, String order) {
		if("PM".equals(order)) {
			this.preIndex = 0;
			this.root = new BinaryNode();
			createBinaryTreeByPM(this.root, a, b, 0, b.length);
		}else if("MP".equals(order)) {
			this.root = new BinaryNode();
			createBinaryTreeByMP(this.root, a, b, b.length - 1, 0, a.length);
		}else {
			
		}
		
	}
	
	/**
	 * 创建二叉树
	 * 使用补空法创建二叉树
	 * @param node 节点
	 * @param data 数据
	 */
	private void createBinaryTree(BinaryNode node) {
		if(!(this.data == null || this.data == "")) {
			char value = this.data.charAt(0);
			this.data = this.data.substring(1);
			if(value == placeHolder) {
				node.data = this.placeHolder;
			}else {
				node.data = value;
				node.lchild = new BinaryNode();
				node.rchild = new BinaryNode();
				createBinaryTree(node.lchild); //递归调用左子树
				createBinaryTree(node.rchild); //递归调用右子树
			}
		}
	}
	
	/**
	 * 根据先序和中序，还原创建二叉树
	 * @param node
	 * @param pre
	 * @param mid
	 * @param midIndex
	 * @param midLen
	 */
	private void createBinaryTreeByPM(BinaryNode node, char[] pre, char[] mid, int midIndex, int midLen) {
		if(midLen > 0) {
			node.data = pre[preIndex];
			int midtmp = index(mid, pre[preIndex], midIndex, midLen);
			int lmidlen = midtmp - midIndex;
			if(lmidlen != 0) {
				for(; preIndex < pre.length; preIndex++) {
					if(index(mid, pre[preIndex], midIndex, lmidlen) != -1) {
						break;
					}
				}
				node.lchild = new BinaryNode();
				createBinaryTreeByPM(node.lchild, pre, mid, midIndex, lmidlen);
			}
			int rmidlen = midIndex + midLen - midtmp - 1;
			if(rmidlen != 0) {
				for(; preIndex < pre.length; preIndex++) {
					if(index(mid, pre[preIndex], midtmp + 1, rmidlen) != -1) {
						break;
					}
				}
				node.rchild = new BinaryNode();
				createBinaryTreeByPM(node.rchild, pre, mid, midtmp + 1, rmidlen);
			}
		}
	}
	
	/**
	 * 根据中序和后序，还原创建二叉树
	 * @param node
	 * @param mid
	 * @param post
	 * @param midIndex
	 * @param midLen
	 */
	private void createBinaryTreeByMP(BinaryNode node, char[] mid, char[] post, int postIndex, int midIndex, int midLen) {
		if(midLen > 0) {
			node.data = post[postIndex];
			//在中序中获取根节点位置
			int tmpMid = index(mid, post[postIndex], midIndex, midLen);
			int lmidLen = tmpMid - midIndex;
			if(lmidLen != 0) {
				node.lchild = new BinaryNode();
				int tmppost = postIndex;
				for(; tmppost > -1; tmppost--) {
					if(index(mid, post[tmppost], midIndex, lmidLen) != -1) {
						break;
					}
				}
				createBinaryTreeByMP(node.lchild, mid, post, tmppost, midIndex, lmidLen);
			}
			int rmidLen = midIndex + midLen - tmpMid - 1;
			if(rmidLen != 0) {
				node.rchild = new BinaryNode();
				int tmppost = post.length - 1;
				for(; tmppost > -1; tmppost--) {
					if(index(mid, post[tmppost], tmpMid + 1, rmidLen) != -1) {
						break;
					}
				}
				createBinaryTreeByMP(node.rchild, mid, post, tmppost, tmpMid + 1, rmidLen);
			}
		}
	}
	
	/**
	 * 查找字符
	 * @param source
	 * @param des
	 * @param begin
	 * @param length
	 * @param flag 是否是正向查找
	 * @return
	 */
	private int index(char[] source, char des, int begin, int length, boolean flag) {
		for(int i = 0; i < length; i ++) {
			if(flag) {
				if(des == source[begin + i]) {
					return begin + i;
				}
			}else {
				if(des == source[begin - i]) {
					return begin - i;
				}
			}
		}
		return -1;
	}
	
	private int index(char[] source, char des, int begin, int length) {
		return index(source, des, begin, length, true);
	}
	
	/**
	 * 先序输出各节点的值
	 * @return
	 */
	public String dlr() {
		StringBuffer sb = new StringBuffer();
		dlr(sb, root);
		return sb.toString();
	}
	
	/**
	 * 先序遍历二叉树
	 * 
	 * 概述：先序遍历是指先访问根，然后先序遍历左子树，再先序遍历右子树，即DLR
	 * 
	 * 算法步骤：
	 *     如果二叉树为空，则空操作，否则
	 *     1)访问根节点
	 *     2)先序遍历左子树
	 *     3)先序遍历右子树
	 * 
	 * @param sb
	 * @param node
	 */
	private void dlr(StringBuffer sb, BinaryNode node) {
		if(node != null) {
			//先访问根节点
			sb.append(node.data);
			if(!node.isLeaf()) {
				//然后访问左子树
				dlr(sb, node.lchild);
				//最后访问右子树
				dlr(sb, node.rchild);
			}
		}
	}
	
	/**
	 * 中序遍历二叉树
	 * @param sb
	 * @param node
	 */
	public String ldr() {
		StringBuffer sb = new StringBuffer();
		ldr(sb, this.root);
		return sb.toString();
	}
	
	/**
	 * 中序遍历二叉树
	 * 
	 * 概述：中序遍历是值中序遍历左子树，然后访问根，再中序遍历右子树，即LDR
	 * 
	 * 算法步骤：
	 *     如果二叉树为空，则空操作，否则
	 *     1)中序遍历左子树
	 *     2)访问根节点
	 *     3)中序遍历右子树
	 * 
	 * @param sb
	 * @param node
	 */
	private void ldr(StringBuffer sb, BinaryNode node) {
		if(node != null) {
			//首先遍历左子树
			ldr(sb, node.lchild);
			//然后在访问根节点
			sb.append(node.data);
			//最后访问右子树
			ldr(sb, node.rchild);
		}
	}
	
	/**
	 * 后序遍历二叉树
	 * @return
	 */
	public String lrd() {
		StringBuffer sb = new StringBuffer();
		lrd(sb, this.root);
		return sb.toString();
	}
	
	/**
	 * 后序遍历二叉树
	 * 
	 * 概述：后序遍历是指后序遍历左子树，后序遍历右子树，然后访问根，即LRD
	 * 
	 * 算法步骤：
	 *     如果二叉树为空，则空操作，否则
	 *     1)后序遍历左子树
	 *     2)后序遍历右子树
	 *     3)访问根节点
	 * 
	 * @param sb
	 * @param node
	 */
	private void lrd(StringBuffer sb, BinaryNode node) {
		if(node != null) {
			//先遍历左子树
			lrd(sb, node.lchild);
			//再遍历右子树
			lrd(sb, node.rchild);
			//最后访问根
			sb.append(node.data);
		}
	}
	
	/**
	 * 层次遍历
	 * @return
	 */
	public String levelTraversal() {
		StringBuilder sb = new StringBuilder();
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		levelTraversal(sb,root, queue);
		return sb.toString();
	}
	
	/**
	 * 层次遍历
	 * 
	 * 概述：层次遍历是从低层级到高层级进行节点遍历
	 * 
	 * @param sb
	 * @param node
	 * @param queue
	 */
	private void levelTraversal(StringBuilder sb, BinaryNode node, Queue<BinaryNode> queue) {
		if(node != null) {
			sb.append(node.data);
			queue.add(node.lchild);
			queue.add(node.rchild);
		}
		if(!queue.isEmpty()) {
			levelTraversal(sb, queue.poll(),queue);
		}
	}
	
	/**
	 * 获取树的深度
	 * @return
	 */
	public int depth() {
		return depth(root, 0);
	}
	
	/**
	 * 获取树的深度
	 * @param node
	 * @param depth
	 * @return
	 */
	public int depth(BinaryNode node, int depth) {
		if(node.isLeaf() && node.data != this.placeHolder) {
			return depth + 1;
		}else if(node.isLeaf() && node.data == this.placeHolder) {
			return depth;
		}else {
			depth = depth + 1;
			int left = depth(node.lchild, depth);
			int right = depth(node.rchild, depth);
			return Math.max(left, right);
		}
	}
	
	/**
	 * 二叉树节点
	 * @author pankarl
	 *
	 */
	private class BinaryNode {
		private char data; //存储的数据
		private BinaryNode lchild; //左孩子
		private BinaryNode rchild; //右孩子
		
		/**
		 * 是否是叶子节点
		 * @return
		 */
		private boolean isLeaf() {
			return lchild == null && rchild == null;
		}
	}
}
