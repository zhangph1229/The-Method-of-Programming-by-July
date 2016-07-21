package cn.edu.neu.zhangph.ch2;

import cn.edu.neu.zhangph.util.ListNode;

public class OddEvenSort {
	public static void main(String[] args) {
		int[] num = {1,2,4,5,6,7,8,9};
		oddEven(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
//		oddEvenList(node1);
		oddEvenIndex(node1);
		
		ListNode p = node1;
		while(p != null){
			System.out.print(p.val + "-->");
			p = p.next;
		}
		System.out.println("Null");
		
	}
	/**
	 * 类似于快排，使用一个枢轴元素，将两边分成奇数和偶数
	 */
	public static void oddEven(int[] num){
		int low = 0, high = num.length - 1;
		int tmp = num[low];
		while(low < high){
			while(low < high && num[high] % 2 == 0) high--;
			num[low] = num[high];
			while(low < high && num[low] % 2 != 0) low++;
			num[high] = num[low];
		}
		num[low] = tmp;
	}
	
	/**
	 * 如果是链表形式，将奇偶数分开
	 */
	public static void oddEvenList(ListNode node1){
		if(node1 == null) return;
		ListNode odd = null, even = null, oddend = null, evenend = null, p = node1;
		while(p != null){
			if(p.val % 2 != 0) {
				if(odd == null){
					odd = oddend = p;
				}else{
					oddend.next = p;
					oddend = oddend.next;
				}
			}else{
				if(even == null){
					even = evenend = p;
				}else {
					evenend.next = p;
					evenend = evenend.next;
				}
			}
			System.out.println(p.val);
			p = p.next;
		}
		if(evenend != null)evenend.next = null;
		if(oddend != null) oddend.next = even;
	}
	/**
	 * 使用链表的标号，奇偶性分开
	 */
	public static void oddEvenIndex(ListNode head){
		if(head == null) return;
		ListNode odd = null, even = null, oddend = null, evenend = null;
		int count = 1;
		while(head != null){
			if(count % 2 != 0){
				if(odd == null){
					odd = oddend = head;
				}else{
					oddend.next = head;
					oddend = oddend.next;
				}
			}else {
				if(even == null){
					even = evenend = head;
				}else {
					evenend.next = head;
					evenend = evenend.next;
				}
			}
			head = head.next;
			count++;
		}
		if(evenend != null)evenend.next = null;
		if(oddend != null) oddend.next = even;
	}
}
