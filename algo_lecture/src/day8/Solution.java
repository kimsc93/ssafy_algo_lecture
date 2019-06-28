package algo_day4_2;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // test case cnt

		for (int tc = 1; tc <= T; tc++) {

			boolean[] selected = new boolean[19];

			g_cards = new int[9];

			for (int i = 0; i < 9; i++) {

				g_cards[i] = sc.nextInt();

				selected[g_cards[i]] = true;

			}

			int[] i_cards = new int[9];

			int idx = 0;

			for (int i = 1; i < 19; i++) {

				if (!selected[i]) {

					i_cards[idx++] = i;

				}

			}

			wincnt = 0;

			perm(i_cards, 0);

			System.out.println("#" + tc + " " + wincnt + " " + (fact9 - wincnt));

		}

	}

	static int[] g_cards;

	static int wincnt;

	static int fact9;

	static {

		fact9 = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;

	}

	static void perm(int[] i_cards, int n) {

		if (n == i_cards.length) {

			int g_score = 0;

			int i_score = 0;

			for (int i = 0; i < 9; i++) {

				if (g_cards[i] > i_cards[i])

					g_score += g_cards[i] + i_cards[i];

				else {

					i_score += g_cards[i] + i_cards[i];

				}

			}

			if (g_score > i_score)

				wincnt++;

			return;

		}

		for (int i = n; i < i_cards.length; i++) {

			swap(i_cards, i, n);

			perm(i_cards, n + 1);

			swap(i_cards, i, n);

		}

	}

	static void swap(int[] arr, int a, int b) {

		int tmp = arr[a];

		arr[a] = arr[b];

		arr[b] = tmp;

	}

}