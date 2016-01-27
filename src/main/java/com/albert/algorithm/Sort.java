package com.albert.algorithm;

public class Sort {

	public static Sort sort = new Sort();
	
	/**
	 * 递归快排
	 */
	public static void quickSortRecursive(int[] array) {
		ttt = 0;
		sort.quickSortRecursive(array, 0, array.length - 1);
		System.out.println(ttt);
	}
	
	static int ttt = 0;
	
	private void quickSortRecursive(int[] array, int low, int high) {
		int middle = quickSortPartition(array, low, high);
		if (middle - 1 > low) {
			if (middle - 1 - low < 7) {
				bubbleSort(array, low, middle - 1);
			} else {
				quickSortRecursive(array, low, middle - 1);
			}
		}
		if (middle + 1 < high) {
			if (high - 1 - middle < 7) {
				bubbleSort(array, middle + 1, high);
			} else {
				quickSortRecursive(array, middle + 1, high);
			}
		}
	}
	
	private int quickSortPartition(int[] array, int low, int high) {
		ttt++;
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
	public static void quickSortLoop(int[] array) {
		ttt = 0;
		sort.quickSortLoop0(array, 0, array.length - 1);
		System.out.println(ttt);
	}
	
	private void quickSortLoop0(int[] array, int low, int high) {
		int[] task = new int[(log2(array.length) + 1) * 2 + 2];
		// TODO 使用栈存放任务信息  position指向 (low, high) 中的high
		// 压栈时  优先放入 任务量多的任务 (high - low 数量)
		task[0] = low;
		task[1] = high;
		int position = 1;
		int middle = 0;
		for (;position > 0;) {
			low = task[position - 1];
			high = task[position];
			position -= 2;
			// 如果元素数量大于7 则使用快排
			// 元素数量7个以内 则使用冒泡
			if (high - low > 7) {
				middle = quickSortPartition(array, low, high);
				if ((middle - low) >= (high - middle)) {
//					task[position + 1] = low;
					task[position + 2] = middle - 1;
					task[position + 3] = middle + 1;
					task[position + 4] = high;
				} else {
					task[position + 1] = middle + 1;
//					task[position + 2] = high;
					task[position + 3] = low;
					task[position + 4] = middle - 1;
				}
				position += 4;
			} else {
				bubbleSort(array, low, high);
			}
		}

		
	}
	
	private int log2(long a) {
		int log = 0;
		for(;a > 1; a = a >> 1) {
			log++;
		}
		return log;
	}
	
	
	
	public static void bubbleSort(int[] array) {
		sort.bubbleSort(array, 0, array.length - 1);
	}
	
	private void bubbleSort(int[] array, int low, int high) {
		for (int i = low; i < high; i++) {
			for (int j = high; j > i; j--) {
				if (array[j] < array[j - 1]) {
					exchange(array, j , j - 1);
				}
			}
		}
	}
	
	
}
