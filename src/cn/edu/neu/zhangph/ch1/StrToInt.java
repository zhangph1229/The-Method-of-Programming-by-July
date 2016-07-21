package cn.edu.neu.zhangph.ch1;

public class StrToInt {
	public static void main(String[] args) {
		System.out.println(atoi("2147483648"));
	}
	
	/**
	 * 1. ע���Ƿ�Ϊ��
	 * 2. �ж�ǰ���Ƿ��пո�
	 * 3. �Ƿ��з���
	 * 4. �ж��Ƿ��ǺϷ�������
	 * 5. �ж����
	 */
	private static final int maxDiv10 = Integer.MAX_VALUE / 10; 
	public static int atoi(String value){
		if(value == null || value.length() == 0) return 0;
		int num = 0, n = value.length(); 
		int i = 0;
		for (; i < value.length() && Character.isWhitespace(value.charAt(i)); i++);
		int sign = 1; // 1 �������� -1 ����
		if(value.charAt(i) == '-'){
			sign = -1;
			i++;
		}
		for (;  i < value.length() && Character.isDigit(value.charAt(i)); i++) {
			int digit = Character.getNumericValue(value.charAt(i));
			if(num > maxDiv10 || (num == maxDiv10 && digit >= 8)) {
				return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
		}
		return sign * num;
	}
}
