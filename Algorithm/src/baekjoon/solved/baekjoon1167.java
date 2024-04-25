package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

// https://www.acmicpc.net/problem/1167
// 트리의 지름

public class baekjoon1167 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		final int MAX_VALUE = 10000*100000;

		int V = Integer.parseInt(input.readLine()); //정점의 개수

		HashMap<Integer, HashMap<Integer, Integer>> route = new HashMap<>();

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(input.readLine());

			int start = Integer.parseInt(st.nextToken());
			route.put(start, new HashMap<>());

			while (true) {
				int end = Integer.parseInt(st.nextToken());
				if (end == -1) {
					break;
				}

				int dist = Integer.parseInt(st.nextToken());
				route.get(start).put(end, dist);
			}
		}

		int max = 0;
		int prevMax = -1;
		int start = 1;

		while (prevMax != max) {
			prevMax = max;
			max = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			int[] visit = new int[V+1];
			for (int i = 0; i < visit.length; i++) {
				visit[i] = -1;
			}
			visit[start] = 0;

			while (queue.isEmpty() == false) {
				int cur = queue.poll();

				for (Integer end : route.get(cur).keySet()) {
					if (visit[end] == -1) {
						queue.add(end);
						visit[end] = visit[cur] + route.get(cur).get(end);
						if (visit[end] > max) {
							max = visit[end];
							start = end;
						}
					}
				}
			}
		}

		output.append(max + "");

		output.flush();
		output.close();
		input.close();
	}
}