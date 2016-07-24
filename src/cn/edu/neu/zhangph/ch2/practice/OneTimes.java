package cn.edu.neu.zhangph.ch2.practice;
/**
 * 1���ֵĴ���
 * ���� n = 12 Ҳ���� [1:12]��1���ֵĴ��� 1��10��11��12������5�Ρ�
 * @author zhangph
 *
 */
public class OneTimes {
	public static void main(String[] args) {
		System.out.println(oneTimesNiave(13));
	}
	public static int oneTimesNiave(int n){
		int num = 1;
		for (int i = 2; i <= n; i++) {
			num  += numberOf1(i);
		}
		return num;
	}
	private static int numberOf1(int i){
		int num = 0;
		while(i > 0){
			if(i % 10 == 1){
				num++;
			}
			i /= 10;
		}
		return num;
	}
	
	
}
