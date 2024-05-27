package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/15686
// 치킨 배달

public class baekjoon15686 {

	final static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int answer = Integer.MAX_VALUE;

	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(input.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시의 크기
		M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨 집 수
		map = new int[N][N];

		ArrayList<int[]> chickens = new ArrayList<>();
		ArrayList<int[]> homes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					chickens.add(new int[] {i, j, 0});
				} else if (map[i][j] == 1) {
					homes.add(new int[] {i, j});
				}
			}
		}

		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < chickens.size(); i++) {
			visited.add(i);
			dfs(chickens, homes, visited, i, 1);
			visited.remove(i);
		}

		output.append(answer + "");

		output.flush();
		output.close();
		input.close();
	}

	static void dfs(ArrayList<int[]> chickens, ArrayList<int[]> homes, HashSet<Integer> visited, int index, int cnt) {
		if (M == cnt) {
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];
			for (int cur : visited) {
				int[] curChicken = chickens.get(cur);
				queue.add(curChicken);
				visit[curChicken[0]][curChicken[1]] = true;
			}
			answer = Math.min(answer, dist(visit, queue, homes));
			return;
		}

		for (int i = index + 1; i < chickens.size(); i++) {
			visited.add(i);
			dfs(chickens, homes, visited, i, cnt + 1);
			visited.remove(i);
		}

	}

	static int dist(boolean[][] visited, Queue<int[]> queue, ArrayList<int[]> homes) {
		int result = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (map[cur[0]][cur[1]] == 1) {
				result += cur[2];
			}

			for (int[] move : moves) {
				int[] next = new int[] {cur[0] + move[0], cur[1] + move[1], cur[2] + 1};

				if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < N && !visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					queue.add(next);
				}
			}

		}

		return result;
	}

}