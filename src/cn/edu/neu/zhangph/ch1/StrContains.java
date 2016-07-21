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
	 * �ȶ��ַ�������Ȼ����ѯ
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
	 * ʹ��ɢ�� 
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
	 * ��ɢ������ 
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
	* �������
	*/
	public static boolean strContains_prime(char[] a, char[] b){
		//�������⣬����a�а����ַ���ʱ��value�ͻ���������³����������
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
	 * ʹ��λ�ƣ���ÿ���ַ�����һ��ǩ�� 
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
