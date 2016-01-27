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
	@Ignore
	public void test0() {
		for (int ii = 0; ii < 10; ii++) {
			int[] array = new int[1000];
			for (int i = 0; i < 1000; i++) {
				array[i] = i;
			}
			Sort.quickSortRecursive(array);
			Random random = new Random();
			int base = 1000;
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
				array[i] = a;
			}
			Sort.quickSortRecursive(array);
		}
	}
	
	@Test
	@Ignore
	public void test1() {
		long l = 0x4000000000000000L;
		long l2 = 4;
		System.out.println(log2(Long.MAX_VALUE));
		System.out.println(log2(l));
	}
	
	private int log2(long a) {
		int log = 0;
		for(;a > 1; a = a >> 1) {
			log++;
		}
		return log;
	}
	
}
