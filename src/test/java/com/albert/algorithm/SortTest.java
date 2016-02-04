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
		for (int ii = 0; ii < 1000; ii++) {
			Random random = new Random();
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
				array[i] = a;
			}
//			System.out.println(Arrays.toString(array));
			long t1 = System.currentTimeMillis();
			Sort.quickSortLoop(array);
//			DualPivotQuicksort.sort(array);
			System.out.println("QuickSortLoop:[" + base + "] " + (System.currentTimeMillis() - t1));
	//		System.out.println(Arrays.toString(array));
		}
	}
	
	
	@Test
	public void testInsertSort() {
		int base = 100000;
		int[] array = new int[base];
		for (int ii = 0; ii < 100; ii++) {
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
			System.out.println("Sort insert:[" + base + "] " + (t2 - t1));
//			System.out.println(Arrays.toString(array));
//			System.out.println("Sort insert:[" + base + "] " + (t2 - t1) + " Sorted: " + checkSorted(array));
//			if (!checkSorted(array)) {
//				System.out.println("Source: " + Arrays.toString(array2));
//				System.out.println("Target: " + Arrays.toString(array));
//			}
		}
	}
	
	@Test
	public void testMergeSort() {
		int base = 10000000;
		int[] array = new int[base];
		int[] buf = new int[1024 * 1024];
		int[] buf2 = new int[1024 * 1024];
		for (int ii = 0; ii < 1000; ii++) {
			Random random = new Random();
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
				array[i] = a;
			}
//			int[] array2 = new int[base];
//			System.arraycopy(array, 0, array2, 0, base);
//			System.out.println(Arrays.toString(array));
			long t1 = System.currentTimeMillis();
			Sort.mergeSort(array, buf);
			long t2 = System.currentTimeMillis();
//			System.out.println(Arrays.toString(array));
			System.out.println("Sort merge:[" + base + "] " + (t2 - t1));
//			boolean isOK = checkSorted(array);
//			System.out.println("Sort merge:[" + base + "] " + (t2 - t1) + " Sorted: " + isOK);
//			if (!isOK) {
//				System.out.println("Source: " + Arrays.toString(array2));
//				System.out.println("Target: " + Arrays.toString(array));
//			}
		}
	}
	
	@Test
//	@Ignore
	public void test0() {
		int base = 101;
		int[] array = new int[base];
		for (int ii = 0; ii < 1; ii++) {
//			Random random = new Random();
			for(int i = 0; i < base; i++) {
//				int a = random.nextInt(2 * base);
				array[i] = base - i;
			}
			int[] array2 = new int[base];
			System.arraycopy(array, 0, array2, 0, base);
			System.out.println(Arrays.toString(array));
			long t1 = System.currentTimeMillis();
			Sort.mergeSort(array);
			long t2 = System.currentTimeMillis();
			System.out.println(Arrays.toString(array));
			boolean isOK = checkSorted(array);
			System.out.println("Sort merge:[" + base + "] " + (t2 - t1) + " Sorted: " + isOK);
			if (!isOK) {
				System.out.println("Source: " + Arrays.toString(array2));
				System.out.println("Target: " + Arrays.toString(array));
			}
		}
	}
	
	@Test
//	@Ignore
	public void test1() {
		System.out.println(log2(1000000));
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
