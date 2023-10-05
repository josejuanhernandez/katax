package io.ulpgc;

import java.util.Iterator;

import static java.util.Arrays.stream;

public class Kata2 {

	public static void main(String[] args) {
		String x = "XOOOXXXXO";
		char[] chars = x.toCharArray();
		if (chars[0] == chars[3]) return true;
		int queutime = queutime(new int[]{2, 3, 10}, 2);
		System.out.println(queutime);
	}

	private static int queutime(int[] customers, int n) {
		return queueTime(iterator(customers), new int[n]);
	}

	private static int queueTime(Iterator<Integer> customers, int[] cash) {
		int time = 0;
		while (true) {
			cash = fillCash(customers, cash);
			if (getMin(cash) == Integer.MAX_VALUE) return time;
			time += getMin(cash);
			advance(cash);

		}
	}

	private static void advance(int[] cash) {
		int min = getMin(cash);
		for (int i = 0; i < cash.length; i++)
			if (cash[i] != 0) cash[i] -= min;
	}

	private static int[] fillCash(Iterator<Integer> customers, int[] cash) {
		for (int i = 0; i < cash.length; i++)
			if (cash[i] == 0) cash[i] = customers.next();
		return cash;
	}

	private static Iterator<Integer> iterator(int[] customers) {
		return new Iterator<Integer>() {
			int next = 0;
			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public Integer next() {
				return next >= customers.length ? 0 : customers[next++];
			}
		};
	}

	private static int getMin(int[] cash) {
		return stream(cash).filter(v->v>0).min().orElse(Integer.MAX_VALUE);
	}
}
