package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11047
// 동전 0

public class baekjoon11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(st.nextToken()); //동전의 개수
		int K = Integer.parseInt(st.nextToken()); //가치의 합

		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(input.readLine());
		}

		int cnt = 0;
		int sum = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (K == sum) {
				break;
			}
			int tmpCnt = (K - sum) / coin[i];
			cnt += tmpCnt;
			sum += coin[i] * tmpCnt;
		}

		output.append(cnt + "");

		output.flush();
		output.close();
		input.close();
	}

}