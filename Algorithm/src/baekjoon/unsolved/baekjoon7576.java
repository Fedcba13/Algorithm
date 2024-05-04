package baekjoon.unsolved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7576
// 토마토

public class baekjoon7576 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int M = Integer.parseInt(st.nextToken()); //상자의 가로 칸의 수
		int N = Integer.parseInt(st.nextToken()); //상자의 세로 칸의 수

		int[][] tomato = new int[M][N];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++) {
				tomato[j][i] = Integer.parseInt(st.nextToken());
				if (tomato[j][i] == 1) {
					queue.add(new int[] {j, i, 1});
				}
			}
		}

		int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			for (int i = 0; i < move.length; i++) {
				int[] next = {cur[0] + move[i][0], cur[1] + move[i][1],  cur[2] + 1};

				if (0 <= next[0] && next[0] < M && 0 <= next[1] && next[1] < N && tomato[next[0]][next[1]] == 0) {
					queue.add(next);
					tomato[next[0]][next[1]] = next[2];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < M; i++) {
			if (max == -1) {
				break;
			}
			for (int j = 0; j < N; j++) {
				max = Math.max(max, tomato[i][j]);
				if (tomato[i][j] == 0) {
					max = -1;
					break;
				}
			}
		}

		if (max != -1) {
			max--;
		}

		output.append(max + "");

		output.flush();
		output.close();
		input.close();
	}
}