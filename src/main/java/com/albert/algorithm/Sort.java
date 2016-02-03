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
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			// 从 low 向 high 找到第一个比 high 大的  交换
			for (;low < high && array[low] <= array[high];) {
				low++;
			}
			temp = array[low];
			array[low] = array[high];
			array[high] = temp;
		}
		return low;
	}

	private int quickSortPartition0(int[] array, int low, int high) {
		for(;low < high;) {
			// 从high向low找到第一个比low小的数 交换
			for (;low < high && array[high] >= array[low];){
				high--;
			}
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			// 从 low 向 high 找到第一个比 high 大的  交换
			for (;low < high && array[low] <= array[high];) {
				low++;
			}
			temp = array[low];
			array[low] = array[high];
			array[high] = temp;
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
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void insertSort(int[] array) {
		sort.insertSort0(array, 0, array.length - 1);
	}
	
	private void insertSort0(int[] array, int left, int right) {
		/*
		 	1 2 3 4 5 6 7 8 9     2   3   4   3   2
		 	-----------           ---------   - 
		 	already sort    point tag         i 
		 
		 */
		int tag = left;
		int point = left;
		
		for (int i = left; i < right;) {
			tag = i;
			point = left;
			/*
			 * 循环结束时  i 的位置在point处
			 */
			if (array[i] <= array[i + 1]) {
				while (++i < right && array[i - 1] <= array[i]);
			} else if (array[i] > array[i + 1]) {
				while (++i < right && array[i - 1] > array[i]);
				for (int lo = tag, ri = i - 1; lo < ri;) {
					int temp = array[lo];
					array[lo] = array[ri];
					array[ri] = temp;
					lo++;
					ri--;
					
				}
			}
			if (tag != left && array[tag] < array[tag - 1]) {
				for (; tag < i; tag++) {
					int t = array[tag];
					// 找到第一个比t大的下标
					for(; point < tag && array[point] < t; point++);
//					point = point;
					// [bigger ~ tag-1] 整套右移一位
					for (int tag1 = tag; tag1 > point; tag1--) {
						array[tag1] = array[tag1 - 1];
					}
					array[point] = t;
				}
			}
		}
		point = left;
		// 处理最右边的字符  right
		int t = array[right];
		// 找到第一个比t大的下标
		for(; point < right && array[point] < t; point++);
//		point = point;
		// [bigger ~ tag-1] 整套右移一位
		for (int tag1 = right; tag1 > point; tag1--) {
			array[tag1] = array[tag1 - 1];
		}
		array[point] = t;

	}

	public static void shellSort(int[] array) {
		sort.shellSort(array, 0, array.length - 1);
	}
	
	private void shellSort(int[] array, int left, int right) {
		
	}

	public static void mergeSort(int[] array) {
		sort.mergeSort0(array);
	}

	private void mergeSort0(int[] array) {
		int[] buffer = new int[8];
		int bufLen = 0;
		int piece = 2;
		int len = array.length;
		int temp;
		/*
		 * 初始化 先处理相邻2位
		 * 双数长度
		 * 	2 1 5 4 -> 1 2 4 5
		 * 单数长度与前面一组合并   
		 *  2 1 5 4 3 -> 1 2 4 5 3 -> 1 2 3 4 5
		*/
		for (int i = 1; i < len; i += 2) {
			if (array[i] < array[i - 1]) {
				temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
			}
		}
		temp = array[len - 1];
		if (temp < array[len - 2]) {
			array[len - 1] = array[len - 2];
			if (temp < array[len - 3]) {
				array[len - 2] = array[len - 3];
				array[len - 3] = temp;
			} else {
				array[len - 2] = temp;
			}
		}

		// 开始分片处理
		for (; piece < array.length; piece <<= 2) {
			for (int i = 0, max = (array.length / piece); i < max; i++) {
				/*
				piece = 4:
				1     2     3     4     5  6  7  8  9  10  11  12  13
				-------------------     ----------  -------------  
				start       tag         end
				
				*/
				int start = i;
				int tag = i + piece >> 1;
				int end = i + piece;
				// 当前片中排序
				bufLen = 0;
				
				
				
			}
			// TODO 收尾
			
		}
	}
	
}
