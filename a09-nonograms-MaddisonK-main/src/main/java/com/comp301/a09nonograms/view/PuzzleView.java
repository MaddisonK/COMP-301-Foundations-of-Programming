package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PuzzleView implements FXComponent {
  Controller controller;

  public PuzzleView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane grid = new GridPane();
    grid.setHgap(2);
    grid.setVgap(2);
    grid.setGridLinesVisible(true);

    for (int i = 0; i < controller.getClues().getHeight(); i++) {

      for (int j = 0; j < controller.getClues().getWidth(); j++) {

        Button btn = new Button();
        int finalJ = j;
        int finalI = i;
        Rectangle rectangle = new Rectangle(30, 30);
        if (controller.isShaded(i, j)) {
          rectangle.setFill(Color.BLACK);
        } else if (controller.isEliminated(i, j)) {
          rectangle.setFill(Color.LAWNGREEN);
        } else {
          rectangle.setFill(Color.WHITE);
        }
        rectangle.setOnMouseClicked(
            event -> {
              if (event.getButton() == MouseButton.PRIMARY) {
                controller.toggleShaded(finalI, finalJ);
              } else if (event.getButton() == MouseButton.SECONDARY) {
                controller.toggleEliminated(finalI, finalJ);
              }
            });
        btn.setOnAction(
            new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent actionEvent) {
                int row = finalJ;
                int col = finalI;
                controller.toggleShaded(row, col);
              }
            });
        grid.add(rectangle, j, i);
      }
    }
    // create Clues
    // first Rows
    GridPane vgrid = new GridPane();
    vgrid.setHgap(2);
    vgrid.setVgap(2);
    vgrid.setGridLinesVisible(true);
    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      HBox hb = new HBox();
      int[] clues = controller.getClues().getRowClues(i);
      for (int clue : clues) {
        if (clue == 0 && Max(clues) == 0) {
          Text text = new Text(" 0 ");
          hb.getChildren().add(text);
          break;
        } else if (clue == 0) {
          continue;
        } else {
          Text text = new Text(" " + String.valueOf(clue) + " ");
          hb.getChildren().add(text);
        }
      }
      Rectangle agent = new Rectangle(60, 30, Color.WHITE);
      StackPane stack = new StackPane();
      stack.getChildren().addAll(agent, hb);
      vgrid.add(stack, 0, i);
    }
    // then Cols
    GridPane hgrid = new GridPane();
    hgrid.setHgap(2);
    hgrid.setVgap(2);
    hgrid.setGridLinesVisible(true);
    for (int j = 0; j < controller.getClues().getWidth(); j++) {
      VBox vb = new VBox();
      int[] clues = controller.getClues().getColClues(j);
      for (int clue : clues) {
        if (clue == 0 && Max(clues) == 0) {
          Text text = new Text(" 0 ");
          vb.getChildren().add(text);
          break;
        } else if (clue == 0) {
          continue;
        } else {
          Text text = new Text(" " + String.valueOf(clue) + " ");
          vb.getChildren().add(text);
        }
      }
      Rectangle agent = new Rectangle(30, 60, Color.WHITE);
      StackPane stack = new StackPane();
      stack.getChildren().addAll(agent, vb);
      hgrid.add(stack, j, 0);
    }
    GridPane puzzleGrid = new GridPane();
    puzzleGrid.add(hgrid, 1, 0);
    puzzleGrid.add(vgrid, 0, 1);
    puzzleGrid.add(grid, 1, 1);

    //        BorderPane border = new BorderPane();
    //        border.setCenter(grid);
    return puzzleGrid;
  }

  private int Max(int[] a) {
    int c = 0;
    for (int i : a) {
      if (i > c) {
        c = i;
      }
    }
    return c;
  }
}

// package com.comp301.a09nonograms.view;
//
//        import com.comp301.a09nonograms.controller.Controller;
//        import com.comp301.a09nonograms.controller.ControllerImpl;
//        import javafx.event.ActionEvent;
//        import javafx.event.EventHandler;
//        import javafx.scene.Parent;
//        import javafx.scene.control.Button;
//        import javafx.scene.input.MouseButton;
//        import javafx.scene.layout.*;
//        import javafx.scene.paint.Color;
//        import javafx.scene.shape.Rectangle;
//
// public class PuzzleView implements FXComponent {
//    Controller controller;
//
//    public PuzzleView(Controller controller) {
//        this.controller = controller;
//    }
//
//    @Override
//    public Parent render() {
//        GridPane grid = new GridPane();
//        grid.setHgap(2);
//        grid.setVgap(2);
//        grid.setGridLinesVisible(true);
//
//        for (int i = 0; i<controller.getClues().getHeight(); i++) {
//
//            for (int j = 0; j<controller.getClues().getWidth(); j++) {
//
//                Button btn = new Button();
//                int finalJ = j;
//                int finalI = i;
//                Rectangle rectangle = new Rectangle(30, 30);
//                if (controller.isShaded(i, j)) {
//                    rectangle.setFill(Color.BLACK);
//                } else if (controller.isEliminated(i,j)) {
//                    rectangle.setFill(Color.LAWNGREEN);
//                } else {
//                    rectangle.setFill(Color.WHITE);
//                }
//                rectangle.setOnMouseClicked(event ->
//                {
//                    if (event.getButton() == MouseButton.PRIMARY)
//                    {
//                        controller.toggleShaded(finalI, finalJ);
//                    } else if (event.getButton() == MouseButton.SECONDARY)
//                    {
//                        controller.toggleEliminated(finalI, finalJ);
//                    }
//                });
//                btn.setOnAction(
//                        new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent actionEvent) {
//                                int row = finalJ;
//                                int col = finalI;
//                                controller.toggleShaded(row, col);
//                            }
//                        });
//                grid.add(rectangle, j , i);
//            }
//        }
//        BorderPane border = new BorderPane();
//        border.setCenter(grid);
//        return border;
//    }
// }
