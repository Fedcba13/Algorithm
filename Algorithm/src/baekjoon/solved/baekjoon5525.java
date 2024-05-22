package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5525
// IOIOI

public class baekjoon5525 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		int answer = 0;

		String S = input.readLine();

		char before = ' ';
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (cnt == 0 && S.charAt(i) == 'O') {
				continue;
			}
			if (S.charAt(i) != before) {
				before = S.charAt(i);
				cnt++;
			} else {
				if (S.charAt(i) == 'I') {
					cnt = 1;
				} else {
					cnt = 0;
				}
			}
			if (cnt == 2 * N + 1) {
				answer++;
				cnt -= 2;
			}
		}

		output.append(answer + "");


		output.flush();
		output.close();
		input.close();
	}
}