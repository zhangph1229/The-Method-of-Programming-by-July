package cn.edu.neu.zhangph.ch2;

import java.util.*;
/**
 * 
 * @author zhangph
 * 延续two sum 问题，如果一个数组，找出三个数使得三个数的和为0。
 * 例如：int[] num = {-1,0,1,2,-1,-4}
 * 返回{[-1,0,1],[-1,-1,2]}
 */
public class ThreeSum {
	public static void main(String[] args) {
		int[] num = {-2,-1,0,1,1,0,2};
		List<List<Integer>> lists = threeSum1(num);
		for (Iterator iterator = lists.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 先对数组进行排序（O(nlogn)），然后在使用快慢指针进行遍历数组
	 */
	public static List<List<Integer>> threeSum1(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> lists = new ArrayList<>();
		int  high = nums.length - 1;
		for(int low = 0; low < nums.length - 2; low++){
			int cursor = high - 1;
				while(low < cursor && cursor < high){
					int sum = nums[low] + nums[high] + nums[cursor];
					if(sum < 0){
						low++;
					}else if(sum > 0){
						cursor--;
					}else {
						lists.add(Arrays.asList(nums[low], nums[cursor], nums[high]));
						cursor--;
					}
					
				}
		
			high--;
		}
		return lists;
	}
	
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
    	List<List<Integer>> lists = new LinkedList<>();
    	for (int i = 0; i < nums.length - 2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
				int loc = i + 1;
				int high = nums.length - 1;
				int sum = -nums[i];
				while(loc < high){
					if(nums[loc] + nums[high] == sum){
						lists.add(Arrays.asList(nums[i], nums[loc], nums[high]));
						while(loc < high && nums[loc] == nums[loc + 1]) loc++;
						while(loc < high && nums[high] == nums[high - 1]) high--;
						loc++;
						high--;
					}else if(nums[loc] + nums[high] < sum){
						loc++;
					}else high--;
				}
			}
		}
    	return lists;
    }
}
