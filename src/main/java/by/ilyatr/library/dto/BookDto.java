package by.ilyatr.library.dto;

import java.util.UUID;

public class BookDto {
  private UUID id;
  private String title;
  private String author;

  public BookDto() {
  }

  public BookDto(UUID id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
