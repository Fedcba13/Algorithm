package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/1927
// 최소 힙

public class baekjoon1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input.readLine());

			if (num == 0) {
				if (queue.isEmpty()) {
					output.append("0\n");
				} else {
					output.append(queue.poll() + "\n");
				}
			} else {
				queue.add(num);
			}
		}

		output.flush();
		output.close();
		input.close();
	}
}