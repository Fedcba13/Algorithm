package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/20529
// 가장 가까운 세 사람의 심리적 거리

public class baekjoonv20529 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(input.readLine()); //테스트 케이스의 수

		HashMap<String, HashMap<String, Integer>> dist = new HashMap<>();

		String[] mbti = new String[] {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
		for (int i = 0; i < mbti.length; i++) {
			dist.put(mbti[i], new HashMap<>());
		}
		for (int i = 0; i < mbti.length; i++) {
			for (int j = i; j < mbti.length; j++) {
				int tmpDist = 0;
				for (int k = 0; k < mbti[i].length(); k++) {
					if (mbti[i].charAt(k) != mbti[j].charAt(k)) {
						tmpDist++;
					}
				}
				dist.get(mbti[i]).put(mbti[j], tmpDist);
				dist.get(mbti[j]).put(mbti[i], tmpDist);
			}
		}

		for (int i = 0; i < T; i++) {
			int result = Integer.MAX_VALUE;
			int N = Integer.parseInt(input.readLine()); //학생의 수

			HashMap<String, Integer> studentMap = new HashMap<>();

			st = new StringTokenizer(input.readLine());
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				String str = st.nextToken();
				int tmp = studentMap.getOrDefault(str, 0);
				if (tmp != 3) {
					studentMap.put(str, tmp + 1);
					cnt++;
				}
			}
			String[] student = new String[cnt];
			int index = 0;
			for (String key : studentMap.keySet()) {
				for (int j = 0; j < studentMap.get(key); j++) {
					student[index++] = key;
				}
			}

			for (int j = 0; j < cnt; j++) {
				for (int k = j+1; k < cnt; k++) {
					for (int l = k+1; l < cnt; l++) {
						int tmpResult = dist.get(student[j]).get(student[k]) + dist.get(student[j]).get(student[l]) + dist.get(student[k]).get(student[l]);
						result = Math.min(result, tmpResult);
					}
				}
			}
			output.append(result + "\n");
		}

		output.flush();
		output.close();
		input.close();
	}
}