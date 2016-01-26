package com.albert.algorithm;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class SortTest {
	
	@Test
	public void testKuaipai_digui() {
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
			Sort.kuaipai_digui(array);
			System.out.println("kuaipai_digui:[" + base + "] " + (System.currentTimeMillis() - t1));
	//		System.out.println(Arrays.toString(array));
		}
	}
	
	@Test
	public void testMaopao() {
		Random random = new Random();
		int base = 10000;
		int[] array = new int[base];
		for(int i = 0; i < base; i++) {
			int a = random.nextInt(2 * base);
			array[i] = a;
		}
//		System.out.println(Arrays.toString(array));
		long t1 = System.currentTimeMillis();
		Sort.maopao(array);
		System.out.println("maopao:[" + base + "]" + (System.currentTimeMillis() - t1));
//		System.out.println(Arrays.toString(array));
	}
	
	@Test
	public void test0() {
		for (int ii = 0; ii < 10; ii++) {
			int[] array = new int[1000];
			for (int i = 0; i < 1000; i++) {
				array[i] = i;
			}
			Sort.kuaipai_digui(array);
			Random random = new Random();
			int base = 1000;
			for(int i = 0; i < base; i++) {
				int a = random.nextInt(2 * base);
				array[i] = a;
			}
			Sort.kuaipai_digui(array);
		}
	}
	
	@Test
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
