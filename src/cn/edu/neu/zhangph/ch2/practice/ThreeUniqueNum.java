package cn.edu.neu.zhangph.ch2.practice;

public class ThreeUniqueNum {
	public static void main(String[] args) {
		int[] num = {1,2,3,3,2,1,4,5,7,4,8,8,5,5,7,17,17,17};
//		int[] res = TwoUniqueNum.twoUniqueNum(num);
		int[] res = TwoUniqueNum.twoUniqueNumSample(num);
		System.out.println(res[0] + ", " + res[1]);
	}
}

class TwoUniqueNum{
	public static int[] twoUniqueNum(int[] num) {
		int N = 0, xor = num[0];    //nΪxor�����λ��1     
		for (int i = 1; i < num.length; i++) xor ^= num[i];
		while (xor > 1) {
			xor >>>= 1;
			N++;
		}
		N = 1 << N;  
		int low = 0, high = num.length - 1, tmp = num[0];
		while (low < high) {  //������ֳ���������
			while (low < high && (num[high] & N) != 0) high--;
			num[low] = num[high];
			while (low < high && (num[low] & N) == 0)  low++;
			num[high] = num[low];
		}
		num[low] = tmp;
		if ((num[low] & N) == 0 && low < num.length - 1) low += 1;
		/**
		 * �ӷֿ��������зֱ��ҳ�һ��ֻ����һ�ε�����
		 */
		int pre = num[0];
		for (int i = 1; i < low; i++) pre ^= num[i];
		int post = num[low];
		for (int i = low + 1; i < num.length; i++)	post ^= num[i];

		return new int[] { pre, post };
	}

	public static int[] twoUniqueNumSample(int[] num) {
		int N = 0, xor = 0;    //nΪxor�����λ��1��Ҳ����Ϊ����ĳһ��Ϊ1��λ��
		for (int i = 0; i < num.length; i++){
			xor ^= num[i];
		}
		int yor = xor;   //�洢һ��xor��������ʱʹ��
		while (yor > 1) {
			yor >>>= 1;
			N++;
		}
		N = 1 << N;
		yor = 0;
		for (int j = 0; j < num.length && (num[j] & N) == 0; j++) {
			yor ^= num[j];
		}

		return new int[] { yor, yor ^ xor };
	}
}
