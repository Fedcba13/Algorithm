package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1932
// 정수 삼각형

public class baekjoon1932 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(input.readLine()); //삼각형의 크기

		int[][] triangle = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] sum = new int[n][n]; //누계
		sum[0][0] = triangle[0][0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					sum[i][j] = sum[i-1][j] + triangle[i][j];
				} else if (j == i) {
					sum[i][j] = sum[i-1][j-1] + triangle[i][j];
				} else {
					sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-1]) + triangle[i][j];
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, sum[n-1][i]);
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}