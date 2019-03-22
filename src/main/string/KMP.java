package main.string;

/**
 * KMP算法
 * @author pankarl
 *
 */
public class KMP {
	/**
	 * 使用KMP算法查找子串位置
	 * @param src
	 * @param des
	 * @return
	 */
	public static int findStringByKMP(String src, String des) {
		int i=0, j=0;
		int[] next = getNext(des);
		while(i < src.length() && j < des.length()) {
			if(j == -1 || src.charAt(i) == des.charAt(j)) { //当第一个就不匹配时，子字符串索引归位，主字符串后移一位
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j == des.length()) {
			return i - j;
		}
		return -1;
	}
	
	/**
	 * 获取j回退的位置
	 * @param str
	 * @return
	 */
	public static int[] getNext(String str) {
		char[] c = str.toCharArray();
		int[] next = new int[str.length()];
		int j = 0, k = -1;
		next[0] = -1;
		while(j < str.length() - 1) {
			if(k == -1 || c[j] == c[k]) {
				next[++j] = ++k;
			}else {
				k = next[k];
			}
		}
		return next;
	}
}
