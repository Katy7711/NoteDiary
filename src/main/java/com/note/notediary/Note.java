package com.note.notediary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Note {

  private final int id;
  private String tittle;
  private String textNote;
  private final String date;
  public static int count = 1;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

  public Note(String title, String textNote) {
    this.tittle = title;
    this.textNote = textNote;
    this.date = formatter.format(LocalDateTime.now());
    LocalDateTime.now();
    this.id = count++;
  }

  public String getTittle() {
    return tittle;
  }

  public void setTittle(String title) {
    this.tittle = tittle;
  }

  public String getTextNote() {
    return textNote;
  }

  public void setTextNote(String textNote) {
    this.textNote = textNote;
  }


  public int getId() {
    return id;
  }

  public String getDate() {
    return date;
  }

  @Override
  public String toString() {
    return id + ": " + tittle + "\n"
        + textNote + "\n" +
        "Заметка создана: " + date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Note note = (Note) o;
    return id == note.id && Objects.equals(tittle, note.tittle) && Objects.equals(
        textNote, note.textNote) && Objects.equals(date, note.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tittle, textNote, date);
  }
}
