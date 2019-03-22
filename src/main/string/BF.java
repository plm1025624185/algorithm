package main.string;

/**
 * 找寻S字符串中是否存在子字符串T
 * BF算法思想：
 * 1.从S第1个字符开始，与T第1个字符比较，如果相等，继续比较下一个字符，否则转向下一步;
 * 2.从S第2个字符开始，与T第1个字符比较，如果相等，继续比较下一个字符，否则转向下一步;
 * 3.从S第3个字符开始，与T第1个字符比较，如果相等，继续比较下一个字符，否则转向下一步;
 * ...
 * 4.如果T比较完毕，则返回T在S中第一个字符出现的位置。
 * 5.如果S比较完毕，则返回-1，说明T在S中未出现。
 * @author pankarl
 *
 */
public class BF {
	/**
	 * 根据BF算法查找字符串，功能类似String.indexOf
	 * @param src
	 * @param des
	 * @return
	 */
	public static int findStringByBF(String src, String des){
		//首先判断长度，源字符串长度应该大于需要查找的目标字符串
		if(src.length() < des.length()) {
			return -1;
		}
		for(int i = 0; i < src.length() - des.length() + 1; i++) {
			boolean flag = true;
			for(int j = 0; j < des.length(); j++) {
				if(src.charAt(i + j) != des.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				return i;
			}
		}
		return -1;
	}
}
