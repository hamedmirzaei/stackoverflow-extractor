package qu.task.so.extractor.domain;

public class Stats {
    private String votes;
    private String answers;
    private String views;

    protected Stats() {
    }

    public Stats(String votes, String answers, String views) {
        this.votes = votes;
        this.answers = answers;
        this.views = views;
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

    @Override
    public String toString() {
        return "Stats{" +
                "votes='" + votes + '\'' +
                ", answers='" + answers + '\'' +
                ", views='" + views + '\'' +
                '}';
    }
}
