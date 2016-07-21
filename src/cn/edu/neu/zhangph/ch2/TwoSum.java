package cn.edu.neu.zhangph.ch2;

import java.util.*;
public class TwoSum {
	public static void main(String[] args) {
		int[] num = {1,2,4,5,7,11,15};
//		int[] res = twoSum_hash(num, 15);
//		int[] res = twoSum_squeeze(num, 15);
//		int[] res = twoSum_hashmap(num, 15);
		int[] res = twoSum_hashmap_index(num, 15);
		if(res != null)
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i] + " ");
			}
	}
	
	/**
	 * 使用散列 
	 * 	1. 先把输入的sum减去数组中的每个数，存放的一个hash表中
	 * 	2. 遍历数组，如果在hash表中存在，则返回两个值，如果不存在返回null
	 */
	public static int[] twoSum_hash(int[] num, int sum){
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < num.length; i++) {
			set.add(sum - num[i]);
			if(set.contains(num[i])){
				return new int[]{num[i], sum - num[i]};
			}
		}
		return null;
	}
	public static int[] twoSum_hashmap_index(int[] num, int sum){
		Map<Integer, Integer> map  = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			if(map.containsKey(sum - num[i])){
				return new int[] {map.get(sum - num[i]) + 1, i + 1};
			}
			map.put(num[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	/**
	 * 问题扩展中的第一个，如果在返回找到的两个数时，还要返回这两个数的位置 
	 */
    public static int[] twoSum_hashmap(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}
			if(map.containsKey(target - nums[i])){
				int num = map.get(target - nums[i]);
				if(num < i){
					return new int[]{nums[num], nums[i], num + 1, i + 1};
				}
			}
		}
        return null;
    }
	/**
	 * 排序夹逼方法（对于已经有序的数组）
	 * 	设置前后两个指针low，high，如果两个数的和大于sum，high--，如果小于sum，low++
	 */
	public static int[] twoSum_squeeze(int[] num, int sum){
		Arrays.sort(num);   //双piovt的快排方法
		int low = 0, high = num.length - 1;
		while(low < high){
			if(num[low] + num[high] > sum)high--;
			else if(num[low] + num[high] < sum) low++;
			else return new int[]{num[low], num[high]};
		}
		return null;
	}
	
	/**
	 * 使用二分法
	 * 对于已经排序的，或者使用排序算法后有序的
	 */
	public static int[] twoSum_bin(int[] num, int sum){
		for (int i = 0; i < num.length; i++) {
			int j = binSearch(num, sum - num[i], i + 1);
			if(j != -1) return new int[] {i + 1, j + 1};
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	private static int binSearch(int[] num, int value, int low){
		int left = low, right = num.length - 1;
		while(left < right){
			int mid = (left + right)/2;
			if(num[mid] < value){
				left = mid + 1;
			}else right = mid;
		}
		return left == right && num[left] == value ? left : -1; 
	}
}
