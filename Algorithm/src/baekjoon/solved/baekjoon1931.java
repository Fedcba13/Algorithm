package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1931
// 회의실 배정

public class baekjoon1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //회의의 수

		int[][] scedule = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			scedule[i] = new int[] {start, end};
		}

		Arrays.sort(scedule, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int result = o1[1] - o2[1];
				if (result == 0) {
					result = o1[0] - o2[0];
				}
				return result;
			}
		});

		int answer = 0;
		int cur = 0;
		for (int i = 0; i < scedule.length; i++) {
			if (scedule[i][0] >= cur) {
				cur = scedule[i][1];
				answer++;
			}
		}

		output.append(answer + "\n");

		output.flush();
		output.close();
		input.close();
	}
}