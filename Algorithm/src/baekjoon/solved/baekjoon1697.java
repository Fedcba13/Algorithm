package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1697
// 숨바꼭질

public class baekjoon1697 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //수빈의 위치
		int K = Integer.parseInt(st.nextToken()); //동생이 있는 위치
		int[] visit = new int[200001];

		Queue<int[]> queue = new LinkedList<>(); // [위치, 시간]
		queue.add(new int[] {N, 1});
		visit[N] = 1;

		while (queue.isEmpty() == false) {
			int[] cur = queue.poll();

			if (cur[0] == K) {
				output.append((cur[1] - 1) + "");
				break;
			}

			int[][] next = new int[3][2];
			next[0] = new int[] {cur[0] + 1, cur[1] + 1};
			next[1] = new int[] {cur[0] * 2, cur[1] + 1};
			next[2] = new int[] {cur[0] - 1, cur[1] + 1};

			for (int i = 0; i < 3; i++) {
				if (next[i][0] >= 0 && next[i][0] <= 200000 && visit[next[i][0]] == 0) {
					visit[next[i][0]] = next[i][1];
					queue.add(next[i]);
				}
			}

		}

		output.flush();
		output.close();
		input.close();
	}
}