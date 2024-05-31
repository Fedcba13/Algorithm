package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1270
// 전쟁 - 땅따먹기

public class baekjoon1270 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(input.readLine()); //땅의 개수

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(input.readLine());

			HashMap<Long, Integer> army = new HashMap<>();
			
			int Ti = Integer.parseInt(st.nextToken()); //i번째 땅의 병사수
			
			for (int j = 0; j < Ti; j++) {
				Long Nij = Long.parseLong(st.nextToken()); //i번째 땅의 병사 번호
				army.put(Nij, army.getOrDefault(Nij, 0) + 1);
			}

			long maxArmy = 0;
			int maxArmyCnt = 0;
			int totArmyCnt = 0;

			for (Long key : army.keySet()) {
				int curCnt = army.get(key);
				if (maxArmyCnt < curCnt) {
					maxArmyCnt = curCnt;
					maxArmy = key;
				}
				totArmyCnt += curCnt;
			}

			if ((double) maxArmyCnt / totArmyCnt > 0.5) {
				output.append(maxArmy + "\n");
			} else {
				output.append("SYJKGW\n");
			}

		}

		output.flush();
		output.close();
		input.close();
	}
}