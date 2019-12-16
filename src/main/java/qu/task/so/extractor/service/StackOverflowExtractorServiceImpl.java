package qu.task.so.extractor.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import qu.task.so.extractor.domain.Question;
import qu.task.so.extractor.domain.Stats;
import qu.task.so.extractor.domain.Tag;
import qu.task.so.extractor.domain.UserInfo;
import qu.task.so.extractor.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StackOverflowExtractorServiceImpl implements StackOverflowExtractorService {

    @Override
    public List<Question> getNewestQuestions() {
        try {
            getQuestionsFromUrl(Constants.STACKOVERFLOW_NEWEST_URL);
        } catch (IOException e) {
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Question> getMostVotedQuestions() {
        try {
            getQuestionsFromUrl(Constants.STACKOVERFLOW_MOSTVOTE_URL);
        } catch (IOException e) {
        }
        return Collections.EMPTY_LIST;
    }

    private List<Question> getQuestionsFromUrl(String questionsUrl) throws IOException {
        List<Question> result = new ArrayList<>();
        Document doc = Jsoup.connect(questionsUrl).get();
        Element questions = doc.getElementById("questions");
        Elements questionSummaries = questions.getElementsByClass("question-summary");
        for (Element questionSummary : questionSummaries) {
            String votes = questionSummary.getElementsByClass("vote-count-post").get(0).getElementsByTag("strong").text();
            String answers = questionSummary.getElementsByClass("status").get(0).getElementsByTag("strong").text();
            String views = questionSummary.getElementsByClass("views").get(0).text();
            Stats stats = new Stats(Integer.parseInt(votes), Integer.parseInt(answers), Integer.parseInt(views.replace("views", "").trim()));


            String title = questionSummary.getElementsByClass("question-hyperlink").get(0).text();
            String url = questionSummary.getElementsByClass("question-hyperlink").get(0).attributes().get("href");

            String summary = questionSummary.getElementsByClass("excerpt").get(0).text();

            List<Tag> tags = new ArrayList<>();
            Elements tagElements = questionSummary.getElementsByClass("post-tag");
            for (Element tagElement : tagElements) {
                tags.add(new Tag(tagElement.text()));
            }

            List<UserInfo> userInfos = new ArrayList<>();
            Elements userInfoElements = questionSummary.getElementsByClass("user-info");
            for (Element userInfoElement : userInfoElements) {
                String actionTime = userInfoElement.getElementsByClass("user-action-time").get(0).text();
                String userName = userInfoElement.getElementsByClass("user-details").get(0).getElementsByTag("a").get(0).text();
                Integer reputationScore = Integer.parseInt(userInfoElement.getElementsByClass("reputation-score").get(0).text().replace(",", ""));

                Integer goldBadges = 0;
                Elements goldElements = userInfoElement.getElementsByClass("badge1");
                if (goldElements != null && goldElements.size() != 0) {
                    goldBadges = Integer.parseInt(goldElements.get(0).nextElementSibling().text());
                }

                Integer silverBadges = 0;
                Elements silverElements = userInfoElement.getElementsByClass("badge2");
                if (silverElements != null && silverElements.size() != 0) {
                    silverBadges = Integer.parseInt(silverElements.get(0).nextElementSibling().text());
                }

                Integer bronzeBadges = 0;
                Elements bronzeElements = userInfoElement.getElementsByClass("badge3");
                if (bronzeElements != null && bronzeElements.size() != 0) {
                    bronzeBadges = Integer.parseInt(bronzeElements.get(0).nextElementSibling().text());
                }
                userInfos.add(new UserInfo(actionTime, userName, reputationScore, goldBadges, silverBadges, bronzeBadges));
            }
            result.add(new Question(url, stats, title, summary, tags, userInfos));
        }
        return result;
    }
}
