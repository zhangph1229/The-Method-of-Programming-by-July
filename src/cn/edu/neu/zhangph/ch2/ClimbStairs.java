package cn.edu.neu.zhangph.ch2;
/**
 * 
 * @author zhangph
 * ��̨������
 */
public class ClimbStairs {
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
		System.out.println(climbStairs(5));
	}
	/**
	 * ֻ����һ�����������������
	 * @param n
	 * @return
	 */
	public static long fibonacci(int n){
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		return fibonacci(n - 1) + fibonacci(n -2);
	}
	/**
	 * ������1,2,3ʱ 
	 */
	public static long fibonacci3(int n){
		int[] res= {1,2,4};
		if(n <= 3) return res[n - 1];
		return fibonacci3(n - 1) + fibonacci3(n - 2) + fibonacci3(n - 3);
	}
	/**
	 * ���Ʒ���
	 * @param n
	 * @return
	 */
	public static long climbStairs(int n){
		int[] dp = {1,1,1};
		if(n < 2) return 1;
		for (int i = 2; i <= n; i++) {
			dp[2] = dp[0] + dp[1];
			dp[0] = dp[1];
			dp[1] = dp[2];
		}
		return dp[2];
	}
}
