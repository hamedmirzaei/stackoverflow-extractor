package qu.task.so.extractor.domain;

public class Stats {
    private String votes;
    private String answers;
    private String views;
    private Boolean answerAccepted;

    protected Stats() {
    }

    public Stats(String votes, String answers, String views, Boolean answerAccepted) {
        this.votes = votes;
        this.answers = answers;
        this.views = views;
        this.answerAccepted = answerAccepted;
    }

    public String getVotes() {
        return votes;
    }

    public String getAnswers() {
        return answers;
    }

    public String getViews() {
        return views;
    }

    public Boolean getAnswerAccepted() {
        return answerAccepted;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "votes='" + votes + '\'' +
                ", answers='" + answers + '\'' +
                ", views='" + views + '\'' +
                ", answerAccepted=" + answerAccepted +
                '}';
    }
}
