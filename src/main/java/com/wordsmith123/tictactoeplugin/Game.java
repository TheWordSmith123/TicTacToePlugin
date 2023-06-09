package com.wordsmith123.tictactoeplugin;

public class Game {
    private char[] board;
    private char currentPlayer;

    public Game() {
        board = new char[9];
        currentPlayer = 'X';
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
    }

    public boolean play(int position) {
        if (position < 0 || position > 8 || board[position] != '-') {
            return false;
        }

        board[position] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    public String getBoard() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                str.append("\n");
            }
            str.append(board[i]);
        }
        return str.toString();
    }

    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[3*i] != '-' && board[3*i] == board[3*i+1] && board[3*i+1] == board[3*i+2]) {
                return board[3*i];
            }
            if (board[i] != '-' && board[i] == board[i+3] && board[i+3] == board[i+6]) {
                return board[i];
            }
        }
        if (board[0] != '-' && board[0] == board[4] && board[4] == board[8]) {
            return board[0];
        }
        if (board[2] != '-' && board[2] == board[4] && board[4] == board[6]) {
            return board[2];
        }
        return '-';
    }
}

