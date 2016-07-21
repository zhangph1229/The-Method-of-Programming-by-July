package cn.edu.neu.zhangph.ch2;

import java.util.*;
public class SumOfkNumber {
	public static void main(String[] args) {
//		sumOfkNum(10, 10);
		search(10,10);
	}
	
	public static Stack<Integer> stack = new Stack<>();
	public static void sumOfkNum(int sum, int n){
		if(n <= 0 || sum <= 0) {
			return;
		}
		if(sum == n){
			for (Iterator iterator = stack.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				System.out.print(integer + " ");
			}
			System.out.printf("%d\n", n);
		}
		stack.push(n);
		sumOfkNum(sum - n, n - 1);
		stack.pop();
		sumOfkNum(sum, n - 1);
	}
	public static void sumOfkNumber(int t, int k, int r, int M, boolean flag, boolean[] X){
		X[k] = true;
		if( t + k == M){
			flag = true;
			for(int i = 1; i <= k; i++){
				if(X[i] == true){
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}else {
			if(t + k + (k + 1) <= M){
				sumOfkNumber(t+k, k+1, r-k, M, flag, X);
			}
			if((t + r -k >= M) && (t + (k + 1)) <= M){
				X[k] = false;
				sumOfkNumber(t, k+1, r - k, M, flag, X);
			}
		}
	}
	public static void search(int n, int M){
		boolean[] X = new boolean[n + 1];
		int sum = (n + 1) * n / 2;
		if( 1 > M || sum < M){
			return;
		}
		boolean f = false;
		sumOfkNumber(0, 1, sum, M, f, X);
	}
}
