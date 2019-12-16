package qu.task.so.extractor.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import qu.task.so.extractor.domain.Question;
import qu.task.so.extractor.domain.Stats;
import qu.task.so.extractor.utils.Constants;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class StackOverflowExtractorServiceImpl implements StackOverflowExtractorService {

    @Override
    public List<Question> getNewestQuestions() throws IOException {
        Document doc = Jsoup.connect(Constants.STACKOVERFLOW_NEWEST_URL).get();
        Element questions = doc.getElementById("questions");
        Elements questionSummaries = questions.getElementsByClass("question-summary");
        for (Element questionSummary : questionSummaries) {
            String votes = questionSummary.getElementsByClass("vote-count-post").get(0).getElementsByTag("strong").text();
            String answers = questionSummary.getElementsByClass("status").get(0).getElementsByTag("strong").text();
            String views = questionSummary.getElementsByClass("views").get(0).text();
            Stats stats = new Stats(Integer.parseInt(votes), Integer.parseInt(answers), Integer.parseInt(views.replace("views","").trim()));
            System.out.println(votes);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Question> getMostVotedQuestions() {
        return Collections.emptyList();
    }
}
