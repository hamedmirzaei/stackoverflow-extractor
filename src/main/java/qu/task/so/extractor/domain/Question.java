package qu.task.so.extractor.domain;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String url;
    private Stats stats;
    private String title;
    private String summary;
    private List<Tag> tags;
    private List<UserInfo> userInfos;

    public Question() {
    }

    public Question(String url, Stats stats, String title, String summary, List<Tag> tags, List<UserInfo> userInfos) {
        this.url = url;
        this.stats = stats;
        this.title = title;
        this.summary = summary;
        this.tags = tags;
        this.userInfos = userInfos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public String toString() {
        return "Question{" +
                "url='" + url + '\'' +
                ", stats=" + stats +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", tags=" + tags +
                ", userInfos=" + userInfos +
                '}';
    }
}
