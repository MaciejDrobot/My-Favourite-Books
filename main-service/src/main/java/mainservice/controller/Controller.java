package mainservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import mainservice.models.BookInfo;
import mainservice.service.BookInfoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/search")
public class Controller {

    private final BookInfoProvider provider;

    public Controller(@Autowired BookInfoProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    @RequestMapping("/{query)")
    public String index(@PathVariable("query") String query, Model model){

        JsonNode response = provider.getBookResponse(query);
        List<BookInfo> list = provider.getBookInfo(response);
        model.addAttribute("results", list);
        return "results";
    }
}
