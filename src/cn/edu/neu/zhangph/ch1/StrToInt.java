package cn.edu.neu.zhangph.ch1;

public class StrToInt {
	public static void main(String[] args) {
		System.out.println(atoi("2147483648"));
	}
	
	/**
	 * 1. 注意是否为空
	 * 2. 判断前面是否有空格
	 * 3. 是否有符号
	 * 4. 判断是否是合法的数字
	 * 5. 判断溢出
	 */
	private static final int maxDiv10 = Integer.MAX_VALUE / 10; 
	public static int atoi(String value){
		if(value == null || value.length() == 0) return 0;
		int num = 0, n = value.length(); 
		int i = 0;
		for (; i < value.length() && Character.isWhitespace(value.charAt(i)); i++);
		int sign = 1; // 1 代表正， -1 代表负
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
