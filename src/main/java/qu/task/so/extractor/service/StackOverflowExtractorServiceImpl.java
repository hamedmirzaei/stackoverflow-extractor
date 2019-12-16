package qu.task.so.extractor.service;

import org.springframework.stereotype.Service;
import qu.task.so.extractor.domain.Question;

import java.util.List;

@Service
public class StackOverflowExtractorServiceImpl implements StackOverflowExtractorService {

    @Override
    public List<Question> getNewestQuestions() {
        return null;
    }

    @Override
    public List<Question> getMostVotedQuestions() {
        return null;
    }
}
