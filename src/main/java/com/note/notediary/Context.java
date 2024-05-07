package com.note.notediary;

public class Context {

  private final static Context instance = new Context();

  public static Context getInstance() {
    return instance;
  }

  private DialogWindowController dialogWindowController;
  private NotesController notesController;
  private DialogPaneController dialogPaneController;
  private DialogPaneEditController dialogPaneEditController;



  public DialogPaneController getDialogPaneController() {
    return dialogPaneController;
  }

  public void setDialogPaneController(DialogPaneController dialogPaneController) {
    this.dialogPaneController = dialogPaneController;
  }

  public NotesController getNotesController() {
    return notesController;
  }

  public void setNotesController(NotesController notesController) {
    this.notesController = notesController;
  }

  public DialogWindowController getDialogWindowController() {
    return dialogWindowController;
  }

  public void setDialogWindowController(DialogWindowController dialogWindowController) {
    this.dialogWindowController = dialogWindowController;
  }

  public DialogPaneEditController getDialogPaneEditController() {
    return dialogPaneEditController;
  }

  public void setDialogPaneEditController(
      DialogPaneEditController dialogPaneEditController) {
    this.dialogPaneEditController = dialogPaneEditController;
  }
}
