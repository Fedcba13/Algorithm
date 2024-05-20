package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16928
// 뱀과 사다리 게임

public class baekjoon16928 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //사다리의 수
		int M = Integer.parseInt(st.nextToken()); //뱀의 수

		HashMap<Integer, Integer> route = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());

			int x = Integer.parseInt(st.nextToken()); //사다리 시작 지점
			int y = Integer.parseInt(st.nextToken()); //사다리 끝 지점

			route.put(x, y);

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());

			int u = Integer.parseInt(st.nextToken()); //뱀 시작 지점
			int v = Integer.parseInt(st.nextToken()); //뱀 끝 지점

			route.put(u, v);
		}

		boolean[] visit = new boolean[107];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 0});

		int answer = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] >= 100) {
				answer = cur[1];
				break;
			}

			while (route.get(cur[0]) != null) {
				cur[0] = route.get(cur[0]);
			}

			if (visit[cur[0]]) {
				continue;
			}

			visit[cur[0]] = true;

			for (int i = 1; i <= 6; i++) {
				if (!visit[cur[0] + i]) {
					queue.add(new int[] {cur[0] + i, cur[1] + 1});
				}
			}
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}
}