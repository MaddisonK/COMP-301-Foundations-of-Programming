package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {
  public int[][] board; // 0 = emtpy, 1 = shaded, 2 = X
  final int height;
  final int width;

  public BoardImpl(int height, int width) {
    this.height = height;
    this.width = width;
    board = new int[height][width];
    for (int i = 0; i < height; i++) { // initialize board to 0
      for (int j = 0; j < width; j++) {
        board[i][j] = 0;
      }
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    return (board[row][col] == 1);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return (board[row][col] == 2);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return (board[row][col] == 0);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (isShaded(row, col)) {
      board[row][col] = 0;
    } else {
      board[row][col] = 1;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (board[row][col] == 2) {
      board[row][col] = 0;
    } else {
      board[row][col] = 2;
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < height; i++) { // initialize board to 0
      for (int j = 0; j < width; j++) {
        board[i][j] = 0;
      }
    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }
}
