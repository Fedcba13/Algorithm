package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/1753
// 최단경로

public class baekjoon1753 {

	final static int INF = 9999999;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수

		int K = Integer.parseInt(input.readLine()) - 1; //시작 정점

		HashMap<Integer, HashMap<Integer, Integer>> route = new HashMap<>();

		for (int i = 0; i < V; i++) {
			route.put(i, new HashMap<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(input.readLine());

			int u = Integer.parseInt(st.nextToken()) - 1; //시작 정점
			int v = Integer.parseInt(st.nextToken()) - 1; //끝 정점
			int w = Integer.parseInt(st.nextToken()); //가중치

			if (w < route.get(u).getOrDefault(v, INF)) {
				route.get(u).put(v, w);
			}
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		queue.add(new int[] {K, 0});

		int[] dist = new int[V];
		boolean[] visit = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (i != K) {
				dist[i] = INF;
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (visit[cur[0]]) {
				continue;
			}

			visit[cur[0]] = true;

			for (Integer key : route.get(cur[0]).keySet()) {
				int tmp = route.get(cur[0]).get(key);
				if (cur[1] + tmp < dist[key]) {
					dist[key] = cur[1] + tmp;
					queue.add(new int[] {key, cur[1] + tmp});
				}
			}
		}

		for (int i = 0; i < V; i++) {
			if (dist[i] == INF) {
				output.append("INF\n");
			} else {
				output.append(dist[i] + "\n");
			}
		}

		output.flush();
		output.close();
		input.close();
	}
}