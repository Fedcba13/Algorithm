package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// https://www.acmicpc.net/problem/1043
// 거짓말

public class baekjoon1043 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(input.readLine());

		int N = Integer.parseInt(st.nextToken()); //사람의 수
		int M = Integer.parseInt(st.nextToken()); //파티의 수

		HashMap<Integer, HashSet<Integer>> party = new HashMap<>(); //파티에 참가한 인원
		HashMap<Integer, HashSet<Integer>> person = new HashMap<>(); //인원이 참가한 파티

		st = new StringTokenizer(input.readLine());

		int[] knowTruth = new int[N+1]; //진실 아는 사람

		int knowTruthCnt = Integer.parseInt(st.nextToken()); //진실을 아는 사람의 수

		for (int i = 0; i < knowTruthCnt; i++) {
			int knowTruthPerson = Integer.parseInt(st.nextToken()); //진실을 아는 사람
			knowTruth[knowTruthPerson] = 1;
		}

		for (int i = 0; i < N+1; i++) {
			person.put(i, new HashSet<>());
		}

		for (int i = 0; i < M+1; i++) {
			party.put(i, new HashSet<>());
		}

		String[] partyInfo = new String[M]; // 파티 정보
		int[] knowTruthParty = new int[M]; //진실을 아는 파티

		for (int i = 0; i < M; i++) {
			partyInfo[i] = input.readLine();
			st = new StringTokenizer(partyInfo[i]);
			Queue<Integer> partyList = new LinkedList<>();

			int enterCnt = Integer.parseInt(st.nextToken()); //i번째 파티에 오는 사람의 수

			for (int j = 0; j < enterCnt; j++) {
				int enterPerson = Integer.parseInt(st.nextToken()); //파티에 온 사람

				party.get(i).add(enterPerson);
				person.get(enterPerson).add(i);
				
				if (knowTruth[enterPerson] == 1 && partyList.isEmpty()) {//파티에 참가한 인원이 진실을 알면
					partyList.add(i);
				}
			}

			while (partyList.isEmpty() == false) {
				int partyNum = partyList.poll();
				if (knowTruthParty[partyNum] == 0) {
					knowTruthParty[partyNum] = 1;
					for (Integer personNum : party.get(partyNum)) {
						knowTruth[personNum] = 1;
						for (Integer partyNum2 : person.get(personNum)) {
							if (knowTruthParty[partyNum2] == 0) {
								partyList.add(partyNum2);
							}
						}
					}
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < knowTruthParty.length; i++) {
			if (knowTruthParty[i] == 0) {
				answer++;
			}
		}

		output.append(answer + "");
		
		output.flush();
		output.close();
		input.close();
	}
}