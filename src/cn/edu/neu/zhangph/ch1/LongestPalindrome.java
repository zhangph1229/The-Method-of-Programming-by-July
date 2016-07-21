package cn.edu.neu.zhangph.ch1;

public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("zhangph1221"));
		System.out.println(longestPalindrome("crane131"));
	}
	
	//
	public static int longestPalindrome(String str){
		//分成两个部分，奇数和偶数
		int max = 0, c = 0;
		if(str == null || str.length() == 0) return 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; (i - j) >= 0 && (i + j) < str.length() ; j++) {
				if(str.charAt(i - j) != str.charAt(i + j))break;
				c = j * 2 + 1;
			}
			if(c > max) max = c;
			for (int j = 0; (i - j) >= 0 && (i + j + 1) < str.length(); j++) {
				if(str.charAt(i - j) != str.charAt(i + j + 1))break;
				c = j * 2 + 2;
			}
			if(c > max) max = c;
		}
		return max;
	}
	
	public static String longestPalindrome_str(String str){
		String sb = null;
		for (int i = 0; i < str.length(); i++) {
			int j = 0;
			for (; (i - j) >= 0 && (i + j) < str.length() ; j++) {
				if(str.charAt(i - j) != str.charAt(i + j))break;
			}
			if(sb.length() < j * 2 + 1){
				sb = str.substring(i, i+j*2+1);
			}
			int k = 0;
			for (; (i - k) >= 0 && (i + k + 1) < str.length(); k++) {
				if(str.charAt(i - k) != str.charAt(i + k + 1))break;
			}
			if(sb.length() < k * 2 + 2){
				sb = str.substring(i, i + i + k * 2 + 1);
			}
		}
		return sb;
	}
}
