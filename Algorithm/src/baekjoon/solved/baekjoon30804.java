package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/30804
// 과일 탕후루

public class baekjoon30804 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int result = 0;

		int N = Integer.parseInt(input.readLine()); // 과일의 개수

		st = new StringTokenizer(input.readLine()); //꽂힌 과일

		int[] tanghuru = new int[N];
		HashMap<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < N; i++) {
			tanghuru[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = -1;

		while (true) {
			if (count.size() <= 2) {
				result = Math.max(result, right - left + 1);
				if (right == N - 1) {
					break;
				}
				right++;
				count.put(tanghuru[right], count.getOrDefault(tanghuru[right], 0) + 1);
			} else {
				count.put(tanghuru[left], count.get(tanghuru[left]) - 1);
				if (count.get(tanghuru[left]) == 0) {
					count.remove(tanghuru[left]);
				}
				left++;
			}
		}

		output.append(result +"");

		output.flush();
		output.close();
		input.close();
	}
}