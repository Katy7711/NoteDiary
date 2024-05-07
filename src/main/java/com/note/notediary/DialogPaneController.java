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

public class DialogPaneController {


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
        Note note = new Note(tittleWrite.getText(), textArea.getText());
        notes.add(note);
        ListView<Note> listView = notesController.getListView();
        listView.setItems(notes);
        System.out.println("Заметка успешно сохранена");
      }
    }

    @FXML
    void initialize () {
      Context.getInstance().setDialogPaneController(this);

    }

    public NotesController getListController () {
      return notesController;
    }

    public void setListController (NotesController notesController){
      this.notesController = notesController;
    }

    public TextArea getTextArea () {
      return textArea;
    }

    public void setTextArea (TextArea textArea){
      this.textArea = textArea;
    }

    public TextField getTittleWrite () {
      return tittleWrite;
    }

    public void setTittleWrite (TextField tittleWrite){
      this.tittleWrite = tittleWrite;
    }
  }

