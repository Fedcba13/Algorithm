package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2630
// 색종이 만들기

public class baekjoon2630 {

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int blue = 0;
		int white = 0;

		int N = Integer.parseInt(input.readLine()); //한변의 길이
		int[][] paper = new int[N][N];

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {0, 0, N-1, N-1});

		while (stack.isEmpty() == false) {
			boolean isOK = true;
			int[] cur = stack.pop();
			int first = paper[cur[0]][cur[1]];

			for (int i = cur[0]; i <= cur[2]; i++) {
				if (isOK == false) {
					break;
				}
				for (int j = cur[1]; j <= cur[3]; j++) {
					if (first != paper[i][j]) {
						isOK = false;
						break;
					}
				}
			}

			if (isOK == true) {
				if (first == 0) {
					white++;
				} else {
					blue++;
				}
			} else {
				//0 0 7 7
				//0 0 3 3
				//0 4 3 7
				//4 0 7 3
				//4 4 7 7

				//4 4 7 7
				//4 4 5 5
				//4 6 5 7
				//6 4 7 5
				//6 6 7 7
				stack.add(new int[] {cur[0], cur[1], (cur[0] + cur[2]) / 2, (cur[1] + cur[3]) / 2});
				stack.add(new int[] {cur[0], (cur[1] + cur[3]) / 2 + 1, (cur[0] + cur[2]) / 2, cur[3]});
				stack.add(new int[] {(cur[0] + cur[2]) / 2 + 1, cur[1], cur[2], (cur[1] + cur[3]) / 2});
				stack.add(new int[] {(cur[0] + cur[2]) / 2 + 1, (cur[1] + cur[3]) / 2 + 1, cur[2], cur[3]});
			}

		}

		output.append(white + "\n" + blue);

		output.flush();
		output.close();
		input.close();
	}

}