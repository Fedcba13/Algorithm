package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1003
// 피보나치 함수

public class baekjoon1003 {

	static int[][] call = new int[2][41];

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(input.readLine());

		call[0][0] = 1;
		call[1][0] = 0;

		call[0][1] = 0;
		call[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			call[0][i] = call[0][i-2] + call[0][i-1];
			call[1][i] = call[1][i-2] + call[1][i-1];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(input.readLine());

			output.append(call[0][N] + " " + call[1][N] + "\n");

		}


		output.flush();
		output.close();
		input.close();
	}
}