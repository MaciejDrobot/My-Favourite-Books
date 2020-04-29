package mainservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import mainservice.BooksApiServiceProxy;
import mainservice.models.BookInfo;
import mainservice.service.BookInfoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/search")
@RestController
public class Controller {

    @Autowired
    private BookInfoProvider provider;

    @Autowired
    private BooksApiServiceProxy proxy;


    @GetMapping
    @RequestMapping("/{query)")
    public String index(@PathVariable("query") String query, Model model){

        JsonNode response = provider.getBookResponse(query);
        List<BookInfo> list = provider.getBookInfo(response);
        model.addAttribute("results", list);
        return "results";
    }

    @GetMapping("/from-api-service/{query}")
    public List<BookInfo> getBooksFromApi(@PathVariable("query") String query){
        return proxy.retrieveBooksFromApi(query);
    }
}
