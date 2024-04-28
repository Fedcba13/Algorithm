package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/6064
// 카잉 달력

public class baekjoon6064 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(input.readLine()); //테스트 케이스의 수

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			HashSet<String> visit = new HashSet<>();

			int k = x;
			int tmpx = 0;
			int tmpy = 0;
			while (true) {
				tmpx = k % M == 0 ? M : k%M;
				tmpy = k % N == 0 ? N : k%N;
				if (x == tmpx && y == tmpy) {
					break;
				} else {
					String cur = tmpx + "," + tmpy;
					if (visit.contains(cur)) {
						k = -1;
						break;
					} else {
						visit.add(cur);
					}
					k += M;
				}
			}

			output.append(k + "\n");

		}


		output.flush();
		output.close();
		input.close();
	}
}