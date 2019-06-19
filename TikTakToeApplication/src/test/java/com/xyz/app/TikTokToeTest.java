package com.xyz.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import com.xyz.app.TicTakToe;
import com.xyz.exception.PositionInUseException;

public class TikTokToeTest {

	@Test
	public void testTikTakToeGird() {

		TicTakToe tiktaktoe = new TicTakToe();
		assertEquals(tiktaktoe.getTikTokToe().length, 1);
	}

	@Test
	public void testInput() throws PositionInUseException {
		TicTakToe tiktaktoe = new TicTakToe();
		tiktaktoe.inputByTurn(0, 0, 1);
		assertEquals(tiktaktoe.getTikTokToe()[0][0], 1);
		tiktaktoe.inputByTurn(1, 0, -1);
		assertEquals(tiktaktoe.getTikTokToe()[0][0], 1);
	}

	@Test(expected = PositionInUseException.class)
	public void TestAlreadyUsePositionFailure() throws PositionInUseException {
		TicTakToe tiktaktoe = new TicTakToe();
		tiktaktoe.inputByTurn(0, 0, 1);
		tiktaktoe.inputByTurn(0, 0, -1);

	}

	@Test
	public void testWinConditionMethod() throws PositionInUseException {
		TicTakToe tiktaktoe = new TicTakToe();
		tiktaktoe.inputByTurn(0, 0, 1);
		tiktaktoe.inputByTurn(1, 0, -1);
		tiktaktoe.inputByTurn(1, 1, 1);
		tiktaktoe.inputByTurn(1, 2, -1);
		tiktaktoe.inputByTurn(2, 2, 1);
		assertEquals(tiktaktoe.winDeclaration(1), true);
	}

	@Test
	public void testPlayWithWon() throws PositionInUseException {
		TicTakToe tiktaktoe = new TicTakToe();
		assertEquals(tiktaktoe.play(0, 0, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(1, 0, -1), "CONTINUE");
		assertEquals(tiktaktoe.play(1, 1, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(1, 2, -1), "CONTINUE");
		assertEquals(tiktaktoe.play(2, 2, 1), 1 + " WON");
	}

	@Test
	public void testPlayWithDraw() throws PositionInUseException {

		TicTakToe tiktaktoe = new TicTakToe();
		assertEquals(tiktaktoe.play(0, 0, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(1, 0, -1), "CONTINUE");
		assertEquals(tiktaktoe.play(1, 1, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(2, 2, -1), "CONTINUE");
		assertEquals(tiktaktoe.play(1, 2, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(2, 0, -1), "CONTINUE");
		assertEquals(tiktaktoe.play(2, 1, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(0, 2, 1), "CONTINUE");
		assertEquals(tiktaktoe.play(0, 1, -1), "DRAW");

	}

}
