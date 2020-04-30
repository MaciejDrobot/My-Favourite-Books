package dev.mdrobot.booksapifeignclient.service;

import dev.mdrobot.booksapifeignclient.model.BookInfo;
import dev.mdrobot.booksapifeignclient.model.BooksApiResponse;
import dev.mdrobot.booksapifeignclient.model.Item;
import dev.mdrobot.booksapifeignclient.model.LoadBalancerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksApiService implements BookService {

    @Autowired
    private BooksApiClient client;

    @Autowired
    private Environment environment;

    @Override
    public List<BookInfo> getBooks(String query) {
        BooksApiResponse response = client.getBooks(query);
        List<BookInfo> queryResults = new ArrayList<>();

        for (Item item : response.getItems()){
            BookInfo book = new BookInfo(
                    item.getVolumeInfo().getTitle(),
                    item.getVolumeInfo().getAuthors().get(0));
            queryResults.add(book);
        }
        return queryResults;
    }

    public LoadBalancerTest loadBalancerTest(String query){
        BooksApiResponse response = client.getBooks(query);
        List<BookInfo> queryResults = new ArrayList<>();
        for (Item item : response.getItems()){
            BookInfo book = new BookInfo(
                    item.getVolumeInfo().getTitle(),
                    item.getVolumeInfo().getAuthors().get(0));
            queryResults.add(book);
        }
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        return new LoadBalancerTest(queryResults, port);
    }




}
