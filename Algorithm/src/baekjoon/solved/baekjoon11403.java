package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11403
// 경로 찾기

public class baekjoon11403 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(input.readLine()); //정점의 개수
		int[][] graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			Queue<Integer> queue = new LinkedList<>();
			int[] visit = new int[N];
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 1 && visit[j] == 0) {
					queue.add(j);
					visit[j] = 1;
					while (queue.isEmpty() == false) {
						int cur = queue.poll();

						for (int k = 0; k < N; k++) {
							if (graph[cur][k] == 1 && visit[k] == 0) {
								queue.add(k);
								visit[k] = 1;
								graph[i][k] = 1;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(graph[i][j] + " ");
			}
			output.append("\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}