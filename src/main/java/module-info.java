module com.note.notediary {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.note.notediary to javafx.fxml;
  exports com.note.notediary;
}