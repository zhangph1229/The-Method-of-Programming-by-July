package cn.edu.neu.zhangph.ch2;

public class ExchangeCoin {
	static int a[]={1,2,5,10};
	static int temp[]={0,0,0,0};
	public static void function(int sum, int index) {
	    int j,i;
	    if (sum==20) {
	        for (j=0;j<4;j++) System.out.printf("%d ",temp[j]);
	        System.out.printf("\n");
	        return;
	    } else if (sum>20) return;
	    else for (i=index;i<4;i++) {
	        temp[i]++;
	        function(sum+a[i],i);
	        temp[i]--;
	    }
	}
	
	public static void main(String[] args) {
		function(0,0);
	}
}
