package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/18111
// 마인크래프트

public class baekjoon18111 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 처음 블럭 개수

		int resultHeight = 0;
		int result = Integer.MAX_VALUE;

		int maxHeight = Integer.MIN_VALUE;
		int minHeight = Integer.MAX_VALUE;

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				maxHeight = Math.max(maxHeight, map[i][j]);
				minHeight = Math.min(minHeight, map[i][j]);
			}
		}

		for (int i = maxHeight; i >= minHeight; i--) {
			int time = 0;
			int remainBlock = B;
            for (int[] ints : map) {
                for (int anInt : ints) {
                    if (anInt < i) {
                        time += (i - anInt);
                        remainBlock -= (i - anInt);
                    } else if (anInt > i) {
                        time += 2 * (anInt - i);
						remainBlock += (anInt - i);
                    }
                }
            }
			if (remainBlock >= 0) {
				if (time < result) {
					result = time;
					resultHeight = i;
				}
			}

		}

		output.append(result + " " + resultHeight);


		output.flush();
		output.close();
		input.close();
	}
}