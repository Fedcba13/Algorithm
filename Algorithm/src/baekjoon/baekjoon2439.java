package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2439
// 별 찍기 - 2

public class baekjoon2439 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i-1; j++) {
				output.append(" ");
			}
			for (int j = N-i-1; j < N; j++) {
				output.append("*");
			}
			output.append("\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}