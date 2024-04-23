package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1149
// RGB거리

public class baekjoon1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); // 집의 수
		int[][] cost = new int[N][3]; //빨강, 초록, 파랑으로 칠하는 비용

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); //빨강
			cost[i][1] = Integer.parseInt(st.nextToken()); //초록
			cost[i][2] = Integer.parseInt(st.nextToken()); //파랑
		}

		for (int i = 1; i < N; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + cost[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + cost[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + cost[i][2];
		}

		output.append(Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2])) + "");

		output.flush();
		output.close();
		input.close();
	}
}