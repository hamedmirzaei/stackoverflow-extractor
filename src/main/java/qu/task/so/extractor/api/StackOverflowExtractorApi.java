package qu.task.so.extractor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import qu.task.so.extractor.domain.Question;
import qu.task.so.extractor.service.StackOverflowExtractorService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StackOverflowExtractorApi {

    private StackOverflowExtractorService stackOverflowExtractorService;

    @GetMapping("/")
    private String handleIndexAndSettingPage1(Model model) {
        return "redirect:/index";
    }

    @GetMapping("/index")
    private String handleIndexAndSettingPage2(Model model) {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Hello World!");
        return "index";
    }

    @GetMapping("/newest")
    private String handleNewestPage(Model model) throws IOException {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Welcome to Newest Page!");
        model.addAttribute("questions", stackOverflowExtractorService.getNewestQuestions());
        return "newest";
    }

    @GetMapping("/newest/{qid}")
    private String handleNewestQuestionPage(Model model, @PathVariable String qid) throws IOException {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Welcome to Question " + qid + " Page!");
        return "question";
    }


    @GetMapping("/mostvoted")
    private String handleMostVotedPage(Model model) {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Hello World From Most Voted!");
        model.addAttribute("questions", stackOverflowExtractorService.getMostVotedQuestions());
        return "mostvoted";
    }

    @Autowired
    public void setStackOverflowExtractorService(StackOverflowExtractorService stackOverflowExtractorService) {
        this.stackOverflowExtractorService = stackOverflowExtractorService;
    }
}
