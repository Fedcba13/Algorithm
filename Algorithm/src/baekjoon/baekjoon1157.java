package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1157
// 단어 공부

public class baekjoon1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = input.readLine().toUpperCase();

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		PriorityQueue<Object[]> pq = new PriorityQueue<>(new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return (int) o2[1] - (int) o1[1];
			}
		});

		for (Character key : map.keySet()) {
			pq.add(new Object[] {key, map.get(key)});
		}

		Object[] first = pq.poll();
		Object[] second = pq.poll();

		if (first == null) {
			output.append("?");
		} else if (second == null || !first[1].equals(second[1])) {
			output.append(first[0] + "");
		} else {
			output.append("?");
		}

		output.flush();
		output.close();
		input.close();
	}
}