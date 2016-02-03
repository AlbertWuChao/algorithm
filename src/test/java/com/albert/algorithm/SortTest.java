package com.albert.algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class SortTest {
	
	@Test
	public void testQuickSortRecursive() {
		int base = 10000000;
		int[] array = new int[base];
//		int[] array2 = new int[base * 2];
		for (int ii = 0; ii < 10; ii++) {
			Random random = new Random();
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
				array[i] = a;
			}
//			System.out.println(Arrays.toString(array));
			long t1 = System.currentTimeMillis();
			Sort.quickSortRecursive(array);
			System.out.println("kuaipai_digui:[" + base + "] " + (System.currentTimeMillis() - t1));
	//		System.out.println(Arrays.toString(array));
		}
	}
	
	@Test
	@Ignore
	public void testBubbleSort() {
		Random random = new Random();
		int base = 10000;
		int[] array = new int[base];
		for(int i = 0; i < base; i++) {
			int a = random.nextInt(2 * base);
			array[i] = a;
		}
//		System.out.println(Arrays.toString(array));
		long t1 = System.currentTimeMillis();
		Sort.bubbleSort(array);
		System.out.println("maopao:[" + base + "]" + (System.currentTimeMillis() - t1));
//		System.out.println(Arrays.toString(array));
	}
	
	@Test
	public void testQuickSortLoop() {
		int base = 10000000;
		int[] array = new int[base];
//		int[] array2 = new int[base * 2];
		for (int ii = 0; ii < 10; ii++) {
			Random random = new Random();
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
//				array[i] = a;
				array[i] = base - i;
			}
			array[3000000] = 1001;
			array[5000000] = 1002;
			array[7000000] = 1003;
			array[9000000] = 1004;
//			System.out.println(Arrays.toString(array));
			long t1 = System.currentTimeMillis();
			Sort.quickSortLoop(array);
//			DualPivotQuicksort.sort(array);
			System.out.println("kuaipai_xunhuan:[" + base + "] " + (System.currentTimeMillis() - t1));
	//		System.out.println(Arrays.toString(array));
		}
	}
	
	
	@Test
	public void testInsertSort() {
		int base = 5;
		int[] array = new int[base];
		for (int ii = 0; ii < 10000; ii++) {
			Random random = new Random();
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
				array[i] = a;
			}
			int[] array2 = new int[base];
			System.arraycopy(array, 0, array2, 0, base);
//			System.out.println(Arrays.toString(array));
			long t1 = System.currentTimeMillis();
			Sort.insertSort(array);
			long t2 = System.currentTimeMillis();
//			System.out.println(Arrays.toString(array));
//			System.out.println("Sort insert:[" + base + "] " + (t2 - t1) + " Sorted: " + checkSorted(array));
			if (!checkSorted(array)) {
				System.out.println("Source: " + Arrays.toString(array2));
				System.out.println("Target: " + Arrays.toString(array));
			}
		}
	}
	
	
	@Test
//	@Ignore
	public void test0() {
		int base = 3000;
		int[] array = new int[base];
		for(int i = 0; i < base; i++) {
			array[i] = i % 30;
		}
		System.out.println(Arrays.toString(array));
		long t1 = System.currentTimeMillis();
		DualPivotQuicksort.sort(array);
		System.out.println("kuaipai_xunhuan:[" + base + "] " + (System.currentTimeMillis() - t1));
		System.out.println(Arrays.toString(array));
	}
	
	@Test
//	@Ignore
	public void test1() {
		long t1 = System.currentTimeMillis();
		for (long i = 0; i++ < 10000000000L;) {
			int ii = Integer.MAX_VALUE / 7;
		}
		System.out.println(System.currentTimeMillis() - t1);
		t1 = System.currentTimeMillis();
		for (long i = 0; i++ < 10000000000L;) {
			int ii = Integer.MAX_VALUE >> 3 + Integer.MAX_VALUE >> 6 + 1;
		}
		System.out.println(System.currentTimeMillis() - t1);

	}
	
	private int log2(long a) {
		int log = 0;
		for(;a > 1; a = a >> 1) {
			log++;
		}
		return log;
	}
	
	private boolean checkSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	
}
