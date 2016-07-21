package cn.edu.neu.zhangph.ch2;

public class HollandFlag {
	public static void main(String[] args) {
		int[] num = {0,1,2,1,1,2,0,2,1,0};
		hollandFlag(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	public static void hollandFlag(int[] num){
		int begin = 0, current = 0, end = num.length - 1;
		while(current <= end){
			if(num[current] == 0){
				int tmp = num[begin];
				num[begin] = num[current];
				num[current] = tmp;
				begin++;
				current++;
			}else if(num[current] == 1){
				current++;
			}else{
				int tmp = num[end];
				num[end] = num[current];
				num[current] = tmp;
				end--;
			}
		}
	}
}
