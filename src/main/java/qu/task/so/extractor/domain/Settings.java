package qu.task.so.extractor.domain;

public class Settings {
    private String questionType;

    protected Settings() {
    }

    public Settings(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
