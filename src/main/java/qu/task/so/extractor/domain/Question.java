package qu.task.so.extractor.domain;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String id;
    private String url;
    private Stats stats;
    private String title;
    private String summary;
    private List<Tag> tags;
    private List<UserInfo> userInfos;

    protected Question() {
    }

    public Question(String url, Stats stats, String title, String summary, List<Tag> tags, List<UserInfo> userInfos) {
        this.id = url.split("/")[2];
        this.url = url;
        this.stats = stats;
        this.title = title;
        this.summary = summary;
        this.tags = tags;
        this.userInfos = userInfos;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Stats getStats() {
        return stats;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", stats=" + stats +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", tags=" + tags +
                ", userInfos=" + userInfos +
                '}';
    }
}
