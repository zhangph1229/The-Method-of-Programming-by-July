package cn.edu.neu.zhangph.ch2;
/**
 * 
 * @author zhangph
 * 跳台阶问题
 */
public class ClimbStairs {
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
		System.out.println(climbStairs(5));
	}
	/**
	 * 只能跳一个或者跳两个的情况
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
	 * 可以跳1,2,3时 
	 */
	public static long fibonacci3(int n){
		int[] res= {1,2,4};
		if(n <= 3) return res[n - 1];
		return fibonacci3(n - 1) + fibonacci3(n - 2) + fibonacci3(n - 3);
	}
	/**
	 * 递推方法
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
