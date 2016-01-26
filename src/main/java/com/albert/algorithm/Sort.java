package com.albert.algorithm;

public class Sort {

	public static Sort sort = new Sort();
	
	/**
	 * 递归快排
	 */
	public static void kuaipai_digui(int[] array) {
		ttt = 0;
		sort.kuaipai_digui(array, 0, array.length - 1);
		System.out.println(ttt);
	}
	
	static int ttt = 0;
	
	private void kuaipai_digui(int[] array, int low, int high) {
		int middle = kuaipai_partition(array, low, high);
		if (middle - 1 > low) {
			if (middle - 1 - low < 7) {
				maopao(array, low, middle - 1);
			} else {
				kuaipai_digui(array, low, middle - 1);
			}
		}
		if (middle + 1 < high) {
			if (high - 1 - middle < 7) {
				maopao(array, middle + 1, high);
			} else {
				kuaipai_digui(array, middle + 1, high);
			}
		}
	}
	
	private int kuaipai_partition(int[] array, int low, int high) {
		ttt++;
//		System.out.println(ttt);
		for(;low < high;) {
			// 从high向low找到第一个比low小的数 交换
			for (;low < high && array[high] >= array[low];){
				high--;
			}
			exchange(array, low, high);
			// 从 low 向 high 找到第一个比 high 大的  交换
			for (;low < high && array[low] <= array[high];) {
				low++;
			}
			exchange(array, low, high);
		}
		return low;
	}

	private void exchange(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	/**
	 * 使用循环做的快排
	 * @param array
	 */
	public static void kuaipai_xunhuan(int[] array) {
		sort.kuaipai_xunhuan0(array, 0, array.length - 1);
	}
	
	private void kuaipai_xunhuan0(int[] array, int low, int high) {
		int[] task = new int[(log2(array.length) + 1) * 2];
		int position = 0;
		// TODO 使用栈存放任务信息  position指向 (low, high) 中的high
		// 压栈时  优先放入 任务量多的任务 (high - low 数量)
		

		int middle = kuaipai_partition(array, low, high);
		
	}
	
	private int log2(long a) {
		int log = 0;
		for(;a > 1; a = a >> 1) {
			log++;
		}
		return log;
	}
	
	
	
	public static void maopao(int[] array) {
		sort.maopao(array, 0, array.length - 1);
	}
	
	private void maopao(int[] array, int low, int high) {
		for (int i = low; i < high; i++) {
			for (int j = high; j > i; j--) {
				if (array[j] < array[j - 1]) {
					exchange(array, j , j - 1);
				}
			}
		}
	}
	
	
}
