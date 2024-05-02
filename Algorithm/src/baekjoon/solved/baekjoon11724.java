package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11724
// 연결 요소의 개수

public class baekjoon11724 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수

		int[][] graph = new int[N][N];
		int[] visit = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());

			//간선의 양 끝점
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;

			graph[u][v] = 1;
			graph[v][u] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (visit[i] == 0) {
				answer++;
				queue.add(i);
				visit[i] = 1;

				while (queue.isEmpty() == false) {
					int cur = queue.poll();

					for (int j = 0; j < N; j++) {
						if (graph[cur][j] == 1 && visit[j] == 0) {
							queue.add(j);
							visit[j] = 1;
						}
					}
				}
			}
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}