package qu.task.so.extractor.domain;

public class Stats {
    private Integer votes;
    private Integer answers;
    private Integer views;

    protected Stats() {
    }

    public Stats(Integer votes, Integer answers, Integer views) {
        this.votes = votes;
        this.answers = answers;
        this.views = views;
    }

    public Integer getVotes() {
        return votes;
    }

    public Integer getAnswers() {
        return answers;
    }

    public Integer getViews() {
        return views;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "votes=" + votes +
                ", answers=" + answers +
                ", views=" + views +
                '}';
    }
}
