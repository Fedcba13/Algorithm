package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2346
// 풍선 터뜨리기

public class baekjoon2346 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //풍선의 개수

		st = new StringTokenizer(input.readLine());

		Deque<int[]> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			deque.add(new int[] {Integer.parseInt(st.nextToken()), i + 1});
		}

		while (true) {
			int cur[] = deque.pollFirst();

			output.append(cur[1] + " ");

			if (deque.isEmpty()) {
				break;
			}

			if (cur[0] > 0) {
				cur[0]--;
				for (int i = 0; i < cur[0]; i++) {
					deque.addLast(deque.pollFirst());
				}
			} else {
				for (int i = 0; i > cur[0]; i--) {
					deque.addFirst(deque.pollLast());
				}
			}
		}

		output.flush();
		output.close();
		input.close();
	}
}