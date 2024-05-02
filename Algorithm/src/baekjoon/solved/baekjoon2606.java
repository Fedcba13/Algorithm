package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2606
// 바이러스

public class baekjoon2606 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int computerCnt = Integer.parseInt(input.readLine()); //컴퓨터의 수
		int connectCnt = Integer.parseInt(input.readLine()); //연결되어 있는 컴퓨터 쌍의 수

		int[][] connect = new int[computerCnt][computerCnt];
		int[] visit = new int[computerCnt];

		for (int i = 0; i < connectCnt; i++) {
			st = new StringTokenizer(input.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			connect[start][end] = 1;
			connect[end][start] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visit[0] = 1;
		int answer = 0;

		while (queue.isEmpty() == false) {
			int cur = queue.poll();

			for (int i = 0; i < computerCnt; i++) {
				if (connect[cur][i] == 1 && visit[i] == 0) {
					visit[i] = 1;
					queue.add(i);
					answer++;
				}
			}
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}