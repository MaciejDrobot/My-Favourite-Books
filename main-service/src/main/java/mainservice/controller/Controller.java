package mainservice.controller;

import mainservice.models.BookInfo;
import mainservice.service.BooksApiServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@RestController
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private BooksApiServiceProxy proxy;


    @GetMapping("/find/{query}")
    public List<BookInfo> getBooksFromApi(@PathVariable("query") String query){
        return proxy.retrieveBooksFromApi(query);

    }

    @GetMapping("/index")
    public String returnIndexPage() {
        return "index";

    }

    @GetMapping("/results/{query}")
    public String returnResultsPage(@PathVariable("query") String query, Model model) {
        List<BookInfo> searchResults = proxy.retrieveBooksFromApi(query);
        model.addAttribute("results", searchResults);
        return "results";

    }

    @GetMapping("/resultsD")
    public String returnResultsPage() {

        return "results";

    }


}
