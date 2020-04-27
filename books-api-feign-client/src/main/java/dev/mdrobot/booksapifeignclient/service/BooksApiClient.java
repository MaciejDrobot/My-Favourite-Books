package dev.mdrobot.booksapifeignclient.service;

import dev.mdrobot.booksapifeignclient.model.BooksApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client", url = "https://www.googleapis.com/books/v1/volumes")
public interface BooksApiClient {

    @GetMapping
    public BooksApiResponse getBooks(@RequestParam("q") String query);

}
