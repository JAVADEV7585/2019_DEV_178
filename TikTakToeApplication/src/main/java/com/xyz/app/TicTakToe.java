package com.xyz.app;

import java.util.Scanner;

import com.xyz.exception.PositionInUseException;

public class TicTakToe {

	private int[][] tiktaktoe = new int[3][3];
	private int playerX = 1, playerO = -1;
	private int count = 0;

	public String play(int x, int y, int player) throws PositionInUseException {

		if (count < 9) {

			inputByTurn(x, y, player);
			if (count >= 4) { ///// After 5th turn there is possibility one player could win.
				if (winDeclaration(player)) {
					return player + " WON";
				}
			}
			count++;
			if (count == 9) {
				return "DRAW";
			}

		}
		return "CONTINUE";
	}

	public int[][] getTikTokToe() {
		return tiktaktoe;
	}

	/*
	 * if its turn of X ten input will be 1 if its turn of O then input will be -1
	 */

	public void inputByTurn(int x, int y, int player) throws PositionInUseException {

		if ((2 >= x || x >= 0) && (2 >= y || y >= 0)) {
			if (tiktaktoe[x][y] == 0) {
				tiktaktoe[x][y] = player;
			} else {
				throw new PositionInUseException("Position is already in use. Please use other free position");
			}
		}
	}

	// In TikTokToe Game there are eight combination 3 horizontol, 3 vertical and 2
	// diagonal
	public boolean winDeclaration(int player) {

		return tiktaktoe[0][0] + tiktaktoe[0][1] + tiktaktoe[0][2] == 3 * player
				|| tiktaktoe[1][0] + tiktaktoe[1][1] + tiktaktoe[1][2] == 3 * player
				|| tiktaktoe[2][0] + tiktaktoe[2][1] + tiktaktoe[2][2] == 3 * player
				|| tiktaktoe[0][0] + tiktaktoe[1][0] + tiktaktoe[2][0] == 3 * player
				|| tiktaktoe[0][1] + tiktaktoe[1][1] + tiktaktoe[1][2] == 3 * player
				|| tiktaktoe[0][2] + tiktaktoe[1][2] + tiktaktoe[2][2] == 3 * player
				|| tiktaktoe[0][0] + tiktaktoe[1][1] + tiktaktoe[2][2] == 3 * player
				|| tiktaktoe[0][2] + tiktaktoe[1][1] + tiktaktoe[2][0] == 3 * player;
	}

}
