package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14500
// 테트로미노

public class baekjoon14500 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][][] figure = {
				{{0, 0}, {0, 1}, {0,  2},  {0,  3}},
				{{0, 0}, {1, 0}, {2,  0},  {3,  0}},

				{{0, 0}, {1, 0}, {0,  1},  {1,  1}},

				{{0, 0}, {0, 1}, {0,  2},  {1,  1}},
				{{0, 0}, {0, 1}, {0,  2},  {-1, 1}},
				{{0, 0}, {1, 0}, {1,  1},  {2,  0}},
				{{0, 0}, {1, 0}, {1,  -1}, {2,  0}},

				{{0, 0}, {1, 0}, {1,  1},  {2,  1}},
				{{0, 0}, {1, 0}, {1,  -1}, {2,  -1}},
				{{0, 0}, {0, 1}, {-1, 1},  {-1, 2}},
				{{0, 0}, {0, 1}, {1,  1},  {1,  2}},

				{{0, 0}, {1, 0}, {1,  1},  {1,  2}},
				{{0, 0}, {0, 1}, {0,  2},  {-1, 2}},
				{{0, 0}, {1, 0}, {0,  1},  {0,  2}},
				{{0, 0}, {0, 1}, {0,  2},  {1,  2}},
				{{0, 0}, {1, 0}, {2,  0},  {2,  1}},
				{{0, 0}, {1, 0}, {2,  0},  {2,  -1}},
				{{0, 0}, {1, 0}, {2,  0},  {0,  1}},
				{{0, 0}, {1, 0}, {2,  0},  {0,  -1}},
		};

		StringTokenizer st = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(st.nextToken()); //세로 크기
		int M = Integer.parseInt(st.nextToken()); //가로 크기

		int[][] paper = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < figure.length; k++) {
					int answer = 0;
					for (int l = 0; l < figure[0].length; l++) {
						int[] next = new int[] {i + figure[k][l][0], j + figure[k][l][1]};

						if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < M) {
							answer += paper[next[0]][next[1]];
						} else {
							break;
						}
					}
					max = Math.max(max, answer);
				}
			}
		}

		output.append(max  + "\n");

		output.flush();
		output.close();
		input.close();
	}
}