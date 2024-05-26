package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16953
// A → B

public class baekjoon16953 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		HashSet<Long> visit = new HashSet<>();

		Queue<long[]> queue = new LinkedList<>();

		queue.add(new long[] {A, 1});
		visit.add(A);
		long cnt = -1;

		while (!queue.isEmpty()) {
			long[] cur = queue.poll();

			if (cur[0] == B) {
				cnt = cur[1];
				break;
			}

			long[] next = new long[] {cur[0] * 2, cur[1] + 1};
			if (!visit.contains(next[0]) && next[0] <= B) {
				visit.add(next[0]);
				queue.add(next);
			}

			next = new long[] {cur[0] * 10 + 1, cur[1] + 1};
			if (!visit.contains(next[0]) && next[0] <= B) {
				visit.add(next[0]);
				queue.add(next);
			}

		}

		output.append(cnt + "");

		output.flush();
		output.close();
		input.close();
	}
}