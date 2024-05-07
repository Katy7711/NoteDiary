package com.note.notediary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DialogWindowController {


  @FXML
  private Button no;

  @FXML
  private Button yes;
  NotesController notesController = Context.getInstance().getNotesController();

  @FXML
  void delete(ActionEvent event) {
    yes.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
          final int selectedIdx = notesController.getListView().getSelectionModel()
              .getSelectedIndex();
          if (selectedIdx != -1) {
            String itemToRemove = String.valueOf(
                notesController.getListView().getSelectionModel().getSelectedItem());
            final int newSelectedIdx =
                (selectedIdx == notesController.getListView().getItems().size() - 1)
                    ? selectedIdx - 1
                    : selectedIdx;
            notesController.getListView().getSelectionModel().select(newSelectedIdx);
            notesController.getListView().getItems().remove(selectedIdx);
            System.out.println("Заметка удалена: " + itemToRemove);
            yes.getScene().getWindow().hide();
          }
        }
    });
  }

  @FXML
  void initialize() {
    Context.getInstance().setDialogWindowController(this);
    no.setOnAction(event -> {
      no.getScene().getWindow().hide();
    });
  }
}


