package cn.edu.neu.zhangph.ch5;

public class MaxSubMul {
	public static void main(String[] args) {
		double[] num = {-2,5,4,0,3,0.5,8};
		System.out.println(maxSubMul(num));
	}
	public static double maxSubMul(double[] num){
		double max = num[0], min = num[0];
		double res = num[0];
		for (int i = 1; i < num.length; i++) {
			double end1 = max * num[i];
			double end2 = min * num[i];
			max = Math.max(Math.max(end1, end2), num[i]);
			min = Math.min(Math.min(end1, end2), num[i]);
			res = Math.max(max, min);
		}
		return res;
	}
}
