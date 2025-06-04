package com.braxbeckman.tttspringbootpractice;

public class ComputerPlayer implements Player {

    char icon;
    Board board;

    public ComputerPlayer(char icon, Board board) {
        this.icon = icon;
        this.board = board;
    }

    @Override
    public void getMoveInput() {
        board.changeBoard(getFirstAvailableMove(board), icon);
    }

    public int getFirstAvailableMove(Board board) {
        for (int i = 0; i < 9; i++) {
            if (board.getSymbol(i) != 'X' && board.getSymbol(i) != 'O') {
                return i;
            }
        }
        return -1;
    }

    public int getFirstAvailableMove(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return i;
            }
        }
        return -1;
    }

}
