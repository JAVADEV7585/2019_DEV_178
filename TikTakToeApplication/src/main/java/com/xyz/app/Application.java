package com.xyz.app;

import java.util.Scanner;

import com.xyz.exception.PositionInUseException;

public class Application {

	public static void main(String[] args) {
		TicTakToe tiktaktoe = new TicTakToe();
		String result = null;
		int player = 0;

		for (int i = 0; i < 9; i++) {
			if (i == 0 || i % 2 == 0) {
				System.out.println("Player X turn enter comma seperated cordinate,");
				player = 1;
			} else {
				System.out.println("Player O turn enter comma seperated cordinate,");
				player = -1;
			}
			Scanner scanner = new Scanner(System.in);
			String username = scanner.nextLine();
			String[] array = username.split(",", 3);
			try {
				result = tiktaktoe.play(Integer.parseInt(array[0]), Integer.parseInt(array[1]), player);
			} catch (PositionInUseException e) {
				i = i - 1;
				System.out.println("Please play again on valid cordinate ,");
			}
			if (result.contains("WON")) {
				System.out.println("You won");
				break;
			} else if (result.contains("DRAW")) {
				System.out.println("Match Draw");
			}
		}
	}

}
