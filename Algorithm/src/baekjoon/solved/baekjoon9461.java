package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9461
// 파도반 수열

public class baekjoon9461 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(input.readLine()); //테스트 케이스의 개수

		long[] arr = new long[101];
		arr[1] = 1; arr[2] = 1; arr[3] = 1;

		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(input.readLine());

			output.append(arr[N] + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}