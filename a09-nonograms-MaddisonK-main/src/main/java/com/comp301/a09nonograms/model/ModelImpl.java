package com.comp301.a09nonograms.model;

import com.comp301.a09nonograms.PuzzleLibrary;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  List<Clues> library;
  List<ModelObserver> observers = new ArrayList<>();
  List<Puzzle> puzzles = new ArrayList<>();
  public Puzzle activePuzzle;

  public ModelImpl(List<Clues> clues) {
    library = clues;
    for (Clues clue : clues) {
      BoardImpl board = new BoardImpl(clue.getHeight(), clue.getWidth());
      puzzles.add(new Puzzle(board, clue));
    }
    activePuzzle = puzzles.get(0);
  }

  @Override
  public int getPuzzleCount() {
    return library.size();
  }

  @Override
  public int getPuzzleIndex() {
    return puzzles.indexOf(activePuzzle);
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (index < 0 || index >= getPuzzleCount()) {
      return;
    }
    activePuzzle = puzzles.get(index);
    notifyObservers();
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public boolean isSolved() {
    Board board = activePuzzle.board;
    Clues clues = activePuzzle.clues;
    // check rows
    for (int i = 0; i < board.getHeight(); i++) {
      int[] rowClue = clues.getRowClues(i);
      int boardRowIndex = 0;
      for (int j = 0; j < rowClue.length; j++) {
        int count = 0;
        boolean counting = false;
        if (rowClue[j] == 0) {
          continue;
        } else {
          while (boardRowIndex < board.getWidth()) {
            if (board.isShaded(i, boardRowIndex)) {
              count++;
              counting = true;
              boardRowIndex++;
            } else if (!counting) {
              boardRowIndex++;
              continue;
            } else {
              boardRowIndex++;
              break;
            }
          }
        }
        if (count != rowClue[j]) {
          return false;
        }
      }
    }
    // check columns
    for (int i = 0; i < board.getWidth(); i++) {
      int[] colClue = clues.getColClues(i);
      int boardColIndex = 0;
      for (int j = 0; j < colClue.length; j++) {
        int count = 0;
        boolean counting = false;
        if (colClue[j] == 0) {
          continue;
        } else {
          while (boardColIndex < board.getHeight()) {
            if (board.isShaded(boardColIndex, i)) {
              count++;
              counting = true;
              boardColIndex++;
            } else if (!counting) {
              boardColIndex++;
              continue;
            } else {
              boardColIndex++;
              break;
            }
          }
        }
        if (count != colClue[j]) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return activePuzzle.board.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return activePuzzle.board.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return activePuzzle.board.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    activePuzzle.board.toggleCellShaded(row, col);
    notifyObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    activePuzzle.board.toggleCellEliminated(row, col);
    notifyObservers();
  }

  @Override
  public void clear() {
    activePuzzle.board.clear();
    notifyObservers();
  }

  @Override
  public int getWidth() {
    return activePuzzle.board.getWidth();
  }

  @Override
  public int getHeight() {
    return activePuzzle.board.getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return activePuzzle.clues.getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return activePuzzle.clues.getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return activePuzzle.clues.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return activePuzzle.clues.getColCluesLength();
  }

  private void notifyObservers() {
    for (ModelObserver observer : observers) {
      observer.update(this);
    }
  }
}
