package qu.task.so.extractor.service;

import qu.task.so.extractor.domain.Question;

import java.util.List;

public interface StackOverflowExtractorService {
    List<Question> getNewestQuestions();

    List<Question> getMostVotedQuestions();

    List<Question> getParametricQuestions();

    Question getNewestQuestion(String questionId);

    Question getMostVotedQuestion(String questionId);

    Question getParametricQuestion(String questionId);
}
