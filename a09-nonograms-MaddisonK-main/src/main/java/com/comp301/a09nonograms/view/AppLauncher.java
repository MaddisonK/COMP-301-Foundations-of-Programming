package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import com.comp301.a09nonograms.model.ModelObserver;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class AppLauncher extends Application {
  Stage stage;
  PuzzleView puzzleView;
  ControlsView controlsView;
  Scene scene;
  Controller controller;

  @Override
  public void start(Stage stage) {
    List<Clues> clues = PuzzleLibrary.create();
    ModelImpl model = new ModelImpl(clues);
    Controller controller = new ControllerImpl(model);
    this.controller = controller;
    ModelObserver observer =
        (Model m) -> {
          renderScene();
        };
    model.addObserver(observer);

    stage.setTitle("NONOGRAMS");
    this.stage = stage;

    // Components
    PuzzleView puzzleView = new PuzzleView(controller);
    this.puzzleView = puzzleView;
    ControlsView controlsView = new ControlsView(controller);
    this.controlsView = controlsView;

    renderScene();

    stage.show();
  }

  public void renderScene() {
    Parent puzzle = puzzleView.render();
    Parent controls = controlsView.render();
    VBox pane = new VBox();
    //    pane.setAlignment(Pos.CENTER);
    pane.setSpacing(20);
    pane.getChildren().add(controls);
    pane.getChildren().add(puzzle);
    if (controller.isSolved()) {
      Text text = new Text("\t\t\tSOLVED!");
      text.setFill(Color.GREEN);
      text.setScaleX(3);
      text.setScaleY(3);
      pane.getChildren().add(text);
    }
    Scene scene = new Scene(pane, 500, 500);
    scene.setFill(Color.WHITE);
    stage.setScene(scene);
  }
}
