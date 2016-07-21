package cn.edu.neu.zhangph.ch1;

import java.util.*;

public class StrContains {
	public static void main(String[] args) {
		char[] a = {'A', 'B', 'F', 'D', 'E'};
		char[] b = {'B', 'E', 'C'};
		System.out.println(strContains_sort(a, b));
		System.out.println(strContains_hashmap(a, b));
		System.out.println(strContains_array(a, b));
		System.out.println(strContains_prime(a, b));
		System.out.println(strContains_bin(a, b));
	}
	/**
	 * 先对字符串排序，然后轮询
	 */
	public static boolean strContains_sort(char[] a, char[] b){
		Arrays.sort(a);
		Arrays.sort(b);
		int j = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] == b[j]) j++;
			else if(a[i] < b[j]) continue;
		    else return false;
		}
		if(j < b.length) return false;
		else return true;
	}
	/**
	 * 使用散列 
	 */
	public static boolean strContains_hashmap(char[] a, char[] b){
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			if(!set.contains(b[i])) return false;
		}
		return true;
	}
	/**
	 * 跟散列类似 
	 */
	public static boolean strContains_array(char[] a, char[] b){
		boolean[] judge = new boolean[256]; //just 
		for (int i = 0; i < a.length; i++) {
			judge[a[i]] = true;
		}
		for (int i = 0; i < b.length; i++) {
			if(!judge[b[i]]) return false;
		}
		return true;
	}
	/**
	* 素数相乘
	*/
	public static boolean strContains_prime(char[] a, char[] b){
		//存在问题，，当a中包括字符多时，value就会溢出，导致程序出错！！！
		int[] prime = {2, 3, 5, 7, 13, 17, 19, 21, 23, 29, 31, 37, 41, 43, 47,
				53, 57, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
		long value = 1;
		for (int i = 0; i < a.length; i++) {
			value *= prime[a[i] - 'A'];
		}
		for (int i = 0; i < b.length; i++) {
			if(value % prime[b[i] - 'A'] != 0) return false;
		}
		return true;
	}
	/**
	 * 使用位移，对每个字符产生一个签名 
	 */
	public static boolean strContains_bin(char[] a, char[] b){
		int bin = 0;
		for (int i = 0; i < a.length; i++) {
			bin |= (1 << (a[i] - 'A'));
		}
		for (int i = 0; i < b.length; i++) {
			if((bin & (1 << b[i] - 'A')) == 0) return false;
		}
		return true;
	}
}
