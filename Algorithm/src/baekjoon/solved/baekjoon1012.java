package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012
// 유기농 배추

public class baekjoon1012 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(input.readLine()); //테스트 케이스의 개수

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(input.readLine());
			int M = Integer.parseInt(st.nextToken()); //배추밭 가로길이
			int N = Integer.parseInt(st.nextToken()); //배추밭 세로길이
			int K = Integer.parseInt(st.nextToken()); //배추의 개수
			int answer = 0; //배추흰지렁이 수
			int[][] field = new int[M][N];
			int[][] move = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			Queue<int[]> baechu = new LinkedList<>();

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(input.readLine());
				field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (field[j][k] == 1) { //배추가 심어져 있는 경우
						baechu.add(new int[] {j, k});
						field[j][k] = 0;
						answer++;
						while (baechu.isEmpty() == false) {
							int[] xy = baechu.poll();

							for (int l = 0; l < move.length; l++) {
								int[] newxy = new int[] {xy[0] + move[l][0], xy[1] + move[l][1]};

								if (newxy[0] >= 0 && newxy[0] < M && newxy[1] >= 0 && newxy[1] < N
										&& field[newxy[0]][newxy[1]] == 1) {
									baechu.add(newxy);
									field[newxy[0]][newxy[1]] = 0;
								}
							}
						}
					}
				}
			}
			output.append(answer + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}