package cn.edu.neu.zhangph.ch1;

public class IsPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("abaaaba"));
	}
	//从两端向中间
	public static boolean isPalindrome(String str){
		int low = 0, high = str.length() - 1;
		while(low < high){
			if(str.charAt(low) != str.charAt(high)) return false;
			low++;
			high--;
		}
		return true;
	}
	//从中间到两端 pass
}
