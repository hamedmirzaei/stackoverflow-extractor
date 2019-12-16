package qu.task.so.extractor.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class StackOverflowExtractorApi {

    final String STACKOVERFLOW_URL = "https://stackoverflow.com/";

    @GetMapping("/")
    private String handleRealRequest(Model model) {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Hello World!");

        return "index";
    }

    @GetMapping("/newest")
    private String handleLegalRequest(Model model) {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Hello World From Newest!");

        return "newest";
    }


    @GetMapping("/mostvoted")
    private String handleParallelRequest(Model model) {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Hello World From Most Voted!");

        return "mostvoted";
    }

}
