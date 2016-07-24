package cn.edu.neu.zhangph.ch2.practice;
/**
 * 唯一重复的元素
 * @author zhangph
 * 
 */
public class UniqueElement {
	public static void main(String[] args) {
		int[] num = new int[1001];
		for (int i = 0; i < 1000; i++) {
			num[i] = i + 1;
		}
		num[1000] = 300;
		System.out.println(uniqueElements(num));
	}
	public static int uniqueElements(int[] num){
		int sum = 0;
		for (int i = 1; i < 1001; i++) {
			sum += i;
		}
		for (int i = 0; i < num.length; i++) {
			sum -= num[i];
		}
		return -1 * sum;
	}
}
