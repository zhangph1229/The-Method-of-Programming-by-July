package cn.edu.neu.zhangph.util;

public class Heap{
	private static int parent(int i){
		return i/2;
	}
	private static int left(int i) {
		return 2*i;
	}
	private static int right(int i){
		return 2*i + 1;
	}
	/**
	 * 最大堆的维护
	 */
	public static void maxHeapify(int[] num, int i){
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left <= num[0] && num[left] > num[i]){
			largest = left;
		} 
		if(right <= num[0] && num[right] > num[largest]) largest = right;
		if(largest != i){
			int tmp = num[i];
			num[i] = num[largest];
			num[largest] = tmp;
			maxHeapify(num, largest);
		}
	}
	/**
	 * 最大堆的建立
	 */
	public static void buildMaxHeap(int[] num){
		num[0] = num.length - 1;
		for(int i = (num.length - 1) / 2; i > 0; i--){
			maxHeapify(num, i);
		}
	}
	
}
