package mainservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import mainservice.models.BookInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoProvider {

    public static String queryURL(String query) {

        return "http://book-info-service/getBook/" + query;
    }

    public JsonNode getBookResponse(String query) {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode response = restTemplate.getForObject(queryURL(query), JsonNode.class);
        return response;
    }

    public List<BookInfo> getBookInfo(JsonNode response) {

        List<BookInfo> listOfBooks = new ArrayList<>();
        int size = response.size();
        for (int i = 0; i < size; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setAuthor(response.get("author").asText());
            bookInfo.setTitle(response.get("title").asText());
            listOfBooks.add(bookInfo);
        }
        return listOfBooks;
    }
}

