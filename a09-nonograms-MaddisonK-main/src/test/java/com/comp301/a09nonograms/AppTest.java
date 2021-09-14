package com.comp301.a09nonograms;

import static org.junit.Assert.assertTrue;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.CluesImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    int[][] rowClues =
          new int[][] {
                  new int[] {0, 2},
                  new int[] {1, 2},
                  new int[] {0, 3},
                  new int[] {0, 3},
                  new int[] {1, 1},
          };

    int[][] colClues =
          new int[][] {
                  new int[] {1, 1},
                  new int[] {0, 1},
                  new int[] {0, 3},
                  new int[] {0, 3},
                  new int[] {3, 1},
          };

    Clues example = new CluesImpl(rowClues, colClues);
    List<Clues> cluesList = new ArrayList<>();
    cluesList.add(example);
    Model model = new ModelImpl(cluesList);
    model.toggleCellShaded(0,1);
    System.out.println(model.isShaded(0,1));
    model.toggleCellEliminated(0,1);
    System.out.println(model.isEliminated(0,1));

//    model.toggleCellShaded(0, 1);
//    model.toggleCellShaded(0, 2);
//    model.toggleCellShaded(1, 1);
//    model.toggleCellShaded(1, 3);
//    model.toggleCellShaded(1, 4);
//    model.toggleCellShaded(2, 0);
//    model.toggleCellShaded(2, 1);
//    model.toggleCellShaded(2,2);
//    model.toggleCellShaded(3, 2);
//    model.toggleCellShaded(3,4);
//    model.toggleCellShaded(3,3);
//    model.toggleCellShaded(4, 0);
//    model.toggleCellShaded(4, 2);

    //column only




    assertTrue(true);

  }

  @Test
  public void shouldBeTrue() {
    List<Clues> clues = PuzzleLibrary.create();
    ModelImpl model = new ModelImpl(clues);
    model.setPuzzleIndex(2);
    model.toggleCellShaded(0, 0);
    System.out.println(model.isShaded(0,0));
    System.out.println(model.isEliminated(0,0));
    System.out.println(model.isSpace(0,0));
    model.toggleCellShaded(0,0);
    model.toggleCellShaded(0,0);
    System.out.println(model.isShaded(0,0));
    System.out.println(model.isEliminated(0,0));
    System.out.println(model.isSpace(0,0));
    model.toggleCellShaded(0,0);
    System.out.println(model.isShaded(0,0));
    System.out.println(model.isEliminated(0,0));
    System.out.println(model.isSpace(0,0));
    System.out.println(model.activePuzzle.board.isSpace(0,0));

    assertTrue(true);


  }

  @Test
  public void Truee() {
    List<Clues> clues = PuzzleLibrary.create();
    ModelImpl model = new ModelImpl(clues);
    Controller controller = new ControllerImpl(model);
    controller.randPuzzle();
    System.out.println(controller.getPuzzleIndex());
    controller.randPuzzle();
    System.out.println(controller.getPuzzleIndex());
  }



}
