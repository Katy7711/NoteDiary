package com.note.notediary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {


  @FXML
  private Button toComeIn;

  @FXML
  void initialize() {
    toComeIn.setOnAction(event -> {
      toComeIn.getScene().getWindow().hide();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("notes.fxml"));
      try {
        loader.load();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      Parent root = loader.getRoot();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.showAndWait();
    });
  }
}