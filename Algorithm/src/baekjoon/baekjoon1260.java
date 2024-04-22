package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260
// DFS와 BFS

public class baekjoon1260 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

		int[][] graph = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = 1;
			graph[end][start] = 1;
		}

		int[] isVisit;

		//DFS
		isVisit = new int[N + 1];
		isVisit[V] = 1;
		output.append(dfs(V, graph, isVisit) + "\n");


		//BFS
		String str = "";
		isVisit = new int[N + 1];
		isVisit[V] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);

		while (queue.isEmpty() == false) {
			int curNode = queue.poll();
			str += curNode + " ";
			for (int i = 0; i < graph.length; i++) {
				if (graph[curNode][i] == 1 && isVisit[i] == 0) {
					isVisit[i] = 1;
					queue.add(i);
				}
			}
		}
		output.append(str);

		output.flush();
		output.close();
		input.close();
	}

	public static String dfs(int curNode, int[][] graph, int[] isVisit) {
		String str = curNode + " ";
		for (int i = 0; i < graph.length; i++) {
			if (graph[curNode][i] == 1 && isVisit[i] == 0) {
				isVisit[i] = 1;
				str += dfs(i, graph, isVisit);
			}
		}
		return str;
	}

}