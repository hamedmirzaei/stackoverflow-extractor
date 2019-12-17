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
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StackOverflowExtractorServiceImpl implements StackOverflowExtractorService {

    private Map<String, Question> newestQuestions = new HashMap<>();
    private Map<String, Question> mostvotedQuestions = new HashMap<>();

    @Override
    public List<Question> getNewestQuestions() {
        if (newestQuestions.size() != 0)
            return newestQuestions.values().stream().collect(Collectors.toList());
        newestQuestions.clear();
        try {
            List<Question> questions = getQuestionsFromUrl(Constants.STACKOVERFLOW_NEWEST_URL);
            questions.stream().forEach(question -> newestQuestions.put(question.getId(), question));
            return questions;
        } catch (IOException e) {
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Question> getMostVotedQuestions() {
        mostvotedQuestions.clear();
        try {
            List<Question> questions = getQuestionsFromUrl(Constants.STACKOVERFLOW_MOSTVOTE_URL);
            questions.stream().forEach(question -> mostvotedQuestions.put(question.getId(), question));
            return questions;
        } catch (IOException e) {
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Question getNewestQuestion(String questionId) {
        Question question = this.newestQuestions.get(questionId);
        try {
            setBodyAndAnswerOfQuestion(question);
        } catch (IOException e) {
        }

        return question;
    }

    @Override
    public Question getMostVotedQuestion(String questionId) {
        Question question = this.mostvotedQuestions.get(questionId);
        try {
            setBodyAndAnswerOfQuestion(question);
        } catch (IOException e) {
        }
        return question;
    }

    private void setBodyAndAnswerOfQuestion(Question question) throws IOException {
        String body = "";
        String answers = "";
        Document doc = Jsoup.connect(Constants.BASE_URL + question.getUrl()).get();
        Elements bodyElements = doc.getElementsByClass("postcell post-layout--right").get(0).getElementsByClass("post-text");
        for (Element bodyElement : bodyElements) {
            body += bodyElement.toString() + "\n";
        }
        Elements answerElements = doc.getElementById("answers").getElementsByClass("post-text");
        for (Element answerElement : answerElements) {
            answers += answerElement.toString() + "\n";
        }
        question.setBody(body);
        question.setAnswers(answers);
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

            Elements accepteds = questionSummary.getElementsByClass("answered-accepted");
            Stats stats;
            if (accepteds != null && accepteds.size() != 0)
                stats = new Stats(votes, answers, views.replace("views", "").trim(), true);
            else
                stats = new Stats(votes, answers, views.replace("views", "").trim(), false);


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
                String actionTime = "";
                Elements actionTimeElements = userInfoElement.getElementsByClass("user-action-time");
                if (actionTimeElements.size() == 1)
                    actionTime = actionTimeElements.get(0).text();
                String userName = "";
                Elements userDetailElements = userInfoElement.getElementsByClass("user-details");

                Integer goldBadges = 0;
                Integer silverBadges = 0;
                Integer bronzeBadges = 0;
                String reputationScore = "0";
                if (userDetailElements.size() > 1) {
                    Elements userNameElements = userDetailElements.get(userDetailElements.size() - 1).getElementsByTag("a");
                    if (userNameElements.size() == 1)
                        userName = userNameElements.get(0).text();
                    else
                        userName = userNameElements.get(userNameElements.size() - 1).text();
                } else {
                    Elements userNameElements = userDetailElements.get(0).getElementsByTag("a");
                    if (userNameElements.size() == 1)
                        userName = userNameElements.get(0).text();

                    Elements reputationScoreElements = userInfoElement.getElementsByClass("reputation-score");
                    if (reputationScoreElements != null && reputationScoreElements.size() != 0)
                        reputationScore = reputationScoreElements.get(0).text();

                    Elements goldElements = userInfoElement.getElementsByClass("badge1");
                    if (goldElements != null && goldElements.size() != 0) {
                        goldBadges = Integer.parseInt(goldElements.get(0).nextElementSibling().text());
                    }

                    Elements silverElements = userInfoElement.getElementsByClass("badge2");
                    if (silverElements != null && silverElements.size() != 0) {
                        silverBadges = Integer.parseInt(silverElements.get(0).nextElementSibling().text());
                    }

                    Elements bronzeElements = userInfoElement.getElementsByClass("badge3");
                    if (bronzeElements != null && bronzeElements.size() != 0) {
                        bronzeBadges = Integer.parseInt(bronzeElements.get(0).nextElementSibling().text());
                    }
                }

                userInfos.add(new UserInfo(actionTime, userName, reputationScore, goldBadges, silverBadges, bronzeBadges));
            }
            result.add(new Question(url, stats, title, summary, tags, userInfos));
            if (result.size() == 10)
                return result;
        }
        return result;
    }
}
