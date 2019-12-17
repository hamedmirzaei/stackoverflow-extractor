package qu.task.so.extractor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import qu.task.so.extractor.domain.Settings;
import qu.task.so.extractor.service.StackOverflowExtractorService;
import qu.task.so.extractor.utils.Constants;

import java.io.IOException;

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
        model.addAttribute("message", "Welcome to Top 10 StackOverflow Question Extractor Website!");
        return "index";
    }

    @GetMapping("/newest")
    private String handleNewestPage(Model model) throws IOException {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Top 10 Newest Questions from StrackOverflow.com!");
        model.addAttribute("newest", "true");
        model.addAttribute("questions", stackOverflowExtractorService.getNewestQuestions());
        return "questions";
    }

    @GetMapping("/newest/{qid}")
    private String handleNewestQuestionPage(Model model, @PathVariable String qid) throws IOException {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("newest", "true");
        model.addAttribute("baseUrl", Constants.BASE_URL);
        model.addAttribute("question", stackOverflowExtractorService.getNewestQuestion(qid));
        return "question";
    }


    @GetMapping("/mostvoted")
    private String handleMostVotedPage(Model model) {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("message", "Top 10 Most Voted Questions from StrackOverflow.com!");
        model.addAttribute("mostvoted", "true");
        model.addAttribute("questions", stackOverflowExtractorService.getMostVotedQuestions());
        return "questions";
    }

    @GetMapping("/mostvoted/{qid}")
    private String handleMostVotedQuestionPage(Model model, @PathVariable String qid) throws IOException {

        //for getting info from stackoverflow
        RestTemplate restTemplate = new RestTemplate();
        model.addAttribute("mostvoted", "true");
        model.addAttribute("baseUrl", Constants.BASE_URL);
        model.addAttribute("question", stackOverflowExtractorService.getMostVotedQuestion(qid));
        return "question";
    }

    @GetMapping("/settings")
    public String greetingForm(Model model) {
        model.addAttribute("message", "Settings of Application!");
        model.addAttribute("settings", Constants.settings);
        return "settings";
    }

    @PostMapping("/settings")
    public String greetingSubmit(@ModelAttribute Settings settings) {
        return "settings";
    }

    @Autowired
    public void setStackOverflowExtractorService(StackOverflowExtractorService stackOverflowExtractorService) {
        this.stackOverflowExtractorService = stackOverflowExtractorService;
    }
}
