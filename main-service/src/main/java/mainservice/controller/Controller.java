package mainservice.controller;

import mainservice.models.BookInfo;
import mainservice.models.LoadBalancerTest;
import mainservice.service.BooksApiServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private BooksApiServiceProxy proxy;


    @GetMapping("/find/{query}")
    public List<BookInfo> getBooksFromApi(@PathVariable("query") String query){
        return proxy.retrieveBooksFromApi(query);
    }

    @GetMapping("/balancer/{query}")
    public LoadBalancerTest loadBalancerTest(@PathVariable("query") String query){
        return proxy.balancerTest(query);
    }

}
