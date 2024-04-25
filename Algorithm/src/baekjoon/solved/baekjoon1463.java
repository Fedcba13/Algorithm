package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1463
// 1로 만들기

public class baekjoon1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(input.readLine());

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {X, 0});

		while(queue.isEmpty() == false) {
			int[] cur = queue.poll();

			if (cur[0] == 1) {
				output.append(cur[1] + "");
				break;
			}

			if (cur[0] % 3 == 0) {
				queue.add(new int[] {cur[0] / 3, cur[1] + 1});
			}
			if (cur[0] % 2 == 0) {
				queue.add(new int[] {cur[0] / 2, cur[1] + 1});
			}
			queue.add(new int[] {cur[0] - 1, cur[1] + 1});
		}

		output.flush();
		output.close();
		input.close();
	}
}