package com.note.notediary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NotesController {


  @FXML
  private ListView<Note> listView;
  @FXML
  private Button exit;
  @FXML
  private Button delete;
  @FXML
  private Button edit;
  @FXML
  private Button add;

  DialogPaneController dialogPaneController = Context.getInstance().getDialogPaneController();


  private ObservableList<Note> notes = FXCollections.observableArrayList();


  @FXML
  void exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    Platform.exit();
  }


  @FXML
  void delete(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader();
    if (notes.isEmpty()) {
      loader.setLocation(getClass().getResource("emptyList.fxml"));
      createStage(loader);
      System.out.println("Список заметок пуст!");
    } else {
      if (listView.getSelectionModel().isEmpty()) {
        loader.setLocation(getClass().getResource("notSelected.fxml"));
        createStage(loader);
        System.out.println("Заметка не выбрана");
      } else {
        loader.setLocation(getClass().getResource("dialogWindow.fxml"));
        createStage(loader);
      }
    }
  }

  @FXML
  void edit(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader();
    if (notes.isEmpty()) {
      loader.setLocation(getClass().getResource("emptyList.fxml"));
      createStage(loader);
      System.out.println("Список заметок пуст!");
    } else {
      if (listView.getSelectionModel().isEmpty()) {
        loader.setLocation(getClass().getResource("notSelected.fxml"));
        createStage(loader);
        System.out.println("Заметка не выбрана");
      } else {
        Note note = listView.getSelectionModel().getSelectedItem();
        String textField = note.getTittle();
        String textArea = note.getTextNote();
        loader.setLocation(getClass().getResource("dialogPaneEdit.fxml"));
        try {
          loader.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        TextField textField1 = Context.getInstance().getDialogPaneEditController().getTittleWrite();
        textField1.setText(textField);
        TextArea textArea1 = Context.getInstance().getDialogPaneEditController().getTextArea();
        textArea1 .setText(textArea);
        stage.setScene(new Scene(root));
        stage.show();
      }
    }
  }

  @FXML
  void initialize() {
    Context.getInstance().setNotesController(this);
    add.setOnAction(event -> {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("dialogPane.fxml"));
      try {
        loader.load();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      Parent root = loader.getRoot();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();
    });
  }


  public ListView<Note> getListView() {
    return listView;
  }

  public void setListView(ListView<Note> listView) {
    this.listView = listView;
  }

  public ObservableList<Note> getNotes() {
    return notes;
  }

  public void setNotes(ObservableList<Note> notes) {
    this.notes = notes;
  }

  private static void createStage(FXMLLoader loader) {
    try {
      loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Parent root = loader.getRoot();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
  }

}


