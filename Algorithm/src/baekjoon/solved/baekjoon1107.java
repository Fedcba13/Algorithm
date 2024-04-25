package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1107
// 리모컨

public class baekjoon1107 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //이동하려는 채널
		int M = Integer.parseInt(input.readLine()); //고장난 버튼의 개수
		boolean[] isBroken = new boolean[10];

		int answer = Math.abs(N - 100);

		if (M != 0) { //고장난 버튼이 있는 경우
			st = new StringTokenizer(input.readLine());
			for (int i = 0; i < M; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		for (int i=0; i<=1000000; i++) {
			boolean isOK = true;
			for (int j = 0; j < (i + "").length(); j++) {
				if (isBroken[(i+"").charAt(j) - '0'] == true) {
					isOK = false;
					break;
				}
			}

			if (isOK == true) {
				int tmp = Math.abs(i - N) + (i+"").length();
				if (answer > tmp) {
					answer = tmp;
				}
			}
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}