package dev.mdrobot.mainservice.controller;

import dev.mdrobot.mainservice.models.ListOfBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Controller
@RequestMapping("/searchBook")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @RequestMapping("/{query)")
    public String index(@PathVariable("query") String query, Model model){
        ListOfBooks results = restTemplate.getForObject("http://book-info-service/getBook" + query, ListOfBooks.class);
        model.addAttribute("results", results);
        return "results";
    }
}
