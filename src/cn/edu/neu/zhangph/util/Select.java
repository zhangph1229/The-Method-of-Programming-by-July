package cn.edu.neu.zhangph.util;

public class Select {
	public static int max(int[] num){
		int max = num[0];
		int loc = 0;
		for (int i = 1; i < num.length; i++) {
			if(num[i] > max) {
				max = num[i];
				loc = i;
			}
		}
		return loc;
	}
	public static int min(int[] num){
		int min = num[0];
		int loc = 0;
		for (int i = 0; i < num.length; i++) {
			if(num[i] < min) {
				min = num[i];
				loc = i;
			}
		}
		return loc;
	}
}
