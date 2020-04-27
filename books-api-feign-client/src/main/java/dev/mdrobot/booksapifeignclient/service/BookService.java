package dev.mdrobot.booksapifeignclient.service;

import dev.mdrobot.booksapifeignclient.model.Item;

import java.util.List;


public interface BookService {

    public List<Item> getBooks(String query, String key);
}
