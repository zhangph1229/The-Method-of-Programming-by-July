package cn.edu.neu.zhangph.ch2;

public class MaxSubArray {
	public static void main(String[] args) {
		int arr[] = {1,-2,3,10,-4,7,2,-5};
		int res[]  = maxSubArray(arr);
		System.out.println(res[0] + " " + res[1]);
	}
	public static int[] maxSubArray(int[] arr){
		/*
		 * locSum(i) = max{0, locSum(i - 1)} + arr[i]
		 */
		int[] loc = new int[2];
		int locSum = 0;
		int maxSum = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(locSum >= 0) {
				locSum += arr[i];
			}else {
				locSum = arr[i];
				loc[0] = i + 1;
			}
			if(locSum > maxSum){
				maxSum = locSum;
				loc[1] = i + 1;
			}
		}
		
		return loc;
	}
}
