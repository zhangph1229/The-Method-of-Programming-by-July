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
	 * ʹ��ɢ�� 
	 * 	1. �Ȱ������sum��ȥ�����е�ÿ��������ŵ�һ��hash����
	 * 	2. �������飬�����hash���д��ڣ��򷵻�����ֵ����������ڷ���null
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
	 * ������չ�еĵ�һ��������ڷ����ҵ���������ʱ����Ҫ��������������λ�� 
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
	 * ����бƷ����������Ѿ���������飩
	 * 	����ǰ������ָ��low��high������������ĺʹ���sum��high--�����С��sum��low++
	 */
	public static int[] twoSum_squeeze(int[] num, int sum){
		Arrays.sort(num);   //˫piovt�Ŀ��ŷ���
		int low = 0, high = num.length - 1;
		while(low < high){
			if(num[low] + num[high] > sum)high--;
			else if(num[low] + num[high] < sum) low++;
			else return new int[]{num[low], num[high]};
		}
		return null;
	}
	
	/**
	 * ʹ�ö��ַ�
	 * �����Ѿ�����ģ�����ʹ�������㷨�������
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
