package by.ilyatr.library.service;


import by.ilyatr.library.dto.BookDto;

import java.util.*;

public class LibraryService {

  private static final Map<UUID, BookDto> storage = new HashMap<>();

  public List<BookDto> getAll() {
    return new ArrayList<>(storage.values());
  }

  public BookDto getById(UUID id) {
    return storage.get(id);
  }

  public BookDto create(BookDto book) {
    UUID id = UUID.randomUUID();
    book.setId(id);
    storage.put(id, book);
    return book;
  }
}
