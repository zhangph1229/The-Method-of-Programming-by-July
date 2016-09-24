package cn.edu.neu.zhangph.ch1;

public class AllPermutation {
	public static void main(String[] args) {
		char[] perm = {'a', 'b', 'c'};
		allPermutation_recursion(perm, 0, perm.length - 1);
	}
	public static void allPermutation_recursion(char[] perm, int from , int to){
		if(to <= 1) return;
		if(from == to) {
			for (int i = 0; i <= to; i++) {
				System.out.print(perm[i] + " ");
			}
			System.out.println();
		}else {
			for (int i = from; i <= to ; i++) {
				swap(perm, i, from);
				allPermutation_recursion(perm, from + 1, to);
				swap(perm, i, from);
			}
		}
	}
	private static void swap(char[] perm, int i, int j){
		char tmp = perm[i];
		perm[i] = perm[j];
		perm[j] = tmp;
	}
	public static void allPermutation_dictionary(char[] perm, int num){
		
	}
}
