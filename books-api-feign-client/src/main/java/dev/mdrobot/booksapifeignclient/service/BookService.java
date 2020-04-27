package dev.mdrobot.booksapifeignclient.service;

import dev.mdrobot.booksapifeignclient.model.BookInfo;

import java.util.List;


public interface BookService {

    public List<BookInfo> getBooks(String query);
}
