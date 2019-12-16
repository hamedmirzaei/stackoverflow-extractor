package qu.task.so.extractor.domain;

import lombok.*;

public class Stats {
    private Integer votes;
    private Integer answers;
    private Integer views;

    public Stats() {
    }

    public Stats(Integer votes, Integer answers, Integer views) {
        this.votes = votes;
        this.answers = answers;
        this.views = views;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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
