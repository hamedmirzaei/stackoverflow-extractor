package qu.task.so.extractor.domain;

public class Settings {
    private String questionType;
    private String questionTopic;

    protected Settings() {
    }

    public Settings(String questionType, String questionTopic) {
        this.questionType = questionType;
        this.questionTopic = questionTopic;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic) {
        this.questionTopic = questionTopic;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "questionType='" + questionType + '\'' +
                ", questionTopic='" + questionTopic + '\'' +
                '}';
    }
}
