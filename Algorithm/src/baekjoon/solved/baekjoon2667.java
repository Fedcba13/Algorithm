package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/2667
// 단지번호붙이기

public class baekjoon2667 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(input.readLine()); //지도의 크기
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String mapInfo = input.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = mapInfo.charAt(j) - '0';
			}
		}

		ArrayList<Integer> cnt = new ArrayList<>();
		Queue<int[]> queue;
		int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int tempCnt = 1;
					queue = new LinkedList<>();
					queue.add(new int[] {i, j});
					map[i][j] = 0;

					while (queue.isEmpty() == false) {
						int[] cur = queue.poll();

						for (int k = 0; k < move.length; k++) {
							int[] next = {cur[0] + move[k][0], cur[1] + move[k][1]};

							if (0 <= next[0] && next[0] < N && 0 <= next[1] && next[1] < N && map[next[0]][next[1]] == 1) {
								tempCnt++;
								queue.add(next);
								map[next[0]][next[1]] = 0;
							}
						}
					}
					cnt.add(tempCnt);
				}
			}
		}

		Collections.sort(cnt);

		output.append(cnt.size() + "\n");
		for (int i = 0; i < cnt.size(); i++) {
			output.append(cnt.get(i) + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}