package baekjoon.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2579
// 계단 오르기

public class baekjoon2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

		int stairsCnt = Integer.parseInt(input.readLine());
		int[] stairsScore = new int[stairsCnt];
		int[][] scoreBoard = new int[2][stairsCnt]; // 0 : 1연속, 1 : 2연속 계단 밟은 횟수

		for (int i = 0; i < stairsCnt; i++) {
			stairsScore[i] = Integer.parseInt(input.readLine());
		}

		scoreBoard[0][0] = stairsScore[0];
		if (stairsCnt >= 2) {
			scoreBoard[0][1] = stairsScore[1];
			scoreBoard[1][1] = stairsScore[0] + stairsScore[1];
		}

		for (int i = 2; i < stairsCnt; i++) {
			//+1 계단
			scoreBoard[1][i] = scoreBoard[0][i-1] + stairsScore[i];

			//+2 계단
			scoreBoard[0][i] = Math.max(scoreBoard[0][i-2], scoreBoard[1][i-2]) + stairsScore[i];
		}

		output.append(Math.max(scoreBoard[0][stairsCnt - 1], scoreBoard[1][stairsCnt - 1]) + "");

		output.flush();
		output.close();
		input.close();
	}
}