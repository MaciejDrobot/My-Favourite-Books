package dev.mdrobot.booksinfoservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import dev.mdrobot.booksinfoservice.model.BookInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoProvider {

//    @Value("${API_KEY}")
//    private String API_KEY;

    public static String queryURL(String query) {
        return "https://www.googleapis.com/books/v1/volumes?q=" + query;
    }

    public JsonNode getBookResponse(String query) {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode response = restTemplate.getForObject(queryURL(query), JsonNode.class);
        return response;
    }

    public List<BookInfo> getBookInfo(JsonNode response) {

        List<BookInfo> listOfBooks = new ArrayList<>();

        int numberOfBooks = response.get("items").size();

        for (int i = 0; i < numberOfBooks; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setAuthor(response.get("items").get(i).get("volumeInfo").get("authors").get(0).asText());
            bookInfo.setTitle(response.get("items").get(i).get("volumeInfo").get("title").asText());
            listOfBooks.add(bookInfo);
        }
        return listOfBooks;
    }
}

