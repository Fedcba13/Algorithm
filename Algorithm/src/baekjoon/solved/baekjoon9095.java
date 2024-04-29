package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9095
// 1, 2, 3 더하기

public class baekjoon9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(input.readLine());

		int[] sum = new int[12];
		sum[1] = 1;
		sum[2] = 1 + sum[1];
		sum[3] = 1 + sum[1] + sum[2];
		for (int i = 4; i <= 11; i++) {
			sum[i] += sum[i-3]; //+3
			sum[i] += sum[i-2]; //+2
			sum[i] += sum[i-1]; //+1
		}
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(input.readLine());

			output.append(sum[n] + "\n");

		}

		output.flush();
		output.close();
		input.close();
	}
}