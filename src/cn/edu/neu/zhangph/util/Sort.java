package cn.edu.neu.zhangph.util;

public class Sort {
	/**
	 * 快速排序 
	 */
	public static void qSort(int[] num, int low, int high){
		if(low < high){
			int  loc = quickSort(num, low, high);
			qSort(num, low, loc - 1);
			qSort(num, loc + 1, high);
		}
	}
	private static int quickSort(int[] num, int low, int high){
		int piovt = num[low];
		while(low < high){
			while(low < high && piovt <= num[high])high--;
			num[low] = num[high];
			while(low < high && piovt >= num[low]) low++;
			num[high] = num[low];
		}
		num[low] = piovt;
		return low;
	}
	
	/**
	 * 堆排序
	 * 	(最大堆)
	 */
	public static void heapSort(int[] num){
		Heap.buildMaxHeap(num);
		for (int i = num.length - 1; i > 1 ; i--) {
			int tmp = num[1];
			num[1] = num[i];
			num[i] = tmp;
			num[0] -= 1;
			Heap.maxHeapify(num, 1);
		}
	}
}

