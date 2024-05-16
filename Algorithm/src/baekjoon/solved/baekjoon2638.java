package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2638
// 치즈

public class baekjoon2638 {

	static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //모눈종이 세로
		int M = Integer.parseInt(st.nextToken()); //모눈종이 가로

		int time = 0;
		Queue<int[]> cheese = new LinkedList<>();
		Queue<int[]> nextCheese = new LinkedList<>();
		Queue<int[]> meltCheese = new LinkedList<>();
		Queue<int[]> air = new LinkedList<>();

		int[][] paper = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (paper[i][j] == 1) {
					cheese.add(new int[] {i, j});
				}
			}
		}

		for (int i = 0; i < N; i++) {
			air.add(new int[] {i, -1});
			air.add(new int[] {i, M});
		}

		for (int i = 0; i < M; i++) {
			air.add(new int[] {-1, i});
			air.add(new int[] {N, i});
		}

		while (!air.isEmpty()) {
			int[] cur = air.poll();

			for (int[] move : moves) {
				int[] next = new int[] {cur[0] + move[0], cur[1] + move[1]};

				if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < M && !visit[next[0]][next[1]]) {
					if (paper[next[0]][next[1]] == 0) {
						visit[next[0]][next[1]] = true;
						air.add(next);
					}
				}
			}
		}

		while (!cheese.isEmpty()) {
			time++;

			while (!cheese.isEmpty()) {
				int[] cur = cheese.poll();

				if (isMelt(paper, visit, cur)) {
					meltCheese.add(cur);
				} else {
					nextCheese.add(cur);
				}
			}

			while (!meltCheese.isEmpty()) {
				int[] cur = meltCheese.poll();

				air.add(cur);
				visit[cur[0]][cur[1]] = true;
			}

			while (!air.isEmpty()) {
				int[] cur = air.poll();

				for (int[] move : moves) {
					int[] next = new int[] {cur[0] + move[0], cur[1] + move[1]};

					if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < M && !visit[next[0]][next[1]]) {
						if (paper[next[0]][next[1]] == 0) {
							visit[next[0]][next[1]] = true;
							air.add(next);
						}
					}
				}
			}

			cheese = nextCheese;
			nextCheese = new LinkedList<>();

		}

		output.append(time + "");

		output.flush();
		output.close();
		input.close();
	}

	static boolean isMelt(int[][] paper, boolean[][] visit, int[] cur) {
		int cnt = 0;

		for (int[] move : moves) {
			int[] next = new int[] {cur[0] + move[0], cur[1] + move[1]};

			if (0 <= next[0] && next[0] < paper.length && 0 <= next[1] && next[1] < paper[0].length) {
				if (visit[next[0]][next[1]]) {
					cnt++;
				}
			} else {
				cnt++;
			}
		}

		if (cnt >= 2) {
			return true;
		} else {
			return false;
		}
	}

}