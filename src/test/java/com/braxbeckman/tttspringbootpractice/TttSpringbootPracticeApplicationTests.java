package com.braxbeckman.tttspringbootpractice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TttSpringbootPracticeApplicationTests {

	@Autowired
	private Board board;

	@Test
	void boardInitializes() {
		assertEquals(
                "1" + " | " +  "2" +  " | " +  "3"
                + "\n---------"
                + "\n" + "4" + " | " +  "5" +  " | " +  "6"
                + "\n---------"
                + "\n" + "7" + " | " +  "8" +  " | " +  "9",

                board.getSymbol(0) + " | " +  board.getSymbol(1) +  " | " +  board.getSymbol(2)
                + "\n---------"
                + "\n" + board.getSymbol(3) + " | " +  board.getSymbol(4) +  " | " +  board.getSymbol(5)
                + "\n---------"
                + "\n" + board.getSymbol(6) + " | " +  board.getSymbol(7) +  " | " +  board.getSymbol(8));
	}

	@Test
	void movesWork() {
		board.changeBoard(5, 'X');
		assertEquals('X', board.getSymbol(5));
	}


}
