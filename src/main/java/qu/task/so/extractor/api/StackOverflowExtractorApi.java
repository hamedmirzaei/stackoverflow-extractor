package qu.task.so.extractor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import qu.task.so.extractor.domain.Settings;
import qu.task.so.extractor.service.StackOverflowExtractorService;
import qu.task.so.extractor.utils.Constants;

import java.io.IOException;

@Controller
public class StackOverflowExtractorApi {

    private StackOverflowExtractorService stackOverflowExtractorService;

    @GetMapping("/")
    private String handleIndexPage1(Model model) {
        return "redirect:/index";
    }

    @GetMapping("/index")
    private String handleIndexPage2(Model model) {
        model.addAttribute("message", "Welcome to Top 10 StackOverflow Question Extractor Website!");
        return "index";
    }

    @GetMapping("/newest")
    private String handleNewestPage(Model model) throws IOException {
        model.addAttribute("message", "Top 10 Newest Questions from StrackOverflow.com!");
        model.addAttribute("newest", "true");
        model.addAttribute("preurl", "/newest/");
        model.addAttribute("questions", stackOverflowExtractorService.getNewestQuestions());
        return "questions";
    }

    @GetMapping("/newest/{qid}")
    private String handleNewestQuestionPage(Model model, @PathVariable String qid) throws IOException {
        model.addAttribute("newest", "true");
        model.addAttribute("baseUrl", Constants.BASE_URL);
        model.addAttribute("question", stackOverflowExtractorService.getNewestQuestion(qid));
        return "question";
    }


    @GetMapping("/mostvoted")
    private String handleMostVotedPage(Model model) {
        model.addAttribute("message", "Top 10 Most Voted Questions from StrackOverflow.com!");
        model.addAttribute("mostvoted", "true");
        model.addAttribute("preurl", "/mostvoted/");
        model.addAttribute("questions", stackOverflowExtractorService.getMostVotedQuestions());
        return "questions";
    }

    @GetMapping("/mostvoted/{qid}")
    private String handleMostVotedQuestionPage(Model model, @PathVariable String qid) throws IOException {
        model.addAttribute("mostvoted", "true");
        model.addAttribute("baseUrl", Constants.BASE_URL);
        model.addAttribute("question", stackOverflowExtractorService.getMostVotedQuestion(qid));
        return "question";
    }

    @GetMapping("/questions")
    private String handleParametricQuestionsPage(Model model) {
        model.addAttribute("message", "Top 10 " + Constants.settings.getQuestionType() + " Questions for " + Constants.settings.getQuestionTopic() + " from StrackOverflow.com!");
        model.addAttribute("parametrics", "true");
        model.addAttribute("preurl", "/questions/");
        model.addAttribute("questions", stackOverflowExtractorService.getParametricQuestions());
        return "questions";
    }

    @GetMapping("/questions/{qid}")
    private String handleParametricQuestionPage(Model model, @PathVariable String qid) throws IOException {
        model.addAttribute("parametrics", "true");
        model.addAttribute("baseUrl", Constants.BASE_URL);
        model.addAttribute("question", stackOverflowExtractorService.getParametricQuestion(qid));
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
        Constants.settings.setQuestionTopic(settings.getQuestionTopic());
        Constants.settings.setQuestionType(settings.getQuestionType());
        return "redirect:/questions";
    }

    @Autowired
    public void setStackOverflowExtractorService(StackOverflowExtractorService stackOverflowExtractorService) {
        this.stackOverflowExtractorService = stackOverflowExtractorService;
    }
}
