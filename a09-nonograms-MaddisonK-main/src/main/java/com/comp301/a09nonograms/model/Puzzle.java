package com.comp301.a09nonograms.model;

import java.util.List;

public class Puzzle {
  public Clues clues;
  public Board board;

  public Puzzle(Board board, Clues clues) {
    this.board = board;
    this.clues = clues;
  }
}
