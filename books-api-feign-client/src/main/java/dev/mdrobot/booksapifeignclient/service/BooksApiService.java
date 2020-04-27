package dev.mdrobot.booksapifeignclient.service;

import dev.mdrobot.booksapifeignclient.model.BooksApiResponse;
import dev.mdrobot.booksapifeignclient.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksApiService implements BookService {


    @Autowired
    private BooksApiClient client;

    @Value("${books.api.key}")
    private String key;

    @Override
    public java.util.List<Item> getBooks(String query, String key) {
        BooksApiResponse response = client.getBooks(query, key);
        List<Item> items = new ArrayList<>();
        for (Item item : response.getItems()){
            items.add(item);
        }
        return items;
    }




}
