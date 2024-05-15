package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11399
// ATM

public class baekjoon11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //사람의 수
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		st = new StringTokenizer(input.readLine());

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		int answer = 0;
		int tmp = 0;
		while (!pq.isEmpty()) {
			int num = pq.poll();
			answer += tmp + num;
			tmp += num;

		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}