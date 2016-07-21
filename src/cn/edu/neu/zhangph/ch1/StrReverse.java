package cn.edu.neu.zhangph.ch1;

public class StrReverse {
	public static void main(String[] args) {
		char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		System.out.println(strReverse(str, 3));
	}
	public static char[] strReverse(char[] str, int num){
		if(str != null){
			reverse(str, 0, num - 1);
			reverse(str, num, str.length - 1);
			reverse(str, 0, str.length - 1);
		}
		return str;
	}
	private static void reverse(char[] str, int low, int high){
		while(low < high){
			char tmp = str[low];
			str[low] = str[high];
			str[high] = tmp;
			low++;
			high--;
		}
	}
}
