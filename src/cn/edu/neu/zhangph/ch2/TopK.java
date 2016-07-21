package cn.edu.neu.zhangph.ch2;

import cn.edu.neu.zhangph.util.Heap;
import cn.edu.neu.zhangph.util.Select;
import cn.edu.neu.zhangph.util.Sort;

/**
 * 
 * @author zhangph
 * 寻找最小的k个数
 */
public class TopK {
	public static void main(String[] args) {
		int[] num = {19,3,4,5,1,2,6,32,19,13,33,34};
//		int[] res = topk_allsort(num, 5);
//		int[] res = topk_parksort(num, 7);
//		int[] res = topk_select(num,7);
		int[] res = topk_heap(num, 7);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	/**
	 * 全排序，然后找出前k个 
	 */
	public static int[] topk_allsort(int[] num, int k){
		if(k > num.length) return num;
		int[] res = new int[k];
		Sort.qSort(num, 0, num.length - 1);
		for (int i = 0; i < k; i++) {
			res[i] = num[i];
		}
		return res;
	}
	
	/**
	 * 部分排序，然后替换缓存内容
	 */
	public static int[] topk_parksort(int[] num, int k){
		if(k > num.length) return num;
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = num[i];
		}
		for (int i = k; i < num.length; i++) {
			int j = Select.max(res);
			if(num[i] < res[j]){
				res[j] = num[i];
			}
		}
		return res;
	}
	/**
	 * 用堆代替数组
	 */
	public static int[] topk_heap(int[] num, int k) {
		int res[] = new int[k + 1];
		res[0] = k;
		for (int i = 1; i <= k; i++) {
			res[i] = num[i];
		}
		Heap.buildMaxHeap(res);
		for (int i = k + 1; i < num.length; i++) {
			if(res[1] > num[i]) {
				res[1] = num[i];
				Heap.maxHeapify(res, 1);
			}
		}
		return res;
	}
	/**
	 * 线性选择算法 
	 */
	public static int[] topk_select(int[] num, int k){
		if(k > num.length ) return num;
		quickSelect(num, k, 0, num.length - 1) ;
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = num[i];
		}
		return res;
	}
	
	private static void quickSelect(int[] num, int k, int low, int high) {
		int piovt = num[low];
		int i = low;
		int j = high;
		while (low < high) {
			while (low < high && num[high] >= piovt)
				high--;
			num[low] = num[high];
			while (low < high && num[low] <= piovt)
				low++;
			num[high] = num[low];
		}
		num[low] = piovt;
		if (low >= k)
			quickSelect(num, k, i, low - 1);
		else if (low + 1 < k)
			quickSelect(num, k, low + 1, j);
	}
}
