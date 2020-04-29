package mainservice;

import mainservice.models.BookInfo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "google-books-api-service")
@RibbonClient(name = "google-books-api-service")
public interface BooksApiServiceProxy {

    @GetMapping("/google-books-api-service/find/{q}")
    public List<BookInfo> retrieveBooksFromApi(@PathVariable("q") String query);

}
