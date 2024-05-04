package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569
// 토마토

public class baekjoon7569 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int M = Integer.parseInt(st.nextToken()); //상자의 가로 칸의 수
		int N = Integer.parseInt(st.nextToken()); //상자의 세로 칸의 수
		int H = Integer.parseInt(st.nextToken()); //상자의 수

		int[][][] tomato = new int[H][M][N];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(input.readLine());
				for (int k = 0; k < M; k++) {
					tomato[i][k][j] = Integer.parseInt(st.nextToken());
					if (tomato[i][k][j] == 1) {
						queue.add(new int[] {i, k, j, 1});
					}
				}
			}
		}

		int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			for (int i = 0; i < move.length; i++) {
				int[] next = {cur[0] + move[i][0], cur[1] + move[i][1], cur[2] + move[i][2], cur[3] + 1};

				if (0 <= next[0] && next[0] < H && 0 <= next[1] && next[1] < M && 0 <= next[2] && next[2] < N
						&& tomato[next[0]][next[1]][next[2]] == 0) {
					queue.add(next);
					tomato[next[0]][next[1]][next[2]] = next[3];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < H; i++) {
			if (max == -1) {
				break;
			}
			for (int j = 0; j < M; j++) {
				if (max == -1) {
					break;
				}
				for (int k = 0; k < N; k++) {
					max = Math.max(max, tomato[i][j][k]);
					if (tomato[i][j][k] == 0) {
						max = -1;
						break;
					}
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