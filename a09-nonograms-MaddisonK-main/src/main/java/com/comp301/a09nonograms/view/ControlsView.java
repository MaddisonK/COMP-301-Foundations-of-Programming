package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ControlsView implements FXComponent {
  Controller controller;
  private HBox layout;

  public ControlsView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    layout = new HBox();
    Button prevButton = new Button("\u276E");
    //        prevButton.setText("<-");
    prevButton.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
        });
    Button nextButton = new Button("\u276F");
    //        nextButton.setText("->");
    nextButton.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
        });
    Button clearButton = new Button();
    clearButton.setText("clear");
    clearButton.setOnAction(
        (ActionEvent event) -> {
          controller.clearBoard();
        });
    Text puzzleIndex =
        new Text(
            "\tpuzzle "
                + (controller.getPuzzleIndex() + 1)
                + "/"
                + controller.getPuzzleCount()
                + "\t");
    Button randomButton = new Button();
    randomButton.setText("random");
    randomButton.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });

    layout.getChildren().addAll(prevButton, nextButton, puzzleIndex, clearButton, randomButton);
    return layout;
  }
}
