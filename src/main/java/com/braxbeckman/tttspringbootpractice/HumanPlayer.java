package com.braxbeckman.tttspringbootpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private char icon = 'n';
    Board board;


    public HumanPlayer(char i, Board b) {
        icon = i;
        board = b;
    }

    @Override
    public void getMoveInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please select the square you would like to play: ");

        while(true) {
            String input = scan.nextLine();
            int intInput = 0;

            try {
                intInput = Integer.parseInt(input);
            }
            catch(NumberFormatException nfe) {
                System.out.println("Invalid input, please enter an integer digit");
            }

            if (intInput > 9 || intInput < 1) {
                System.out.println("Invalid input, please select a number between 1 and 9");
            }
            else if (board.getSymbol(intInput - 1) == 'X' || board.getSymbol(intInput - 1) == 'O') {
                System.out.println("Invalid input, please select a square that has not yet been selected");
            }
            else {
                board.changeBoard(intInput - 1, icon);
                break;
            }
        }

    }
}
@Configuration
class HumanPlayerFactory {
    @Bean
    public Player playerX(Board board) {
        return new HumanPlayer('X', board);
    }
    @Bean
    public Player playerO(Board board) {
        return new HumanPlayer('O', board);
    }
}