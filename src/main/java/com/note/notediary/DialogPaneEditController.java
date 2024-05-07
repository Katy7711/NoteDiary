package com.note.notediary;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogPaneEditController {


  @FXML
  private Menu plus;

  @FXML
  private MenuItem save;
  @FXML
  private DialogPane dialogPane;
  @FXML
  private TextArea textArea;
  @FXML
  private TextField tittleWrite;

  NotesController notesController = Context.getInstance().getNotesController();


  @FXML
  private void save() {
    if (tittleWrite.getText().trim().equals("") || textArea.getText().trim().equals("")) {
      System.out.println("Заполните заголовок и текст заметки");
    } else {
      ObservableList<Note> notes = notesController.getNotes();
      Note note1 = notesController.getListView().getSelectionModel().getSelectedItem();
      Note note = notes
          .stream()
          .filter(note2 -> (note1.getTittle().equals(note2.getTittle())) && (note1.getTextNote().equals(note2.getTextNote())))
          .findFirst()
              .orElse(null);
      assert note != null;
      note.setTittle(tittleWrite.getText());
      note.setTextNote(textArea.getText());
      ListView<Note> listView = notesController.getListView();
      listView.setItems(notes);
      listView.refresh();
      System.out.println("Заметка успешно отредактирована");

    }
  }

  @FXML
  void initialize() {
    Context.getInstance().setDialogPaneEditController(this);

  }

  public TextArea getTextArea() {
    return textArea;
  }

  public void setTextArea(TextArea textArea) {
    this.textArea = textArea;
  }

  public TextField getTittleWrite() {
    return tittleWrite;
  }

  public void setTittleWrite(TextField tittleWrite) {
    this.tittleWrite = tittleWrite;
  }
}
